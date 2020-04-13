package com.dimple.common.utils;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

public class RedisUtils {
	
	private RedisUtils(){}
	
	private static RedisUtils redisUtils = new RedisUtils();
	
	private RedisTemplate<String, Serializable> redisTemplate;
	
	public static RedisUtils getRedisUtils() {
		return redisUtils;
	}
	
	public void setRedisTemplate(RedisTemplate<String, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public boolean delete(String key) {
		return this.redisTemplate.delete(key);
	}

	public boolean hasKey(String key) {
		return this.redisTemplate.hasKey(key);
	}

	public RedisTemplate<String, Serializable> getRedisTemplate() {
		return this.redisTemplate;
	}
	
	public ValueOperations<String, Serializable> getValueOperations() {
		return this.redisTemplate.opsForValue();
	}
	
	public ListOperations<String, Serializable> getListOperations() {
		return this.redisTemplate.opsForList();
	}
	
}
