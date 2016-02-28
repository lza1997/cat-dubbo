package com.zs.cat.monitor.base.service;

import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
/**
 * 
 * File                 : IMonitorConfigService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月19日 上午11:15:19 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
public interface IMonitorConfigService {

	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 上午10:51:24 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int insert(TCscMonitorConfig record);
	
	/**
	 * 根据id删除
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 上午11:12:28 [created]
	 * @author hx 黄湘
	 * @param monitorId
	 * @see
	 */
	public int delete(String monitorId);
	
	/**
	 * 修改
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 上午11:23:38 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int update(TCscMonitorConfig record);
	
	/**
	 * 通过主键查找监控配置
	 * 
	 * @version: 1.00
	 * @history: 2015年6月18日 上午9:51:13 [created]
	 * @author hx 黄湘
	 * @param monitorId 监控ID
	 * @return
	 * @throws Exception
	 * @see
	 */
	public TCscMonitorConfig getMonitorConfigByMonitorId(String monitorId) throws Exception;
	
	/**
	 * 通过监控编码查找监控配置
	 * 
	 * @version: 1.00
	 * @history: 2015年6月18日 上午9:51:41 [created]
	 * @author hx 黄湘
	 * @param monitorCode 监控编码
	 * @return
	 * @throws Exception
	 * @see
	 */
	public TCscMonitorConfig getMonitorConfigByMonitorCode(String monitorCode) throws Exception;
}
