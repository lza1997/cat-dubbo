//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.GwInfo;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */


public interface GwInfoService extends BaseService<GwInfo> {

	
	/**
	 * 保存或更新
	 * 
	 * @param GwInfo
	 * @return
	 */
	public int savegwInfo(GwInfo GwInfo);

	/**
	 * 删除
	* @param GwInfo
	* @return
	 */
	public int deleteGwInfo(GwInfo GwInfo);


}
