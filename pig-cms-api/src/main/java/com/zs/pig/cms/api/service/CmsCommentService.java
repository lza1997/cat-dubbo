//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.CmsComment;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface CmsCommentService extends BaseService<CmsComment>{

	
	
	/**
	 * 保存或更新
	 * 
	 * @param CmsComment
	 * @return
	 */
	public int savecmsComment(CmsComment CmsComment);

	/**
	 * 删除
	* @param CmsComment
	* @return
	 */
	public int deleteCmsComment(CmsComment CmsComment) ;


}
