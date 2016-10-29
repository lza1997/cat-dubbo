//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsCategory;
import com.zs.pig.cms.api.service.CmsCategoryService;
import com.zs.pig.cms.mapper.CmsCategoryMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("CmsCategoryService")
public class CmsCategoryServiceImpl extends ServiceMybatis<CmsCategory> implements CmsCategoryService {

	@Resource
	private CmsCategoryMapper CmsCategoryMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsCategory
	 * @return
	 */
	public int savecmsCategory(CmsCategory CmsCategory) {
		return this.save(CmsCategory);
	}

	/**
	 * 删除
	* @param CmsCategory
	* @return
	 */
	public int deleteCmsCategory(CmsCategory CmsCategory) {
		return this.delete(CmsCategory);
	}


}