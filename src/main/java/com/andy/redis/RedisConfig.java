package com.andy.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	private String host="127.0.0.1";
	private int port=6379;
	private int timeout=300;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
	    jedisConnectionFactory.setHostName(host);
	    jedisConnectionFactory.setPort(port);
	    jedisConnectionFactory.setTimeout(timeout);
		return jedisConnectionFactory;
	}
	@Bean
	public RedisTemplate<String, String>redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, String>redisTemplate=new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
	@Bean
	public CacheManager cacheManager(RedisTemplate<String, String>redisTemplate){
		RedisCacheManager cacheManager=new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(300);
		return cacheManager;
	}
}
