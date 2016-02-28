package com.zs.cat.monitor.base.service;

import com.zs.cat.monitor.base.bean.TCscMonitorStaff;

/**
 * 
 * File                 : IMonitorStaffService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月19日 上午11:16:30 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
public interface IMonitorStaffService {
	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午1:56:06 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int insert(TCscMonitorStaff record);
	
	/**
	 * 删除
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午1:58:17 [created]
	 * @author hx 黄湘
	 * @param staffId
	 * @return
	 * @see
	 */
	public int delete(String staffId);
	
	/**
	 * 修改
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午1:58:38 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int update(TCscMonitorStaff record);

	/**
	 * 根据staffId查询人员
	 * 
	 * @version: 1.00
	 * @history: 2015年6月25日 下午4:21:38 [created]
	 * @author hx 黄湘
	 * @param staffId
	 * @return
	 * @throws Exception
	 * @see
	 */
	public TCscMonitorStaff getMonitorStaffByStaffId(String staffId) throws Exception;
}
