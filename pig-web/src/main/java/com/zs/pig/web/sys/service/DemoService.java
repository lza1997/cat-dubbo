//Powered By if, Since 2014 - 2020

package com.zs.pig.web.sys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.common.base.ServiceMybatis;
import com.zs.pig.common.sys.model.Demo;
import com.zs.pig.web.sys.mapper.DemoMapper;

/**
 * 
 * @author
 */

@Service("DemoService")
public class DemoService extends ServiceMybatis<Demo> {

	@Resource
	private DemoMapper DemoMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Demo
	 * @return
	 */
	public int savedemo(Demo Demo) {
		return this.save(Demo);
	}

	/**
	 * 删除
	* @param Demo
	* @return
	 */
	public int deleteDemo(Demo Demo) {
		return this.delete(Demo);
	}


}
