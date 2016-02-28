package com.zs.cat.monitor.task;

import com.bestpay.bpcs.schedule.frame.AbstractTask;
import com.zs.cat.monitor.base.service.ISmsTempSendService;

import lombok.extern.slf4j.Slf4j;

import org.quartz.JobExecutionContext;

import javax.annotation.Resource;

/**
 * File                 : SmsTempSendTask
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2016/1/19 15:06 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
@Slf4j
public class SmsTempSendTask extends AbstractTask {
    @Resource
    private ISmsTempSendService smsTempSendService;
    /**
     * 任务实现方法
     * 具体由子类实现
     *
     * @param context
     */
    @Override
    public String doTask(JobExecutionContext context) throws Exception {
        try{
            smsTempSendService.doTask();
        }catch (Exception e){
            log.error("定时发送监控短信异常，异常详情：",e);
        }
        return null;
    }
}
