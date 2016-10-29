//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.CmsLink;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface CmsLinkService  extends BaseService<CmsLink>{


	
	/**
	 * 保存或更新
	 * 
	 * @param CmsLink
	 * @return
	 */
	public int savecmsLink(CmsLink CmsLink) ;

	/**
	 * 删除
	* @param CmsLink
	* @return
	 */
	public int deleteCmsLink(CmsLink CmsLink);


}
