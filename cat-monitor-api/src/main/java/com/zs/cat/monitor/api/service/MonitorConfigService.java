package com.zs.cat.monitor.api.service;

import com.zs.cat.monitor.api.dto.TCscMonitorConfigDTO;
import com.zs.cat.monitor.api.dto.TCsmMonitorDataDTO;

import java.util.List;

/**风控对外接口
 * File                 : MonitorConfigService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor-api
 * JDK version used     : JDK 1.7
 * Comments             :
 * Version              : 1.00
 * Modification history : 2015年7月15日 上午11:18:19 [created]
 * Author               :huangx
 * Email                : huangxiang-it@bestpay.com.cn
 **/

public interface MonitorConfigService {

    /**
     * 新增风控定义
     * @version: 1.00
     * @history: 2015年7月15日 上午11:18:19 [created]
     * @author huangx
     * @param tCscMonitorConfigDTO
     * @return
     * @see
     */
    public String saveMonitorConfig(TCscMonitorConfigDTO tCscMonitorConfigDTO);
    /**
     * 根据ID删除风控定义
     * @version: 1.00
     * @history: 2015年7月17日 上午12:18:19 [created]
     * @author huangx
     * @param monitorId
     * @return
     * @see
     */
    public String deleteMonitorConfig(String monitorId);
    /**
     * 批量删除风控定义
     * @version: 1.00
     * @history: 2015年8月5日 下午3:48:26 [created]
     * @author huangx
     * @param idItem
     * @return
     * @see
     */
    public String deleteMonitorConfigBatch(String[] idItem);
    /**
     * 根据主键删除风控定义
     * @version: 1.00
     * @history: 2015年7月17日 上午12:18:19 [created]
     * @author huangx
     * @param tCscMonitorConfigDTO
     * @return
     * @see
     */
    public String updateMonitorConfig(TCscMonitorConfigDTO tCscMonitorConfigDTO);
    /**
     * 根据主键获取风控定义
     * @version: 1.00
     * @history: 2015年7月16日 下午11:07:55 [created]
     * @author huangx
     * @return
     * @see
     */
    public String getMonitorConfig(String monitorId);
    /**
     * 分页查询风控定义数据
     * @version: 1.00
     * @history: 2015年7月16日 上午11:07:55 [created]
     * @author huangx
     * @param tCscMonitorConfigDTO
     * @return
     * @see
     */
    public String queryMonitorConfigPage(TCscMonitorConfigDTO tCscMonitorConfigDTO,int currentPage,int pageSize);

}
