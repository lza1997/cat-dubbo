package com.zs.cat.monitor.base.transfer;

import com.zs.cat.monitor.api.dto.TCscMonitorConfigDTO;
import com.zs.cat.monitor.api.dto.TCscMonitorStaffDTO;
import com.zs.cat.monitor.base.bean.TCscMonitorConfig;
import com.zs.cat.monitor.base.bean.TCscMonitorStaff;

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
 * Modification history : 2015/8/10 16:40 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
public class MonitorStaffDTOTransfer {
    public static TCscMonitorStaff fromDto(TCscMonitorStaffDTO dto) {

        TCscMonitorStaff detail = new TCscMonitorStaff();
        if (null != dto) {
            BeanUtils.copyProperties(dto, detail);
        }
        return detail;
    }

    public static List<TCscMonitorStaff> fromDtoList(
            List<TCscMonitorStaffDTO> dtos) {
        List<TCscMonitorStaff> list = new ArrayList<TCscMonitorStaff>();
        if (null != dtos && dtos.size() > 0) {
            for (TCscMonitorStaffDTO dto : dtos) {
                TCscMonitorStaff detail = new TCscMonitorStaff();
                if (null != dto) {
                    BeanUtils.copyProperties(dto, detail);
                }
                list.add(detail);
            }
        }
        return list;
    }
}
