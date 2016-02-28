package com.zs.cat.monitor.base.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCscMonitorStaff;
import com.zs.cat.monitor.base.bean.TCscMonitorTemplate;

@Component("monitorTemplateMapper")
public interface TCscMonitorTemplateMapper {
	/**
	 * 根据模板id删除监控模板
	 * @version: 1.00
	 * @history: 2015年7月28日 下午6:48:27 [created]
	 * @author suqb 
	 * @param templateId
	 * @return
	 * @see
	 */
	int deleteByPrimaryKey(String templateId);

    /**
     * 新增监控模板
     * @version: 1.00
     * @history: 2015年7月28日 下午6:49:23 [created]
     * @author suqb 
     * @param record
     * @return
     * @see
     */
    int insert(TCscMonitorTemplate record);

    /**
     * 按条件新增监控模板
     * @version: 1.00
     * @history: 2015年7月28日 下午6:50:04 [created]
     * @author suqb 
     * @param record
     * @return
     * @see
     */
    int insertSelective(TCscMonitorTemplate record);

    /**
     * 根据ID查询监控模板
     * @version: 1.00
     * @history: 2015年7月28日 下午6:50:29 [created]
     * @author suqb 
     * @param templateId
     * @return
     * @see
     */
    TCscMonitorTemplate selectByPrimaryKey(String templateId);

    /**
     * 按条件修改监控模板
     * @version: 1.00
     * @history: 2015年7月28日 下午6:50:55 [created]
     * @author suqb 
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKeySelective(TCscMonitorTemplate record);

    /**
     * 更新监控模板
     * @version: 1.00
     * @history: 2015年7月28日 下午6:51:08 [created]
     * @author suqb 
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKey(TCscMonitorTemplate record);
    /**
	 * 分页查询监控模板信息
	 * @version: 1.00
	 * @history: 2015年7月16日 上午11:39:56 [created]
	 * @author suqb 
	 * @param monitorTemplate
	 * @return
	 * @see
	 */
	List<TCscMonitorTemplate> getMonitorTemplatePage(
			TCscMonitorTemplate monitorTemplate);

    /**
     * 获取数据（用于下拉框）
     *
     * @version: 1.00
     * @history: 2015年8月25日 下午5:07:26 [created]
     * @author hx 黄湘
     * @return
     * @see
     */
    List<TCscMonitorTemplate> getMonitorTemplateJson();
	/**
	 * 批量删除监控模板
	 * @version: 1.00
	 * @history: 2015年7月28日 上午11:23:38 [created]
	 * @author suqb 
	 * @param idItem 批量ID
	 * @return
	 * @see
	 */
	int doDeleteMonitorTemplateBatch(String[] idItem);
}