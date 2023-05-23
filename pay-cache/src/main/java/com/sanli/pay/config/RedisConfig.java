package com.sanli.pay.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanli.pay.service.RedisService;
import com.sanli.pay.service.impl.RedisServiceImpl;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@EnableCaching
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> createRedisTemple(RedisConnectionFactory redisConnectionFactory){
        RedisSerializer<Object> serializer = createRedisSerializer(); // 创建Json序列化器
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>(); // redis操作模板类
        redisTemplate.setConnectionFactory(redisConnectionFactory); // redis连接工厂

        redisTemplate.setKeySerializer(new StringRedisSerializer()); // redis的key序列化器（key为String）
        redisTemplate.setValueSerializer(serializer); // redis的value序列化器（value为JSON对象）

        redisTemplate.setHashKeySerializer(new StringRedisSerializer()); // redis的hashKey序列化器（key为String）
        redisTemplate.setHashValueSerializer(serializer); // redis的hashValue序列化器（value为JSON对象）

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisSerializer<Object> createRedisSerializer() {
        // 创建JSON序列化器
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // 解决查询缓存转换异常问题（ObjectMapper用于指定某些转换下的特殊规则）
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置序列化与反序列化的范围（ALL包括所有，如果只序列化字段为FIELD），以及哪些修饰符可以序列化与反序列化（ANY表示所有修饰符都需要序列化）
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL); // SpringBoot高版本设置下面代码，并将本行代码注释
        // 指定序列化输入的类型，NON_FINAL表示序列化的类必须是非final修饰的，否则将抛出异常，如果String以及Integer这些类型序列化将出现异常
        // 必须设置LaissezFaireSubTypeValidator.instance，否则无法将JSON转化为对象，会转化成LinkedHashMap类型
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper); // 初始化完成序列化的方法
        return serializer;
    }

    /**
     * 配置缓存管理器（springboot2.0后写法），当使用@Cacheable这些接口时需要将使用到RedisCacheManager配置的内容，才会使用到RedisCacheManager配置的内容
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory); // 无锁
        //设置Redis缓存有效期为1天
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig() // 采用默认配置
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(createRedisSerializer()))
                .entryTtl(Duration.ofDays(1));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
