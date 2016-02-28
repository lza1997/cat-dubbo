package com.zs.cat.monitor.base.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.bpcs.commons.common.page.Pagination;
import com.bestpay.bpcs.commons.utils.ConstantsUtils;
import com.bestpay.bpcs.commons.utils.ResponseUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zs.cat.monitor.api.dto.TCscMonitorStaffDTO;
import com.zs.cat.monitor.api.service.MonitorStaffService;
import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
import com.zs.cat.monitor.base.bean.TCscMonitorStaff;
import com.zs.cat.monitor.base.dao.TCscMonitorConfigMapper;
import com.zs.cat.monitor.base.dao.TCscMonitorStaffMapper;
import com.zs.cat.monitor.base.service.IMonitorStaffService;
import com.zs.cat.monitor.base.transfer.MonitorConfigDTOTransfer;
import com.zs.cat.monitor.base.transfer.MonitorStaffDTOTransfer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("monitorStaffService")
public class MonitorStaffServiceImpl implements IMonitorStaffService,MonitorStaffService{
	private static final Logger LOG = LoggerFactory.getLogger(MonitorConfigServiceImpl.class);
	@Resource(name="monitorStaffMapper")
	TCscMonitorStaffMapper monitorStaffMapper;

	String result = "";
	@Override
	public String saveMonitorStaff(TCscMonitorStaffDTO tCscMonitorStaffDTO) {
		try {
			TCscMonitorStaff monitorStaff = MonitorStaffDTOTransfer.fromDto(tCscMonitorStaffDTO);
			monitorStaffMapper.insert(monitorStaff);
			LOG.info("监控人员对象["+monitorStaff.getStaffId()+"],保存成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			LOG.debug("新增-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteMonitorStaff(String staffId) {
		try {
			monitorStaffMapper.deleteByPrimaryKey(staffId);
			LOG.info("监控人员对象[" + staffId + "],删除成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			LOG.debug("删除-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteMonitorStaffBatch(String[] idItem) {
		try {
			int count = monitorStaffMapper.deleteMonitorStaffBatch(idItem);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
			LOG.debug("批量删除-----------"+count);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateMonitorStaff(TCscMonitorStaffDTO tCscMonitorStaffDTO) {
		try {
			TCscMonitorStaff monitorStaffDTO = MonitorStaffDTOTransfer.fromDto(tCscMonitorStaffDTO);
			monitorStaffMapper.updateByPrimaryKey(monitorStaffDTO);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
			LOG.debug("更新-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getMonitorStaff(String staffId) {
		try {
			TCscMonitorStaff monitorStaff = monitorStaffMapper.selectByPrimaryKey(staffId);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",monitorStaff);
			LOG.debug("获取-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String queryMonitorStaffPage(TCscMonitorStaffDTO tCscMonitorStaffDTO, int currentPage, int pageSize) {
		try {
			TCscMonitorStaff tCscMonitorStaff = MonitorStaffDTOTransfer.fromDto(tCscMonitorStaffDTO);
			Pagination page = new Pagination(currentPage, pageSize);
			tCscMonitorStaff.setPage(page);
			List<TCscMonitorStaff> beanlist = monitorStaffMapper.getMonitorStaffPage(tCscMonitorStaff);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put(ConstantsUtils.BEAN_STRING, tCscMonitorStaff);
			map.put(ConstantsUtils.BEANLIST_STRING, beanlist);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",map);
			LOG.debug("调用查询列表-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getStaffJson() {
		try {
			List<TCscMonitorStaff> beanlist = monitorStaffMapper.getMonitorStaffJson();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put(ConstantsUtils.BEANLIST_STRING, beanlist);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",map);
			LOG.debug("调用获取列表-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TCscMonitorStaff getMonitorStaffByStaffId(String staffId)
			throws Exception {
		return monitorStaffMapper.selectByPrimaryKey(staffId);
	}

	@Override
	public int insert(TCscMonitorStaff record) {
		return monitorStaffMapper.insert(record);
	}

	@Override
	public int delete(String staffId) {
		return monitorStaffMapper.deleteByPrimaryKey(staffId);
	}

	@Override
	public int update(TCscMonitorStaff record) {
		return monitorStaffMapper.updateByPrimaryKey(record);
	}

}
