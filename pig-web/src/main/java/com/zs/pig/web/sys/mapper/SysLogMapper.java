//Powered By if, Since 2014 - 2020

package com.zs.pig.web.sys.mapper;

import com.github.abel533.mapper.Mapper;
import com.zs.pig.common.sys.model.SysLog;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 
 */

public interface SysLogMapper extends Mapper<SysLog> {


	public List<SysLog> findSysLogList(Map<String, Object> params);
   

}
