package com.zs.cat.monitor.base.service;

import java.util.List;

import com.zs.cat.monitor.base.bean.TCscMonitorNoticereal;

/**
 * 
 * File                 : IMonitorNoticerealService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月19日 上午11:16:21 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
public interface IMonitorNoticerealService {

	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 上午11:54:43 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int insert(TCscMonitorNoticereal record);
	
	/**
	 * 根据id删除
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午1:46:15 [created]
	 * @author hx 黄湘
	 * @param realId
	 * @return
	 * @see
	 */
	public int delete(String realId);
	
	/**
	 * 修改
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午1:46:50 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int update(TCscMonitorNoticereal record);
	/**
	 * 根据monitorId查询监控通知人员关系
	 * 
	 * @version: 1.00
	 * @history: 2015年6月18日 上午10:37:59 [created]
	 * @author hx 黄湘
	 * @param monitorId 监控Id
	 * @return
	 * @see
	 */
	public List<TCscMonitorNoticereal> getMonitorNoticerealByMonitorId(String monitorId) throws Exception;
}
