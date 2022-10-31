package dome.web.oem.controlle.rides;

import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

/**
 * @author:
 * @date: 2020/1/6
 * @description:
 **/
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();//序列化为String
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);//序列化为Json

        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        this.redisTemplate = redisTemplate;
    }

    public String setMsg(String key,String msg) {
        redisTemplate.opsForValue().set(key,msg);
        return "success";
    }
    public String getMsg(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置写入的有效时间
     */
    public String setMsgTime(String key,String msg,Long expiredTime){
        redisTemplate.opsForValue().set(key,msg,expiredTime,TimeUnit.SECONDS);// 这里设置的时间单位为秒
        return   "success";
    }

}