package com.zs.cat.monitor.base.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.bpcs.commons.common.page.Pagination;
import com.bestpay.bpcs.commons.utils.ConstantsUtils;
import com.bestpay.bpcs.commons.utils.ResponseUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zs.cat.monitor.api.dto.TCscMonitorConfigDTO;
import com.zs.cat.monitor.api.service.MonitorConfigService;
import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
import com.zs.cat.monitor.base.bean.TCsmMonitorData;
import com.zs.cat.monitor.base.dao.TCscMonitorConfigMapper;
import com.zs.cat.monitor.base.service.IMonitorConfigService;
import com.zs.cat.monitor.base.transfer.MonitorConfigDTOTransfer;
import com.zs.cat.monitor.base.transfer.MonitorDataDTOTransfer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("monitorConfigService")
public class MonitorConfigServiceImpl implements IMonitorConfigService,MonitorConfigService {
	private static final Logger LOG = LoggerFactory.getLogger(MonitorConfigServiceImpl.class);
	@Resource
	TCscMonitorConfigMapper monitorConfigMapper;

	String result = "";

	@Override
	public String saveMonitorConfig(TCscMonitorConfigDTO tCscMonitorConfigDTO) {
		try {
			TCscMonitorConfig monitorConfig = MonitorConfigDTOTransfer.fromDto(tCscMonitorConfigDTO);
			monitorConfigMapper.insert(monitorConfig);
			LOG.info("监控定义对象["+monitorConfig.getMonitorId()+"],保存成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			LOG.debug("新增-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteMonitorConfig(String monitorId) {
		try {
			monitorConfigMapper.deleteByPrimaryKey(monitorId);
			LOG.info("监控定义对象["+monitorId+"],删除成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			LOG.debug("删除-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteMonitorConfigBatch(String[] idItem) {
		try {
			int count = monitorConfigMapper.deleteMonitorConfigBatch(idItem);
			LOG.info("批量删除[" + idItem + "],删除成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
			LOG.debug("批量删除-----------"+count);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
		return result;
	}

	@Override
	public String updateMonitorConfig(TCscMonitorConfigDTO tCscMonitorConfigDTO) {
		try {
			TCscMonitorConfig monitorConfigDTO = MonitorConfigDTOTransfer.fromDto(tCscMonitorConfigDTO);
			monitorConfigMapper.updateByPrimaryKey(monitorConfigDTO);
			LOG.info("监控定义对象[" + monitorConfigDTO.getMonitorId() + "],更新成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
			LOG.debug("更新-----------"+result);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
		return result;
	}

	@Override
	public String getMonitorConfig(String monitorId) {
		try {
			TCscMonitorConfig monitorConfig = monitorConfigMapper.selectByPrimaryKey(monitorId);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",monitorConfig);
			LOG.debug("获取-----------"+result);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
		return result;
	}

	@Override
	public String queryMonitorConfigPage(TCscMonitorConfigDTO tCscMonitorConfigDTO,int currentPage,int pageSize) {
		try {
			TCscMonitorConfig tCscMonitorConfig = MonitorConfigDTOTransfer.fromDto(tCscMonitorConfigDTO);
			Pagination page = new Pagination(currentPage, pageSize);
			tCscMonitorConfig.setPage(page);
			List<TCscMonitorConfig> beanlist = monitorConfigMapper.getMonitorConfigPage(tCscMonitorConfig);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put(ConstantsUtils.BEAN_STRING, tCscMonitorConfig);
			map.put(ConstantsUtils.BEANLIST_STRING, beanlist);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",map);
			LOG.debug("调用查询列表-----------"+result);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
		return result;
	}

	@Override
	public TCscMonitorConfig getMonitorConfigByMonitorId(String monitorId)
			throws Exception {
		return monitorConfigMapper.selectByPrimaryKey(monitorId);
	}

	@Override
	public TCscMonitorConfig getMonitorConfigByMonitorCode(String monitorCode)
			throws Exception {
		return monitorConfigMapper.selectByMonitorCode(monitorCode);
	}

	@Override
	public int insert(TCscMonitorConfig record) {
		return monitorConfigMapper.insert(record);
	}

	@Override
	public int delete(String monitorId) {
		return monitorConfigMapper.deleteByPrimaryKey(monitorId);
	}

	@Override
	public int update(TCscMonitorConfig record) {
		return monitorConfigMapper.updateByPrimaryKey(record);
	}

}
