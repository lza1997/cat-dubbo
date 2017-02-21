package com.zs.pig.common.constant;

import com.zs.pig.common.redis.test.RedisUtils;

public class ZsCatConstant {

	/**
	 * 多站式id
	 */
	public static final String SITEID = "SITEID";
	public static final String IMGSERVER = "http://image.zscat.com";
	public static final String pictureSaveFilePath ="C:\\info\\zscat\\upload";
	public static final String CMSpictureSaveFilePath ="C:\\info\\zscat\\upload\\"+RedisUtils.get(SITEID, "1");
}
