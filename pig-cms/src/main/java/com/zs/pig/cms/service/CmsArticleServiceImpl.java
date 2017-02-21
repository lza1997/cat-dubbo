//Powered By ZSCAT, Since 2014 - 2020

package com.zs.pig.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.cms.api.service.CmsArticleService;
import com.zs.pig.cms.mapper.CmsArticleMapper;
import com.zs.pig.common.base.ServiceMybatis;
import com.zs.pig.common.constant.ZsCatConstant;
import com.zs.pig.common.redis.test.RedisUtils;
import com.zs.pig.common.sys.model.SysResource;

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
		CmsArticle.setSiteid(Long.parseLong(RedisUtils.get(ZsCatConstant.SITEID,"1")));
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

	@Override
	public PageInfo<CmsArticle> FindInfoPage(int pageNum, int pageSize, CmsArticle a,
			String orderBy) {
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("orderBy", orderBy);
		PageHelper.startPage(params);
		List<CmsArticle> list = CmsArticleMapper.findPageInfo(params);
		return new PageInfo<CmsArticle>(list);
	}


}
