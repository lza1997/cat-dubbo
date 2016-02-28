package com.zs.cat.monitor.base.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestpay.bpcs.commons.common.page.Pagination;
import com.bestpay.bpcs.commons.utils.ConstantsUtils;
import com.bestpay.bpcs.commons.utils.ResponseUtils;
import com.zs.cat.monitor.api.dto.TCscMonitorTemplateDTO;
import com.zs.cat.monitor.api.service.MonitorTemplateService;
import com.zs.cat.monitor.base.bean.TCscMonitorStaff;
import com.zs.cat.monitor.base.bean.TCscMonitorTemplate;
import com.zs.cat.monitor.base.dao.TCscMonitorTemplateMapper;
import com.zs.cat.monitor.base.service.IMonitorTemplateService;
import com.zs.cat.monitor.base.transfer.MonitorTemplateDTOTransfer;

@Service("monitorTemplateService")
public class MonitorTemplateServiceImpl implements IMonitorTemplateService,MonitorTemplateService{

	@Resource
	TCscMonitorTemplateMapper monitorTemplateMapper;

	String result="";
    @Override
    public String queryMonitorTemplatePage(TCscMonitorTemplateDTO dto,int currentPage,int pageSize) {
    	 try {
			TCscMonitorTemplate monitorTemplate  = MonitorTemplateDTOTransfer.fromDto(dto);
			 Pagination page = new Pagination(currentPage, pageSize);
			 monitorTemplate.setPage(page);
			 List<TCscMonitorTemplate> beanlist = monitorTemplateMapper.getMonitorTemplatePage(monitorTemplate);
			 Map<String,Object> map = new HashMap<String,Object>();
			 map.put(ConstantsUtils.BEAN_STRING, monitorTemplate);
			 map.put(ConstantsUtils.BEANLIST_STRING, beanlist);
			 result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success", map);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
    	return result;
    }
    @Override
    public String saveMonitorTemplate(TCscMonitorTemplateDTO dto) {
    	try {
			TCscMonitorTemplate monitorTemplate  = MonitorTemplateDTOTransfer.fromDto(dto);
			monitorTemplateMapper.insert(monitorTemplate);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
    	return result;
    }
    
    @Override
    public String deleteMonitorTemplate(String templateId) {
		try {
			monitorTemplateMapper.deleteByPrimaryKey(templateId);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
    	return result;
    }
    @Override
    public String updateMonitorTemplate(TCscMonitorTemplateDTO dto) {
    	try {
			TCscMonitorTemplate monitorTemplate  = MonitorTemplateDTOTransfer.fromDto(dto);
			monitorTemplateMapper.updateByPrimaryKey(monitorTemplate);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
    	return result;
    }
    
    @Override
    public String deleteMonitorTemplateBatch(String[] idItem) {
    	try {
			int count  = monitorTemplateMapper.doDeleteMonitorTemplateBatch(idItem);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",null);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
    	return result;
    }
    public String getMonitorTemplate(String templateId){
    	try {
    		TCscMonitorTemplate monitorTemplate  =monitorTemplateMapper.selectByPrimaryKey(templateId);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",monitorTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
		}
    	return result;
	}

	@Override
	public String getMonitorTemplateJson() {
		try {
			List<TCscMonitorTemplate> beanlist = monitorTemplateMapper.getMonitorTemplateJson();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put(ConstantsUtils.BEANLIST_STRING, beanlist);
			result = ResponseUtils.returnSuccessInfo(ConstantsUtils.COMMON_CODE_SUCCESS, "success",map);
		} catch (Exception e) {
			result = ResponseUtils.returnFailInfo(ConstantsUtils.COMMON_CODE_FAIL, "error", null, e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TCscMonitorTemplate getMonitorTemplateByTemplateId(String templateId)
			throws Exception {
		return monitorTemplateMapper.selectByPrimaryKey(templateId);
	}

	@Override
	public int insert(TCscMonitorTemplate record) {
		return monitorTemplateMapper.insert(record);
	}

	@Override
	public int delete(String templateId) {
		return monitorTemplateMapper.deleteByPrimaryKey(templateId);
	}

	@Override
	public int update(TCscMonitorTemplate record) {
		return monitorTemplateMapper.updateByPrimaryKey(record);
	}
}
