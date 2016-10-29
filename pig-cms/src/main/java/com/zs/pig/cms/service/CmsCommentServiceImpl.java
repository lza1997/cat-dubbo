//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsComment;
import com.zs.pig.cms.api.service.CmsCommentService;
import com.zs.pig.cms.mapper.CmsCommentMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("CmsCommentService")
public class CmsCommentServiceImpl extends ServiceMybatis<CmsComment> implements CmsCommentService {

	@Resource
	private CmsCommentMapper CmsCommentMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsComment
	 * @return
	 */
	public int savecmsComment(CmsComment CmsComment) {
		return this.save(CmsComment);
	}

	/**
	 * 删除
	* @param CmsComment
	* @return
	 */
	public int deleteCmsComment(CmsComment CmsComment) {
		return this.delete(CmsComment);
	}


}
