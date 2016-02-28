package com.zs.cat.monitor.base.transfer;

import com.zs.cat.monitor.api.dto.TCscMonitorNoticerealDTO;
import com.zs.cat.monitor.base.bean.TCscMonitorNoticereal;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * File                 : com.bestpay.bpcs.monitor.base.transfer
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2015/8/10 17:35 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
public class MonitorNoticerealDTOTransfer {
    public static TCscMonitorNoticereal fromDto(TCscMonitorNoticerealDTO dto) {

        TCscMonitorNoticereal detail = new TCscMonitorNoticereal();
        if (null != dto) {
            BeanUtils.copyProperties(dto, detail);
        }
        return detail;
    }

    public static List<TCscMonitorNoticereal> fromDtoList(
            List<TCscMonitorNoticerealDTO> dtos) {
        List<TCscMonitorNoticereal> list = new ArrayList<TCscMonitorNoticereal>();
        if (null != dtos && dtos.size() > 0) {
            for (TCscMonitorNoticerealDTO dto : dtos) {
                TCscMonitorNoticereal detail = new TCscMonitorNoticereal();
                if (null != dto) {
                    BeanUtils.copyProperties(dto, detail);
                }
                list.add(detail);
            }
        }
        return list;
    }
}
