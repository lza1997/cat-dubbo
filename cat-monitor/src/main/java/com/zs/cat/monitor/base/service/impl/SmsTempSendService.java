package com.zs.cat.monitor.base.service.impl;

import com.bestpay.bpcs.commons.utils.DateUtils;
import com.bestpay.pay.foundation.service.SmsSendService;
import com.bestpay.pay.foundation.service.model.request.SmsSendByContentRequest;
import com.bestpay.pay.foundation.service.model.response.ExternalResponse;
import com.zs.cat.monitor.base.bean.TSmsTempSend;
import com.zs.cat.monitor.base.dao.TSmsTempSendMapper;
import com.zs.cat.monitor.base.service.ISmsTempSendService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * File                 : SmsTempSendService
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2016/1/19 10:35 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
@Slf4j
@Service("smsTempSendService")
public class SmsTempSendService implements ISmsTempSendService {
    @Resource
    private TSmsTempSendMapper tSmsTempSendMapper;
    @Resource
    SmsSendService smsSendService;

    public void updateTableFlag(HashMap map){
        tSmsTempSendMapper.updateTableFlag(map);
    }

    public ArrayList<TSmsTempSend> getSmsToSenList(HashMap map){
        return tSmsTempSendMapper.getSmsToSenList(map);
    }

    @Override
    public void doTask() {
        //获取当前时间
        String currentTime = DateUtils.getCurrDateTime();
        log.info("当前查询警告数据时间:" + currentTime);
        //从数据库获取6分钟之内的待发送短信
        String queryTime = "6";
        HashMap map=new HashMap();
        map.put("currentTime",currentTime);
        map.put("queryTime",queryTime);
        ArrayList<TSmsTempSend> smsSendList = getSmsToSenList(map);
        // 每一条短信发送一次
        if (smsSendList != null && smsSendList.size() > 0) {
            for (TSmsTempSend smsSend:smsSendList) {
                String receivers = smsSend.getReceiver();
                for(String phoneNo:receivers.split(",")){
                    //过滤非手机号格式数据
                    if("".equals(phoneNo)||phoneNo.length()!=11){
                        continue;
                    }
                    sendSms(phoneNo, smsSend.getContent(), "");
                }
            }
            //发送成功则修改发送标识
            this.updateTableFlag(map);
        }
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
            log.info("调用接口发送短信：\n"+mobile+"-----\n"+initiationID+"------\n"+content);
            SmsSendByContentRequest request = new SmsSendByContentRequest();
            request.setSource("BPCS");
            request.setMobile(mobile);
            request.setContent(content);
            request.setInitiationID(initiationID);
            ExternalResponse<Boolean> msg = smsSendService.smsSendMessage(request);
            log.info("返回结果"+msg);
        } catch (Exception e) {
            e.printStackTrace();
            result = "error";
        }
        return result;
    }
}
