package com.zs.cat.monitor.base.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCsmMonitorData;

@Component("monitorDataMapper")
public interface TCsmMonitorDataMapper {
    /**
     * 根据ID删除
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:16:32 [created]
     * @author hx 黄湘
     * @param dataId
     * @return
     * @see
     */
	int deleteByPrimaryKey(String dataId);
    /**
     * 新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:16:30 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insert(TCsmMonitorData record);

    /**
     * 按条件新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:16:27 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insertSelective(TCsmMonitorData record);

    /**
     * 根据ID查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:16:25 [created]
     * @author hx 黄湘
     * @param dataId
     * @return
     * @see
     */
    TCsmMonitorData selectByPrimaryKey(String dataId);

    /**
     * 按条件修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:16:22 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKeySelective(TCsmMonitorData record);

    /**
     * 修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:16:20 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKey(TCsmMonitorData record);
    
    /**
     * 分页查询监控数据
     * @version: 1.00
     * @history: 2015年7月20日 上午11:41:16 [created]
     * @author suqb 
     * @param tCsmMonitorData
     * @return
     * @see
     */
    List<TCsmMonitorData> getMonitorDataPage(TCsmMonitorData tCsmMonitorData);
}