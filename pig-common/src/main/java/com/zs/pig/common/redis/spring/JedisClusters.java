package com.zs.pig.common.redis.spring;



import java.io.Serializable;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @Title <Redis集群缓存>
 * @Description 
 * @author Juce
 * @date 2016年10月9日 上午10:44:25
 * @version 1.0
 **/
public final class JedisClusters implements Jedis {

	@Autowired
	private JedisCluster jedisCluster;
	
	private JedisClusters() {
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T get(String key) {
		String value = jedisCluster.get(key);
		if (value == null) {
			return (T) value;
		}
		return (T) DataConverter.unserialize(DataConverter.hex2byte(value));
	}
	
	public <T extends Serializable> void set(String key, T value) {
		jedisCluster.set(key, DataConverter.byte2hex(DataConverter.serialize(value)));
	}
	
	public <T extends Serializable> void setString(String key, String value) {
		jedisCluster.set(key, value);
	}
	
	public String getString(String key) {
		return jedisCluster.get(key);
	}
	
	public long incrAndGet(String key) {
		Long value = jedisCluster.incr(key);
		return value == null ? 0 : value;
	}
	
	public long decrAndGet(String key) {
		Long value = jedisCluster.decr(key);
		return value == null ? 0 : value;
	}
	
	public void delete(String pattern) {
		 TreeSet<String> keys = new TreeSet<>();  
	        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();  
	        for(String k : clusterNodes.keySet()){   
	            JedisPool jp = clusterNodes.get(k);  
	            redis.clients.jedis.Jedis connection = jp.getResource();  
	            try {  
	                keys.addAll(connection.keys(pattern));  
	            } catch(Exception e){  
	            } finally{  
	                connection.close();//用完一定要close这个链接！！！  
	            }  
	        }  
	        for (String string : keys) {
	        	jedisCluster.del(string);	
			}
	}
	public void setLong(String key, long value) {
		setString(key, Long.toString(value));
	}
	
	public Long getLong(String key) {
		String value = getString(key);
		if (value != null) {
			return Long.parseLong(value);
		}
		return null;
	}
	

}
