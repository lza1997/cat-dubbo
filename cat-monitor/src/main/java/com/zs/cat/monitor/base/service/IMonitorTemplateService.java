package com.zs.cat.monitor.base.service;

import com.zs.cat.monitor.base.bean.TCscMonitorTemplate;

/**
 * 
 * File                 : IMonitorTemplateService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年6月19日 上午11:16:35 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 *
 */
public interface IMonitorTemplateService {

	/**
	 * 新增
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午2:01:11 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int insert(TCscMonitorTemplate record);
	
	/**
	 * 删除
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午2:01:16 [created]
	 * @author hx 黄湘
	 * @param templateId
	 * @return
	 * @see
	 */
	public int delete(String templateId);
	
	/**
	 * 修改
	 * 
	 * @version: 1.00
	 * @history: 2015年6月29日 下午2:01:33 [created]
	 * @author hx 黄湘
	 * @param record
	 * @return
	 * @see
	 */
	public int update(TCscMonitorTemplate record);
	/**
	 * 根据templateId查询模板
	 * 
	 * @version: 1.00
	 * @history: 2015年6月25日 下午4:21:54 [created]
	 * @author hx 黄湘
	 * @param templateId
	 * @return
	 * @throws Exception
	 * @see
	 */
	public TCscMonitorTemplate getMonitorTemplateByTemplateId(String templateId) throws Exception;
}
