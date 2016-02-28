package com.zs.cat.monitor.base.dao;

import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
import com.zs.cat.monitor.base.bean.TCscMonitorStaff;

import java.util.List;

@Component("monitorStaffMapper")
public interface TCscMonitorStaffMapper {
    /**
     * 根据ID删除
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:14:06 [created]
     * @author hx 黄湘
     * @param staffId
     * @return
     * @see
     */
	int deleteByPrimaryKey(String staffId);

	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月25日 下午4:14:08 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
    int insert(TCscMonitorStaff record);

    /**
     * 按条件新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:14:23 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insertSelective(TCscMonitorStaff record);

    /**
     * 根据ID查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:14:20 [created]
     * @author hx 黄湘
     * @param staffId
     * @return
     * @see
     */
    TCscMonitorStaff selectByPrimaryKey(String staffId);

    /**
     * 按条件修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:14:15 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKeySelective(TCscMonitorStaff record);

    /**
     * 修改
     * 
     * @version: 1.00
     * @history: 2015年8月25日 下午4:14:12 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKey(TCscMonitorStaff record);

    /**
     * 获取分页数据
     *
     * @version: 1.00
     * @history: 2015年8月10日 下午5:07:26 [created]
     * @author hx 黄湘
     * @param tCscMonitorStaff
     * @return
     * @see
     */
    List<TCscMonitorStaff> getMonitorStaffPage(TCscMonitorStaff tCscMonitorStaff);

    /**
     * 获取数据（用于下拉框）
     *
     * @version: 1.00
     * @history: 2015年8月24日 下午5:07:26 [created]
     * @author hx 黄湘
     * @return
     * @see
     */
    List<TCscMonitorStaff> getMonitorStaffJson();

    /**
     * 批量删除
     *
     * @version: 1.00
     * @history: 2015年8月10日 下午4:07:26 [created]
     * @author hx 黄湘
     * @param idItem
     * @return
     * @see
     */
    int deleteMonitorStaffBatch(String[] idItem);
}