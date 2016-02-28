package com.zs.cat.monitor.api.service;

import com.zs.cat.monitor.api.dto.TCscMonitorConfigDTO;
import com.zs.cat.monitor.api.dto.TCscMonitorStaffDTO;

/**
 * File                 : com.bestpay.bpcs.monitor.api.service
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2015/8/10 16:23 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
public interface MonitorStaffService {
    /**
     * 新增监控人员
     * @version: 1.00
     * @history: 2015年8月10日 上午11:18:19 [created]
     * @author huangx
     * @param tCscMonitorStaffDTO
     * @return
     * @see
     */
    public String saveMonitorStaff(TCscMonitorStaffDTO tCscMonitorStaffDTO);
    /**
     * 根据ID删除监控人员
     * @version: 1.00
     * @history: 2015年8月10日 上午12:18:19 [created]
     * @author huangx
     * @param staffId
     * @return
     * @see
     */
    public String deleteMonitorStaff(String staffId);
    /**
     * 批量删除监控人员
     * @version: 1.00
     * @history: 2015年8月10日 下午3:48:26 [created]
     * @author huangx
     * @param idItem
     * @return
     * @see
     */
    public String deleteMonitorStaffBatch(String[] idItem);
    /**
     * 更新监控人员
     * @version: 1.00
     * @history: 2015年8月10日 上午12:18:19 [created]
     * @author huangx
     * @param tCscMonitorStaffDTO
     * @return
     * @see
     */
    public String updateMonitorStaff(TCscMonitorStaffDTO tCscMonitorStaffDTO);
    /**
     * 根据主键获取监控人员
     * @version: 1.00
     * @history: 2015年8月10日 下午11:07:55 [created]
     * @author huangx
     * @param staffId
     * @return
     * @see
     */
    public String getMonitorStaff(String staffId);
    /**
     * 分页查询监控人员数据
     * @version: 1.00
     * @history: 2015年8月10日 上午11:07:55 [created]
     * @author huangx
     * @param tCscMonitorStaffDTO
     * @return
     * @see
     */
    public String queryMonitorStaffPage(TCscMonitorStaffDTO tCscMonitorStaffDTO,int currentPage,int pageSize);

    /**
     * 查询监控人员json（用于下拉框）
     * @version: 1.00
     * @history: 2015年8月24日 上午11:07:55 [created]
     * @author huangx
     * @return
     * @see
     */
    public String getStaffJson();

}
