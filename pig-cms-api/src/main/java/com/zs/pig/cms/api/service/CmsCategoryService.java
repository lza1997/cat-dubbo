//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.CmsCategory;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface CmsCategoryService  extends BaseService<CmsCategory>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsCategory
	 * @return
	 */
	public int savecmsCategory(CmsCategory CmsCategory) ;

	/**
	 * 删除
	* @param CmsCategory
	* @return
	 */
	public int deleteCmsCategory(CmsCategory CmsCategory) ;


}
