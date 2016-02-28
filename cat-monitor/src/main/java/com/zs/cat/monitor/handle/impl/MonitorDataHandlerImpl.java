package com.zs.cat.monitor.handle.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.bestpay.bpcs.commons.utils.ConstantsUtils;
import com.bestpay.bpcs.commons.utils.DateUtils;
import com.bestpay.bpcs.commons.utils.ResponseUtils;
import com.bestpay.pay.foundation.service.SmsSendService;
import com.bestpay.pay.foundation.service.model.request.SmsSendByContentRequest;
import com.bestpay.pay.foundation.service.model.response.ExternalResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
import com.zs.cat.monitor.base.bean.TCscMonitorNoticereal;
import com.zs.cat.monitor.base.bean.TCscMonitorStaff;
import com.zs.cat.monitor.base.bean.TCscMonitorTemplate;
import com.zs.cat.monitor.base.bean.TCsmMonitorNoticelog;
import com.zs.cat.monitor.base.service.IMonitorConfigService;
import com.zs.cat.monitor.base.service.IMonitorNoticelogService;
import com.zs.cat.monitor.base.service.IMonitorNoticerealService;
import com.zs.cat.monitor.base.service.IMonitorStaffService;
import com.zs.cat.monitor.base.service.IMonitorTemplateService;
import com.zs.cat.monitor.handle.IMonitorDataHandler;
import com.zs.cat.monitor.sendnotice.email.ISpringMailSenderService;

/**
 *
 * File                 : MonitorDataHandlerImpl.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月18日 上午9:59:27 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
@Component("MonitorDataHandler")
public class MonitorDataHandlerImpl implements IMonitorDataHandler{

	private static final Logger LOG = LoggerFactory.getLogger(MonitorDataHandlerImpl.class);

	@Resource(name = "monitorConfigService")
	IMonitorConfigService monitorConfigService;

	@Resource(name = "monitorNoticerealService")
	IMonitorNoticerealService monitorNoticerealService;

	@Resource(name = "monitorNoticelogService")
	IMonitorNoticelogService monitorNoticelogService;

	@Resource(name = "monitorTemplateService")
	IMonitorTemplateService monitorTemplateService;

	@Resource(name = "monitorStaffService")
	IMonitorStaffService monitorStaffService;

	@Resource(name = "springMailSenderService")
	ISpringMailSenderService springMailSenderService;

	@Resource(name = "jdbcTemplate")
	JdbcTemplate jdbcTemplate;

	@Autowired
	SmsSendService smsSendService;

	@Override
	public void processFileByMonitorCode(String monitorCode) {
		try {
			TCscMonitorConfig config=monitorConfigService.getMonitorConfigByMonitorCode(monitorCode);
			if(config!=null){
				//监控取数脚本
				String sqlScript=config.getMonitorScript();
				Double count=getCountBySqlScript(sqlScript);
				//监控阀值
				Long threshold=config.getThreshold();
				//比较方式
				String compareType=config.getCompareType();
				//通知次数阀值
				Long noticeNum=config.getNoticeNum();
				//判断监控取数是否超过阀值
				if(comapre(count, threshold, compareType)){
					List<TCscMonitorNoticereal> noticeRealList=monitorNoticerealService.getMonitorNoticerealByMonitorId(config.getMonitorId());
					//多个人员、多个方式、多个模板发送信息
					for(int i=0;i<noticeRealList.size();i++){
						TCscMonitorNoticereal noticeReal=noticeRealList.get(i);
						TCscMonitorTemplate template=monitorTemplateService.getMonitorTemplateByTemplateId(noticeReal.getTemplateId());
						//通知方式
						String noticeType=noticeReal.getNoticeType();
						//模板内容
						String templateContent=getSmsBySqlScript(template.getTemplateContent());
						String[] staffIdList=noticeReal.getStaffId().split(",");
						//根据人员集合，分别对每个人员发送消息
						if(staffIdList!=null){
							for(int j=0;j<staffIdList.length;j++){
								TCscMonitorStaff staff=monitorStaffService.getMonitorStaffByStaffId(staffIdList[j]);
								if(ConstantsUtils.StatDifine.UNHANDLE.equals(staff.getStat())){
									TCsmMonitorNoticelog log=new TCsmMonitorNoticelog();
									log.setMonitorId(config.getMonitorId());
									log.setNoticeType(noticeType);
									log.setStaffId(staff.getStaffId());
									log.setStat("S0C");
									//如果已发送次数超过阀值，则不再发送信息
									if(isOverNoticeNum(log,noticeNum)){
										LOG.info("已经超过通知次数阀值，无需再次发送！");
									}
									else{
										TCsmMonitorNoticelog newLog=monitorNoticelogService.doInsertMonitorNoticeLog
												(config.getMonitorId(),config.getMonitorName(),staff.getStaffId(), staff.getStaffName(),
														noticeType, staff.getStaffId().toString(), templateContent, new Date(), "S0A");
										LOG.info(sendMessage(staff, templateContent, templateContent, noticeType, newLog));
										monitorNoticelogService.updateMonitorNoticeLog(newLog);
									}
								}
							}

						}

					}


				}
				else{
					LOG.debug("没有越过阀值，无需发送信息！");
				}

			}
		} catch (Exception e) {
			LOG.error("异常通知出错!", e);
			e.printStackTrace();
		}
	}

	/**
	 * 根据监控取数脚本返回数值
	 *
	 * @version: 1.00
	 * @history: 2015年6月18日 上午10:05:29 [created]
	 * @author hx 黄湘
	 * @param sqlScript
	 * @return
	 * @see
	 */
	public Double getCountBySqlScript(String sqlScript){
		Double count=0d;
		try {
			count=jdbcTemplate.queryForObject(sqlScript,Double.class);
		} catch (Exception e) {
			LOG.error("脚本取值失败!", e);
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据监控模板脚本获取自定义短信内容
	 *
	 * @version: 1.00
	 * @history: 2016年2月23日 上午10:05:29 [created]
	 * @author hx 黄湘
	 * @param sqlScript
	 * @return
	 * @see
	 */
	public String getSmsBySqlScript(String sqlScript){
		String smsTemplate="";
		try {
			smsTemplate=jdbcTemplate.queryForObject(sqlScript,String.class);
		} catch (Exception e) {
			LOG.error("获取自定义短信内容失败!", e);
			e.printStackTrace();
			return smsTemplate;
		}
		return smsTemplate;
	}

	/**
	 * 根据阀值、监控取数、比较方式判断是否越值
	 *
	 * @version: 1.00
	 * @history: 2015年6月18日 上午10:21:30 [created]
	 * @author hx 黄湘
	 * @param threshold
	 * @param count
	 * @param compareType
	 * @return
	 * @see
	 */
	public boolean comapre(Double count,Long threshold,String compareType){
		try {
			if(compareType==">="||compareType.equals(">=")){
				return count>=threshold;
			}
			else if(compareType==">"||compareType.equals(">")){
				return count>threshold;
			}
			else if(compareType=="<="||compareType.equals("<=")){
				return count<=threshold;
			}
			else if(compareType=="<"||compareType.equals("<")){
				return count<threshold;
			}
			else if(compareType=="<>"||compareType.equals("<>")){
				return count!=threshold/1;
			}
			else if(compareType=="="||compareType.equals("=")){
				return count==threshold/1;
			}
		} catch (Exception e) {
			LOG.error("越值判断失败!", e);
			e.printStackTrace();
			return false;
		}
		return false;

	}

	/**
	 * 根据人员ID、监控ID、通知方式、通知次数阀值判断该人员当天发送过的通知次数是否超过阀值
	 *
	 * @version: 1.00
	 * @history: 2015年8月13日 上午10:21:30 [created]
	 * @author hx 黄湘
	 * @param noticeNum
	 * @return
	 * @see
	 */
	public boolean isOverNoticeNum(TCsmMonitorNoticelog log,Long noticeNum){
		int count=monitorNoticelogService.checkPreviewNotice(log);
		if(count>=noticeNum){
			return true;
		}
		return false;
	}

	/**
	 * 传入收件人、主题、内容、发送方式，进行信息发送
	 *
	 * @version: 1.00
	 * @history: 2015年8月11日 下午4:40:46 [created]
	 * @author hx 黄湘
	 * @param monitorStaff
	 * @param setSubject
	 * @param setText
	 * @param noticeType
	 * @return
	 * @see
	 */
	public String sendMessage(TCscMonitorStaff monitorStaff,String setSubject,String setText,String noticeType,TCsmMonitorNoticelog log){
		String result=null;
		if(noticeType=="TEL"||noticeType.equals("TEL")){
			//修改为待通知，定时扫描待通知表进行短信发送
			String msg = this.sendSms(monitorStaff.getStaffTel(), setText, log.getLogId());//调用短信接口发送短信
			log.setStat("S0A");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
		}
		else if(noticeType=="EMAIL"||noticeType.equals("EMAIL")){
			try {
				//失败重发次数
				for(int i=1;i<=5;i++){
					if(springMailSenderService.simpleSend(monitorStaff.getStaffEmail(), setSubject, setText)){
						log.setStat("S0C");
						break;
					}
					else{
						log.setStat("S0X");
					}
				}
//				springMailSenderService.simpleSend(setTo, setSubject, setText);
//				log.setStat("SOC");
				result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			} catch (Exception e) {
				log.setStat("S0X");
				LOG.error("发送邮件失败!", e);
				e.printStackTrace();
				result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			}

		}
		return result;
	}


	/**
	 * 发送短信接口
	 * @version: 1.00
	 * @history: 2016年1月6日 下午5:58:05 [created]
	 * @author suqb
	 * @param mobile 手机号码,多个手机号需要用","拼接
	 * @param content
	 * @param initiationID 日志流水
	 * @return
	 * @see
	 */
	public  String sendSms(String mobile,String content,String initiationID){
		String result = "success";
		try {
			LOG.info("调用接口发送短信：\n"+mobile+"-----\n"+initiationID+"------\n"+content);
			SmsSendByContentRequest request = new SmsSendByContentRequest();
			request.setSource("BPCS");
			request.setMobile(mobile);
			request.setContent(content);
			request.setInitiationID(initiationID);
			ExternalResponse<Boolean> msg = smsSendService.smsSendMessage(request);
			LOG.info("返回结果"+msg);
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		return result;
	}
}
