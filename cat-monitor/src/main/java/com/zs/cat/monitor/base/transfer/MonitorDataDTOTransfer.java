package com.zs.cat.monitor.base.transfer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zs.cat.monitor.api.dto.TCsmMonitorDataDTO;
import com.zs.cat.monitor.base.bean.TCsmMonitorData;


public class MonitorDataDTOTransfer {
	public static TCsmMonitorData fromDto(TCsmMonitorDataDTO dto) {

		TCsmMonitorData detail = new TCsmMonitorData();
		if (null != dto) {
			BeanUtils.copyProperties(dto, detail);
		}
		return detail;
	}

	public static List<TCsmMonitorData> fromDtoList(
			List<TCsmMonitorDataDTO> dtos) {
		List<TCsmMonitorData> list = new ArrayList<TCsmMonitorData>();
		if (null != dtos && dtos.size() > 0) {
			for (TCsmMonitorDataDTO dto : dtos) {
				TCsmMonitorData detail = new TCsmMonitorData();
				if (null != dto) {
					BeanUtils.copyProperties(dto, detail);
				}
				list.add(detail);
			}
		}
		return list;
	}
}
