package com.zs.cat.monitor.base.dao;

import org.springframework.stereotype.Component;

import com.zs.cat.monitor.base.bean.TCsmMonitorNoticelog;

import java.util.Date;

@Component("monitorNoticelogMapper")
public interface TCsmMonitorNoticelogMapper {
    /**
     * 根据ID删除
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:17:33 [created]
     * @author hx 黄湘
     * @param logId
     * @return
     * @see
     */
	int deleteByPrimaryKey(String logId);

    /**
     * 新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:17:30 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insert(TCsmMonitorNoticelog record);

    /**
     * 按条件新增
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:17:28 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int insertSelective(TCsmMonitorNoticelog record);

    /**
     * 根据ID查询
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:17:23 [created]
     * @author hx 黄湘
     * @param logId
     * @return
     * @see
     */
    TCsmMonitorNoticelog selectByPrimaryKey(String logId);

    /**
     * 按条件修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:17:21 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKeySelective(TCsmMonitorNoticelog record);

    /**
     * 修改
     * 
     * @version: 1.00
     * @history: 2015年6月25日 下午4:17:17 [created]
     * @author hx 黄湘
     * @param record
     * @return
     * @see
     */
    int updateByPrimaryKey(TCsmMonitorNoticelog record);

    /**
     * 根据人员ID、监控ID、通知方式获取该人员当天发送过的通知次数
    *
            * @version: 1.00
            * @history: 2015年8月13日 上午10:21:30 [created]
            * @author hx 黄湘
    * @param staffId
    * @param monitorId
    * @param noticeType
    * @param beginTime
    * @param endTime
    * @return
            * @see
    */
//    int checkPreviewNotice(String staffId,String monitorId,String noticeType,Date beginTime,Date endTime);
    int checkPreviewNotice(TCsmMonitorNoticelog log);
}