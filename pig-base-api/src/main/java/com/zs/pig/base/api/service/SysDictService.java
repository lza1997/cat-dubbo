//Powered By if, Since 2014 - 2020

package com.zs.pig.base.api.service;

import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.zs.pig.base.api.model.SysDict;
import com.zs.pig.common.base.BaseService;


/**
 * 
 * @author
 */


public interface SysDictService extends BaseService<SysDict> {


	/**
	 * 保存或更新
	 * 
	 * @param sysDict
	 * @return
	 */
	public int saveSysdict(SysDict sysDict) ;

	/**
	 * 删除
	* @param sysDict
	* @return
	 */
	public int deleteSysDict(SysDict sysDict) ;

	public Table<String,String, SysDict> findAllDictTable();
	
	public Multimap<String, SysDict> findAllMultimap();

}
