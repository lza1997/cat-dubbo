package com.zs.pig.common.redis.spring;


import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {

	private Resource addressConfig;  
    private String addressKeyPrefix ;  
  
    private JedisCluster jedisCluster;  
    private Integer timeout;  
    private Integer maxRedirections;  
    private GenericObjectPoolConfig genericObjectPoolConfig;  
      
    private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$"); 
	

	@Override
	public JedisCluster getObject() throws Exception {
		// TODO Auto-generated method stub
		return jedisCluster; 
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		 return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}
	private Set<HostAndPort> parseHostAndPort() throws Exception {  
        try {  
            Properties prop = new Properties();  
            prop.load(this.addressConfig.getInputStream());  
  
            Set<HostAndPort> haps = new HashSet<HostAndPort>();  
            for (Object key : prop.keySet()) {  
  
                if (!((String) key).startsWith(addressKeyPrefix)) {  
                    continue;  
                }  
  
                String val = (String) prop.get(key);  
  
                boolean isIpPort = p.matcher(val).matches();  
  
                if (!isIpPort) {  
                    throw new IllegalArgumentException("ip 或 port 不合法");  
                }  
                String[] ipAndPort = val.split(":");  
  
                HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));  
                haps.add(hap);  
            }  
  
            return haps;  
        } catch (IllegalArgumentException ex) {  
            throw ex;  
        } catch (Exception ex) {  
            throw new Exception("解析 jedis 配置文件失败", ex);  
        }  
    }  
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		Set<HostAndPort> haps = this.parseHostAndPort();  
        
        jedisCluster = new JedisCluster(haps, timeout, maxRedirections,genericObjectPoolConfig);  
	}
	public void setAddressConfig(Resource addressConfig) {
		this.addressConfig = addressConfig;
	}

	public void setAddressKeyPrefix(String addressKeyPrefix) {
		this.addressKeyPrefix = addressKeyPrefix;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public void setMaxRedirections(Integer maxRedirections) {
		this.maxRedirections = maxRedirections;
	}

	public void setGenericObjectPoolConfig(
			GenericObjectPoolConfig genericObjectPoolConfig) {
		this.genericObjectPoolConfig = genericObjectPoolConfig;
	}

}
