package com.zs.pig.common.redis.spring;


import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @Title <Redis单点缓存>
 * @Description 
 * @author Juce
 * @date 2016年10月9日 上午10:45:56
 * @version 1.0
 **/
public final class JedisSinglePoint implements Jedis {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
 
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T get(String key) {
		ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
		return valueOperations.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> void set(String key, T value) {
		ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, value);
	}

	@Override
	public <T extends Serializable> void setString(String key, String value) {
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set(key, value);
	}

	@Override
	public String getString(String key) {
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		return valueOperations.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public long incrAndGet(String key) {
		Long value = redisTemplate.opsForValue().increment(key, 1);
		return value == null ? 0 : value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long decrAndGet(String key) {
		Long value = redisTemplate.opsForValue().increment(key, -1);
		return value == null ? 0 : value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(String key) {
		Set<String> keys = redisTemplate.keys(key);
		redisTemplate.delete(keys);
	}
	@Override
	public void setLong(String key, long value) {
		setString(key, Long.toString(value));
	}

	@Override
	public Long getLong(String key) {
		String value = getString(key);
		if (value != null) {
			return Long.parseLong(value);
		}
		return null;
	}
}
