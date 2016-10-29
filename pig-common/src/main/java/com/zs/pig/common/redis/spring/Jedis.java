package com.zs.pig.common.redis.spring;


import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 *@author Juce
 *@时间 2016年8月25日下午9:18:20
 *@版本 version 1.0
 **/

@Service
public interface Jedis {
	
	public <T extends Serializable> T get(String key);
	
	public <T extends Serializable> void set(String key, T value);
	
	public <T extends Serializable> void setString(String key, String value);
	
	public String getString(String key);
	
	public void setLong(String key, long value);
	
	public Long getLong(String key);
	
	public long incrAndGet(String key);
	
	public long decrAndGet(String key);
	
	public void delete(String key);

}
