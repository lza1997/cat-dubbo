//Powered By if, Since 2014 - 2020

package com.zs.pig.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.zs.pig.base.api.model.SysDict;
import com.zs.pig.base.api.service.SysDictService;
import com.zs.pig.base.mapper.SysDictMapper;
import com.zs.pig.common.base.ServiceMybatis;
import com.zs.pig.common.constant.ZsCatConstant;
import com.zs.pig.common.redis.test.RedisUtils;
import com.zs.pig.common.sys.model.SysArea;
import com.zs.pig.common.sys.model.SysOffice;
import com.zs.pig.common.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("SysDictService")
public class SysDictServiceImpl extends ServiceMybatis<SysDict> implements SysDictService {

	@Resource
	private SysDictMapper sysDictMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param sysDict
	 * @return
	 */
	public int saveSysdict(SysDict sysDict) {
		return this.save(sysDict);
	}

	/**
	 * 删除
	* @param sysDict
	* @return
	 */
	public int deleteSysDict(SysDict sysDict) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", sysDict.getValue());
		if(sysDict.getType().equals("sys_area_type")){
			int areaCount = this.beforeDelete(SysArea.class,params);
			if(areaCount<0) return -1;
		}
		if(sysDict.getType().equals("sys_office_type")){
			int officeCount = this.beforeDelete(SysOffice.class,params);
			if(officeCount<0) return -1;
		}
		if(sysDict.getType().equals("sys_data_scope")){
			int roleCount = this.beforeDelete(SysRole.class, params);
			if(roleCount<0) return -1;
		}
		return this.updateDelFlagToDelStatusById(SysDict.class, sysDict.getId());
	}

	public Table<String,String, SysDict> findAllDictTable(){
		List<SysDict> dictList = this.select(new SysDict());
		Table<String,String, SysDict> tableDicts = HashBasedTable.create();
		for(SysDict dict : dictList){
			tableDicts.put(dict.getType(), dict.getValue(), dict);
		}
		return tableDicts;
	}
	
	public Multimap<String, SysDict> findAllMultimap(){
		List<SysDict> dictList = this.select(new SysDict());
		Multimap<String, SysDict> multimap = ArrayListMultimap.create();
		for(SysDict dict : dictList){
			multimap.put(dict.getType(), dict);
		}
		return multimap;
	}

}
