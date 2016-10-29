//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.CmsSite;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface CmsSiteService  extends BaseService<CmsSite>{

	
	
	/**
	 * 保存或更新
	 * 
	 * @param CmsSite
	 * @return
	 */
	public int savecmsSite(CmsSite CmsSite) ;

	/**
	 * 删除
	* @param CmsSite
	* @return
	 */
	public int deleteCmsSite(CmsSite CmsSite) ;


}
