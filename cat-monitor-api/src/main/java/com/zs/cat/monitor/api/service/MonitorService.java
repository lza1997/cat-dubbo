package com.zs.cat.monitor.api.service;

import java.util.List;

import com.zs.cat.monitor.api.dto.TCsmMonitorDataDTO;

/**
 * File                 : MonitorService.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor-api
 * JDK version used     : JDK 1.6
 * Comments             : 监控数据接口
 * Version              : 1.00
 * Modification history : 2015年7月3日 上午10:18:19 [created]
 * Author               :suqb
 * Email                : andysu2006@163.com
 **/
public interface MonitorService {
	 /**
	 * 批量记录监控异常数据接口
	 * @version: 1.00
	 * @history: 2015年7月3日 上午10:28:51 [created]
	 * @author suqb 
	 * @param tCsmMonitorDataDTOList
	 * @return
	 * @see
	 */
	public String saveMonitorDataBatch(List<TCsmMonitorDataDTO> tCsmMonitorDataDTOList);
	/**
	 * 保存单个监控异常数据
	 * @version: 1.00
	 * @history: 2015年8月7日 上午10:59:04 [created]
	 * @author suqb 
	 * @param dto
	 * @return
	 * @see
	 */
	public String saveMonitorData(TCsmMonitorDataDTO dto);
	
	/**
	 * 分页查询监控异常数据
	 * @version: 1.00
	 * @history: 2015年7月23日 下午5:34:02 [created]
	 * @author suqb 
	 * @param tCsmMonitorDataDTO
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @see
	 */
	public String queryMonitorDataPage(TCsmMonitorDataDTO tCsmMonitorDataDTO,int currentPage, int pageSize);
}
