//Powered By if, Since 2014 - 2020

package com.zs.pig.web.sys.mapper;


import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.zs.pig.common.sys.model.SysUser;

/**
 * 
 * @author 
 */

public interface SysUserMapper extends Mapper<SysUser>{
	
	public List<SysUser> findPageInfo(Map<String, Object> params);
	
}
