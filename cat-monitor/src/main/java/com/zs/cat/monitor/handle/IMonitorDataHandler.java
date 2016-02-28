package com.zs.cat.monitor.handle;

import org.springframework.integration.Message;


/**
 * 
 * File                 : IMonitorDataHandler.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月18日 上午9:37:44 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
public interface IMonitorDataHandler {

	/**
	 * 根据监控编码扫描监控定义表，判断是否超过阀值
	 * 
	 * @version: 1.00
	 * @history: 2015年6月18日 上午9:40:51 [created]
	 * @author hx 黄湘
	 * @param monitorCode
	 * @return
	 * @see
	 */
	public void processFileByMonitorCode(String monitorCode);
}
