package com.zs.cat.monitor.api.service;

import com.zs.cat.monitor.api.dto.TCscMonitorTemplateDTO;

/**
 * File                 : MonitorTemplate.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor-api
 * JDK version used     : JDK 1.6
 * Comments             : 监控通知模板
 * Version              : 1.00
 * Modification history : 2015年7月16日 上午11:21:46 [created]
 * Author               :suqb
 * Email                : andysu2006@163.com
 **/
public interface MonitorTemplateService {

    /**
     * 分页查询监控模板
     * @version: 1.00
     * @history: 2015年7月23日 下午5:34:43 [created]
     * @author suqb
     * @param tCscMonitorTemplateDTO
     * @param currentPage
     * @param pageSize
     * @return
     * @see
     */
    public String queryMonitorTemplatePage(TCscMonitorTemplateDTO tCscMonitorTemplateDTO,int currentPage,int pageSize);

    /**
     * 新增监控模板
     * @version: 1.00
     * @history: 2015年7月16日 下午2:40:55 [created]
     * @author suqb
     * @param dto
     * @return
     * @see
     */
    public String saveMonitorTemplate(TCscMonitorTemplateDTO dto);

    /**
     * 删除监控模板
     * @version: 1.00
     * @history: 2015年7月16日 下午2:52:31 [created]
     * @author suqb
     * @param templateId
     * @return
     * @see
     */
    public String deleteMonitorTemplate(String templateId);

    /**
     * 更新监控模板
     * @version: 1.00
     * @history: 2015年7月16日 下午3:01:26 [created]
     * @author suqb
     * @param dto
     * @return
     * @see
     */
    public String updateMonitorTemplate(TCscMonitorTemplateDTO dto);

    /**
     * 批量删除监控模板
     * @version: 1.00
     * @history: 2015年7月28日 上午10:51:26 [created]
     * @author suqb
     * @param idItem 批量id
     * @return
     * @see
     */
    public String deleteMonitorTemplateBatch(String[] idItem);

    /**
     * 根据主键获取监控模板
     * @version: 1.00
     * @history: 2015年8月10日 下午5:41:38 [created]
     * @author suqb
     * @param templateId
     * @return
     * @see
     */
    public String getMonitorTemplate(String templateId);
    /**
     * 查询监控模板json（用于下拉框）
     * @version: 1.00
     * @history: 2015年8月25日 上午11:07:55 [created]
     * @author huangx
     * @return
     * @see
     */
    public String getMonitorTemplateJson();

}
