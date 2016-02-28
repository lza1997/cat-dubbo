package com.zs.cat.monitor.base.dao;
import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCscMonitorConfig;

import java.util.List;

@Component("monitorConfigMapper")
public interface TCscMonitorConfigMapper {
    /**
     * 根据id删除
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:06:51 [created]
     * @author hx 黄湘
     * @param monitorId
     * @return
     * @see
     */
	int deleteByPrimaryKey(String monitorId);

	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月25日 下午4:07:05 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
    int insert(TCscMonitorConfig record);

    /**
     * 根据条件新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:07:12 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insertSelective(TCscMonitorConfig record);

    /**
     * 根据ID查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:07:16 [created]
     * @author hx 黄湘
     * @param monitorId
     * @return
     * @see
     */
    TCscMonitorConfig selectByPrimaryKey(String monitorId);

    /**
     * 按条件修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:07:22 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKeySelective(TCscMonitorConfig record);

    /**
     * 修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:07:26 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKey(TCscMonitorConfig record);
    
    /**
     * 根据monitorCode查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:07:30 [created]
     * @author hx 黄湘
     * @param monitorCode
     * @return
     * @see
     */
    TCscMonitorConfig selectByMonitorCode(String monitorCode);

    List<TCscMonitorConfig> getMonitorConfigPage(TCscMonitorConfig tCscMonitorConfig);

    int getMonitorConfigCount();

    /**
     * 批量删除
     *
     * @version: 1.00
     * @history: 2015年8月5日 下午4:07:26 [created]
     * @author hx 黄湘
     * @param idItem
     * @return
     * @see
     */
    int deleteMonitorConfigBatch(String[] idItem);
}