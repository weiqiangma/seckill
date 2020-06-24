package com.example.seckill;

import com.example.seckill.entity.SkUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SeckillApplicationTests {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        SkUser user = new SkUser();
        user.setNickname("kobe");
        user.setLoginCount(5);
        user.setPassword("mawkun123456");
        user.setSalt("salt");
        redisTemplate.opsForValue().set("name", user);
        redisTemplate.expire("name",60, TimeUnit.SECONDS);
        System.err.println("-------------------");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

}
