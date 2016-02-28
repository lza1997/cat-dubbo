package com.zs.cat.monitor.base.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.cat.monitor.base.bean.TCsmMonitorData;
import com.zs.cat.monitor.base.bean.TCsmMonitorNoticelog;
import com.zs.cat.monitor.base.dao.TCsmMonitorNoticelogMapper;
import com.zs.cat.monitor.base.service.IMonitorNoticelogService;

@Service("monitorNoticelogService")
public class MonitorNoticelogServiceImpl implements IMonitorNoticelogService{

	@Resource
	TCsmMonitorNoticelogMapper monitorNoticelogMapper;

	@Override
	public TCsmMonitorNoticelog doInsertMonitorNoticeLog(String monitorId,String monitorName,
														 String staffId,String staffName, String noticeType, String noticeObj,
														 String noticeContent, Date noticeTime, String stat) {
		TCsmMonitorNoticelog log = new TCsmMonitorNoticelog();
		try {
			log.setMonitorId(monitorId);
			log.setMonitorName(monitorName);
			log.setNoticeContent(noticeContent);
			log.setNoticeObj(noticeObj);
			log.setNoticeTime(noticeTime);
			log.setNoticeType(noticeType);
			log.setStaffId(staffId);
			log.setStaffName(staffName);
			log.setStat(stat);
			monitorNoticelogMapper.insert(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return log;
	}

	@Override
	public String updateMonitorNoticeLog(TCsmMonitorNoticelog log) {
		String result = "success";
		try {
			monitorNoticelogMapper.updateByPrimaryKey(log);
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int checkPreviewNotice(TCsmMonitorNoticelog log) {
		int count;
		try{
//			TCsmMonitorNoticelog log=new TCsmMonitorNoticelog();
			count=monitorNoticelogMapper.checkPreviewNotice(log);
		} catch(Exception e){
			count=0;
			e.printStackTrace();
		}
		return count;
	}
}
