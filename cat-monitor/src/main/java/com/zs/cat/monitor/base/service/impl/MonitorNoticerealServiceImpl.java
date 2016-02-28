package com.zs.cat.monitor.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bestpay.bpcs.commons.utils.ConstantsUtils;
import com.bestpay.bpcs.commons.utils.ResponseUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zs.cat.monitor.api.dto.TCscMonitorNoticerealDTO;
import com.zs.cat.monitor.api.service.MonitorNoticerealService;
import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
import com.zs.cat.monitor.base.bean.TCscMonitorNoticereal;
import com.zs.cat.monitor.base.dao.TCscMonitorNoticerealMapper;
import com.zs.cat.monitor.base.service.IMonitorNoticerealService;
import com.zs.cat.monitor.base.transfer.MonitorConfigDTOTransfer;
import com.zs.cat.monitor.base.transfer.MonitorNoticerealDTOTransfer;

@Service("monitorNoticerealService")
public class MonitorNoticerealServiceImpl implements IMonitorNoticerealService,MonitorNoticerealService {
	private static final Logger LOG = LoggerFactory.getLogger(MonitorNoticerealServiceImpl.class);
	@Resource
	TCscMonitorNoticerealMapper monitorNoticerealMapper;

	String result = "";

	@Override
	public List<TCscMonitorNoticereal> getMonitorNoticerealByMonitorId(String monitorId) {
		return monitorNoticerealMapper.selectByMonitorId(monitorId);
	}

	@Override
	public int insert(TCscMonitorNoticereal record) {
		return monitorNoticerealMapper.insert(record);
	}

	@Override
	public int delete(String realId) {
		return monitorNoticerealMapper.deleteByPrimaryKey(realId);
	}

	@Override
	public int update(TCscMonitorNoticereal record) {
		return monitorNoticerealMapper.updateByPrimaryKey(record);
	}

	@Override
	public String saveMonitorNoticereal(TCscMonitorNoticerealDTO tCscMonitorNoticerealDTO) {
		try {
			TCscMonitorNoticereal monitorNoticereal = MonitorNoticerealDTOTransfer.fromDto(tCscMonitorNoticerealDTO);
			monitorNoticerealMapper.insert(monitorNoticereal);
			LOG.info("监控通知人员关系对象["+monitorNoticereal.getRealId()+"],保存成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			LOG.debug("新增-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteMonitorNoticereal(String realId) {
		try {
			monitorNoticerealMapper.deleteByPrimaryKey(realId);
			LOG.info("监控通知人员关系对象["+realId+"],删除成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", null);
			LOG.debug("删除-----------"+result);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteMonitorNoticerealBatch(String[] idItem) {
		try {
			int count = monitorNoticerealMapper.deleteMonitorNoticeRealBatch(idItem);
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
	public String updateMonitorNoticereal(TCscMonitorNoticerealDTO tCscMonitorNoticerealDTO) {
		try {
			TCscMonitorNoticereal monitorNoticereal = MonitorNoticerealDTOTransfer.fromDto(tCscMonitorNoticerealDTO);
			monitorNoticerealMapper.updateByPrimaryKey(monitorNoticereal);
			LOG.info("监控通知人员关系对象[" + monitorNoticereal.getRealId()+ "],更新成功！");
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
			LOG.debug("更新-----------"+result);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
		return result;
	}

	@Override
	public String getMonitorNoticereal(String monitorId) {
		try {
			if(monitorNoticerealMapper.selectByMonitorId(monitorId).size()>0){
				TCscMonitorNoticereal monitorNoticereal = monitorNoticerealMapper.selectByMonitorId(monitorId).get(0);
				result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",monitorNoticereal);
				LOG.debug("获取-----------"+result);
			}
			else{
				result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
		return result;
	}
}
