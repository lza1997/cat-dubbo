//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.Nav;
import com.zs.pig.cms.api.service.NavService;
import com.zs.pig.cms.mapper.NavMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("NavService")
public class NavServiceImpl extends ServiceMybatis<Nav> implements NavService {

	@Resource
	private NavMapper NavMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Nav
	 * @return
	 */
	public int savenav(Nav Nav) {
		return this.save(Nav);
	}

	/**
	 * 删除
	* @param Nav
	* @return
	 */
	public int deleteNav(Nav Nav) {
		return this.delete(Nav);
	}


}
