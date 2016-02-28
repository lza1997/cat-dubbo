package com.zs.cat.monitor.base.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCscMonitorNoticereal;

@Component("monitorNoticerealMapper")
public interface TCscMonitorNoticerealMapper {
    /**
     * 根据ID删除
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:12:20 [created]
     * @author hx 黄湘
     * @param realId
     * @return
     * @see
     */
	int deleteByPrimaryKey(String realId);

	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月25日 下午4:12:24 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
    int insert(TCscMonitorNoticereal record);

    /**
     * 根据条件新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:12:29 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insertSelective(TCscMonitorNoticereal record);

    /**
     * 根据ID查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:12:32 [created]
     * @author hx 黄湘
     * @param realId
     * @return
     * @see
     */
    TCscMonitorNoticereal selectByPrimaryKey(String realId);

    /**
     * 按条件修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:12:36 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKeySelective(TCscMonitorNoticereal record);

    /**
     * 修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:12:39 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKey(TCscMonitorNoticereal record);
    
    /**
     * 根据monitorId查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:12:42 [created]
     * @author hx 黄湘
     * @param monitorId
     * @return
     * @see
     */
    List<TCscMonitorNoticereal> selectByMonitorId(String monitorId);

    /**
     * 批量删除
     *
     * @version: 1.00
     * @history: 2015年8月19日 下午4:07:26 [created]
     * @author hx 黄湘
     * @param idItem
     * @return
     * @see
     */
    int deleteMonitorNoticeRealBatch(String[] idItem);
}