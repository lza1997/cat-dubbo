package com.zs.cat.monitor.base.service;

import java.util.Date;

import com.zs.cat.monitor.base.bean.TCsmMonitorNoticelog;

/**
 * 
 * File                 : IMonitorNoticelogService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月19日 上午11:16:02 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
public interface IMonitorNoticelogService {
	/**
	 * 新增noticelog数据
	 * 
	 * @version: 1.00
	 * @history: 2015年6月19日 上午11:19:56 [created]
	 * @author hx 黄湘
	 * @param monitorId 监控ID
	 * @param monitorName 监控名称
	 * @param staffId 人员ID
	 * @param staffName 人员名称
	 * @param noticeType 通知类型
	 * @param noticeObj 通知对象
	 * @param noticeContent 通知内容 
	 * @param noticeTime 通知时间
	 * @param stat 状态
	 * @return
	 * @see
	 */
	public TCsmMonitorNoticelog doInsertMonitorNoticeLog(String monitorId,String monitorName,String staffId,String staffName,String noticeType,
			String noticeObj,String noticeContent, Date noticeTime,String stat);
	
	/**
	 * 修改noticelog数据
	 * 
	 * @version: 1.00
	 * @history: 2015年6月19日 上午11:27:06 [created]
	 * @author hx 黄湘
	 * @param log TCsmMonitorNoticelog对象
	 * @return
	 * @see
	 */
	public String updateMonitorNoticeLog(TCsmMonitorNoticelog log);

	/**
	 * 根据人员ID、监控ID、通知方式获取该人员当天发送过的通知次数
	 *
	 * @version: 1.00
	 * @history: 2015年8月13日 上午10:21:30 [created]
	 * @author hx 黄湘
	 * @param log
	 * @return
	 * @see
	 */
//	public int checkPreviewNotice(Long staffId,Long monitorId,String noticeType,Date beginTime,Date endTime);
	public int checkPreviewNotice(TCsmMonitorNoticelog log);

}
