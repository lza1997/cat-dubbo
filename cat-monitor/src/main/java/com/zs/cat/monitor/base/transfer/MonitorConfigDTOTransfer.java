package com.zs.cat.monitor.base.transfer;

import com.zs.cat.monitor.api.dto.TCscMonitorConfigDTO;
import com.zs.cat.monitor.base.bean.TCscMonitorConfig;

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
 * Modification history : 2015/7/15 11:35 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
public class MonitorConfigDTOTransfer {
    public static TCscMonitorConfig fromDto(TCscMonitorConfigDTO dto) {

        TCscMonitorConfig detail = new TCscMonitorConfig();
        if (null != dto) {
            BeanUtils.copyProperties(dto, detail);
        }
        return detail;
    }

    public static List<TCscMonitorConfig> fromDtoList(
            List<TCscMonitorConfigDTO> dtos) {
        List<TCscMonitorConfig> list = new ArrayList<TCscMonitorConfig>();
        if (null != dtos && dtos.size() > 0) {
            for (TCscMonitorConfigDTO dto : dtos) {
                TCscMonitorConfig detail = new TCscMonitorConfig();
                if (null != dto) {
                    BeanUtils.copyProperties(dto, detail);
                }
                list.add(detail);
            }
        }
        return list;
    }
}
