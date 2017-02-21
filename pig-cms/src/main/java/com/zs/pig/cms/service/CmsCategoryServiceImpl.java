//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsCategory;
import com.zs.pig.cms.api.service.CmsCategoryService;
import com.zs.pig.cms.mapper.CmsCategoryMapper;
import com.zs.pig.common.base.ServiceMybatis;
import com.zs.pig.common.constant.ZsCatConstant;
import com.zs.pig.common.redis.test.RedisUtils;

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
		CmsCategory.setSiteId(Long.parseLong(RedisUtils.get(ZsCatConstant.SITEID,"1")));
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
