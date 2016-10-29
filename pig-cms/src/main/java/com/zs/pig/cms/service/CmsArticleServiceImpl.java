//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.cms.api.service.CmsArticleService;
import com.zs.pig.cms.mapper.CmsArticleMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("CmsArticleService")
public class CmsArticleServiceImpl extends ServiceMybatis<CmsArticle> implements CmsArticleService {

	@Resource
	private CmsArticleMapper CmsArticleMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsArticle
	 * @return
	 */
	public int savecmsArticle(CmsArticle CmsArticle) {
		return this.save(CmsArticle);
	}

	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteCmsArticle(CmsArticle CmsArticle) {
		return this.delete(CmsArticle);
	}


}
