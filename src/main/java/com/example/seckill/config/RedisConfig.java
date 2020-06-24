package com.example.seckill.config;

import com.example.seckill.entity.SkUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Date 2020/6/24 9:56
 * @Author mawkun
 */
@Configuration
public class RedisConfig{
    @Bean
    public RedisTemplate<String, SkUser>redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,SkUser>template=new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return template;
    }
}
