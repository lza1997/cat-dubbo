//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.CmsImg;
import com.zs.pig.common.base.BaseService;


/**
 * 
 * @author
 */


public interface CmsImgService extends BaseService<CmsImg>{


	
	/**
	 * 保存或更新
	 * 
	 * @param CmsImg
	 * @return
	 */
	public int savecmsImg(CmsImg CmsImg) ;

	/**
	 * 删除
	* @param CmsImg
	* @return
	 */
	public int deleteCmsImg(CmsImg CmsImg);


}
