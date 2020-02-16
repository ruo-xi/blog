package com.app.app;

import com.app.app.entity.JWTToken;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {

    private String JWTToken;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Algorithm a = Algorithm.HMAC256("123");
        JWTToken = JWT.create()
                .withClaim("id", 1)
                .withClaim("name", "cao")
                .sign(a);
        System.out.println(JWT.decode(JWTToken).getClaim("id").asInt());
        redisTemplate.opsForSet().add("1","asdasd");
        redisTemplate.opsForSet();
        for (Iterator it = redisTemplate.opsForSet().members("1").iterator(); it.hasNext(); ) {
            Object s = it.next();
            System.out.println( (String)s);
        }
        System.out.println((String)redisTemplate.opsForSet().randomMember("1"));
    }

}
