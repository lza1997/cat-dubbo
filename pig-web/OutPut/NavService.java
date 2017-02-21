//Powered By if, Since 2014 - 2020

package com.zs.pig.oa.api.service;

import com.zs.pig.oa.api.model.Nav;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface NavService extends BaseService<Nav>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Nav
	 * @return
	 */
	public int save(Nav Nav) ;
	/**
	 * 删除
	* @param Nav
	* @return
	 */
	public int deleteNav(Nav Nav);


}
