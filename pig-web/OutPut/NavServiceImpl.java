//Powered By ZSCAT, Since 2014 - 2020

package com.zs.pig.oa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.oa.api.model.Nav;
import com.zs.pig.oa.api.service.NavService;
import com.zs.pig.oa.mapper.NavMapper;
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
	public int saveNav(Nav Nav) {
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
