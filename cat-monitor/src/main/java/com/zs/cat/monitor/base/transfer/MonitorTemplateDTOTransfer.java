package com.zs.cat.monitor.base.transfer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zs.cat.monitor.api.dto.TCscMonitorTemplateDTO;
import com.zs.cat.monitor.base.bean.TCscMonitorTemplate;

public class MonitorTemplateDTOTransfer {
	public static TCscMonitorTemplate fromDto(TCscMonitorTemplateDTO dto) {

		TCscMonitorTemplate detail = new TCscMonitorTemplate();
		if (null != dto) {
			BeanUtils.copyProperties(dto, detail);
		}
		return detail;
	}

	public static List<TCscMonitorTemplate> fromDtoList(
			List<TCscMonitorTemplateDTO> dtos) {
		List<TCscMonitorTemplate> list = new ArrayList<TCscMonitorTemplate>();
		if (null != dtos && dtos.size() > 0) {
			for (TCscMonitorTemplateDTO dto : dtos) {
				TCscMonitorTemplate detail = new TCscMonitorTemplate();
				if (null != dto) {
					BeanUtils.copyProperties(dto, detail);
				}
				list.add(detail);
			}
		}
		return list;
	}
}
