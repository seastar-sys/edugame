package com.dimple.framework.config;

import com.dimple.common.utils.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RedisHttpSessionConfig {

	
	@Bean
	public RedisTemplate<String,Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory){
		RedisTemplate<String, Serializable> template = new RedisTemplate<String, Serializable>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());// Hash key序列化
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());// Hash value序列化
		template.setConnectionFactory(redisConnectionFactory);
		RedisUtils.getRedisUtils().setRedisTemplate(template);
		return template;
	}
	
}
