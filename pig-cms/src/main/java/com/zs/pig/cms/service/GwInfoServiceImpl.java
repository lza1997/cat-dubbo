//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.GwInfo;
import com.zs.pig.cms.api.service.GwInfoService;
import com.zs.pig.cms.mapper.GwInfoMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("GwInfoService")
public class GwInfoServiceImpl extends ServiceMybatis<GwInfo> implements GwInfoService {

	@Resource
	private GwInfoMapper GwInfoMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param GwInfo
	 * @return
	 */
	public int savegwInfo(GwInfo GwInfo) {
		return this.save(GwInfo);
	}

	/**
	 * 删除
	* @param GwInfo
	* @return
	 */
	public int deleteGwInfo(GwInfo GwInfo) {
		return this.delete(GwInfo);
	}


}
