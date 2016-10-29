//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsSite;
import com.zs.pig.cms.api.service.CmsSiteService;
import com.zs.pig.cms.mapper.CmsSiteMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("CmsSiteService")
public class CmsSiteServiceImpl extends ServiceMybatis<CmsSite> implements CmsSiteService {

	@Resource
	private CmsSiteMapper CmsSiteMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsSite
	 * @return
	 */
	public int savecmsSite(CmsSite CmsSite) {
		return this.save(CmsSite);
	}

	/**
	 * 删除
	* @param CmsSite
	* @return
	 */
	public int deleteCmsSite(CmsSite CmsSite) {
		return this.delete(CmsSite);
	}


}
