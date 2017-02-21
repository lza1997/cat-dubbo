//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsImg;
import com.zs.pig.cms.api.service.CmsImgService;
import com.zs.pig.cms.mapper.CmsImgMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("CmsImgService")
public class CmsImgServiceImpl extends ServiceMybatis<CmsImg> implements CmsImgService {

	@Resource
	private CmsImgMapper CmsImgMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsImg
	 * @return
	 */
	public int savecmsImg(CmsImg CmsImg) {
		return this.save(CmsImg);
	}

	/**
	 * 删除
	* @param CmsImg
	* @return
	 */
	public int deleteCmsImg(CmsImg CmsImg) {
		return this.delete(CmsImg);
	}


}
