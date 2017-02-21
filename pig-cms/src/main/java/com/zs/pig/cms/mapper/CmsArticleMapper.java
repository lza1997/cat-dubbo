//Powered By ZSCAT, Since 2014 - 2020

package com.zs.pig.cms.mapper;

import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.common.sys.model.SysResource;


/**
 * 
 * @author zs 2016-5-24 21:51:40
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的cms
 */
public interface CmsArticleMapper extends Mapper<CmsArticle>{

	List<CmsArticle> findPageInfo(Map<String, Object> params);

}
