//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface CmsArticleService extends BaseService<CmsArticle>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsArticle
	 * @return
	 */
	public int savecmsArticle(CmsArticle CmsArticle) ;
	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteCmsArticle(CmsArticle CmsArticle);
	public PageInfo<CmsArticle> FindInfoPage(int i, int j, CmsArticle a,
			String string);


}
