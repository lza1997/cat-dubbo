package com.zs.pig.common.beetl.function;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.zs.pig.common.constant.ZsCatConstant;
import com.zs.pig.common.redis.test.RedisUtils;
import com.zs.pig.common.sys.model.SysDict;
import com.zs.pig.web.sys.service.SysDictService;

/**
 * 字典方法
 * 传入参数 type
 */
@Component
public class DictFunction{
	
	@Resource
	private SysDictService sysDictService;
	
	/**
	 * 根据类型和键值得到字典实体
	* @param type 如sys_data_scope等
	* @param value 
	 */
	public SysDict getDictByTypeAndValue(String type,String value){
		Table<String,String, SysDict> tableDicts = sysDictService.findAllDictTable();
		return tableDicts.get(type, value);
	}
	
	/**
	 * 根据类型得到字典列表
	* @param type 如sys_data_scope等
	 */
	public List<SysDict> getDictListByType(String type){
		return (List<SysDict>) sysDictService.findAllMultimap().get(type);
	}
	
	/**
	 * 根据类型得到字典列表
	* @param type 如sys_data_scope等
	 */
	public List<SysDict> getDictListByTypeAndSite(String type){
		SysDict sysdict=new SysDict();
		sysdict.setCreateBy(RedisUtils.get(ZsCatConstant.SITEID, "1"));
		List<SysDict> dictList = sysDictService.select(sysdict);
		Multimap<String, SysDict> multimap = ArrayListMultimap.create();
		for(SysDict dict : dictList){
			multimap.put(dict.getType(), dict);
		}
		return (List<SysDict>) multimap.get(type);
	}
	/**
	 * 全部字典
	 */
	public Collection<String> getAllDictType(){
		return sysDictService.findAllMultimap().keySet();
	}

}
