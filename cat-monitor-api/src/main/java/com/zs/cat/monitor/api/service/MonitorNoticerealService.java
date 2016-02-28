package com.zs.cat.monitor.api.service;

import com.zs.cat.monitor.api.dto.TCscMonitorNoticerealDTO;

/**
 * File                 : com.bestpay.bpcs.monitor.api.service
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2015/8/19 18:28 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
public interface MonitorNoticerealService {
    /**
     * 新增通知人员关系
     * @version: 1.00
     * @history: 2015年8月19日 上午11:18:19 [created]
     * @author huangx
     * @param tCscMonitorNoticerealDTO
     * @return
     * @see
     */
    public String saveMonitorNoticereal(TCscMonitorNoticerealDTO tCscMonitorNoticerealDTO);
    /**
     * 根据ID删除通知人员关系
     * @version: 1.00
     * @history: 2015年8月19日 上午12:18:19 [created]
     * @author huangx
     * @param realId
     * @return
     * @see
     */
    public String deleteMonitorNoticereal(String realId);
    /**
     * 批量删除通知人员关系
     * @version: 1.00
     * @history: 2015年8月19日 下午3:48:26 [created]
     * @author huangx
     * @param idItem
     * @return
     * @see
     */
    public String deleteMonitorNoticerealBatch(String[] idItem);
    /**
     * 批量更新通知人员关系
     * @version: 1.00
     * @history: 2015年8月19日 上午12:18:19 [created]
     * @author huangx
     * @param tCscMonitorNoticerealDTO
     * @return
     * @see
     */
    public String updateMonitorNoticereal(TCscMonitorNoticerealDTO tCscMonitorNoticerealDTO);
    /**
     * 根据monitorId获取通知人员关系
     * @version: 1.00
     * @history: 2015年8月19日 下午11:07:55 [created]
     * @author huangx
     * @param monitorId
     * @return
     * @see
     */
    public String getMonitorNoticereal(String monitorId);
}
