package com.zs.cat.monitor.base.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bestpay.bpcs.commons.common.page.Pagination;
import com.bestpay.bpcs.commons.utils.ConstantsUtils;
import com.bestpay.bpcs.commons.utils.ResponseUtils;
import com.zs.cat.monitor.api.dto.TCsmMonitorDataDTO;
import com.zs.cat.monitor.api.service.MonitorService;
import com.zs.cat.monitor.base.bean.TCsmMonitorData;
import com.zs.cat.monitor.base.dao.TCsmMonitorDataMapper;
import com.zs.cat.monitor.base.transfer.MonitorDataDTOTransfer;

/**风控对外接口实现类
 * File                 : MonitorServiceImpl.java
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs-monitor
 * JDK version used     : JDK 1.6
 * Comments             : 
 * Version              : 1.00
 * Modification history : 2015年7月3日 上午10:29:43 [created]
 * Author               :suqb
 * Email                : andysu2006@163.com
 **/
@Service("monitorService")
public class MonitorServiceImpl implements MonitorService{
	private static final Logger LOG = LoggerFactory.getLogger(MonitorServiceImpl.class);
	@Resource(name="monitorDataMapper")
   TCsmMonitorDataMapper monitorDataMapper;
   @Override
	public String saveMonitorDataBatch(List<TCsmMonitorDataDTO> tCsmMonitorDataDTOList) {
		    List<TCsmMonitorData> list = MonitorDataDTOTransfer.fromDtoList(tCsmMonitorDataDTOList);
		    String result = "";
			try {
				if (null != list && list.size() > 0) {
				   for(int i=0;i<list.size();i++){
					   TCsmMonitorData monitorData = list.get(i);
					   monitorDataMapper.insert(monitorData);
					   LOG.info("监控对象["+monitorData.getMonitorObj()+"],保存成功！");
				   }
				    result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
				}else{
				    result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_FAIL, "value is null", null);
					LOG.info("数据为空");
				}
			} catch (Exception e) {
				result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
				e.printStackTrace();
			}
		return result;
	}
   @Override
	public String saveMonitorData(TCsmMonitorDataDTO dto) {
	   String result = "";
	    try {
			TCsmMonitorData monitorData = MonitorDataDTOTransfer.fromDto(dto);
			monitorDataMapper.insert(monitorData);
			LOG.info("监控对象["+monitorData.getMonitorObj()+"],保存成功！");
		    result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}
	   @Override
	public String queryMonitorDataPage(TCsmMonitorDataDTO tCsmMonitorDataDTO,int currentPage, int pageSize) {
		   String result = "";
		try {  
			   
			   TCsmMonitorData tCscMonitorData = MonitorDataDTOTransfer.fromDto(tCsmMonitorDataDTO);
			   Pagination page = new Pagination(currentPage, pageSize);
			   tCscMonitorData.setPage(page);
			   List<TCsmMonitorData> beanlist = monitorDataMapper.getMonitorDataPage(tCscMonitorData);
			   Map<String,Object> map = new HashMap<String,Object>();
			   map.put(ConstantsUtils.BEAN_STRING, tCscMonitorData);
			   map.put(ConstantsUtils.BEANLIST_STRING, beanlist);
			   result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", map);
			   LOG.debug("调用查询列表-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		   return result;
	}
}
