package com.jyk.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author : Jing Yuankui
 * @description : Redis配置类
 * @date : Created in 2024/8/14 0:22
 */
@Configuration
public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);


    // 从配置文件中读取Redis主机信息
    @Value("${spring.redis.host}")
    private String redisHost;

    // 从配置文件中读取Redis端口信息
    @Value("${spring.redis.port}")
    private int redisPort;

    // 从配置文件中读取Redis密码信息
    @Value("${spring.redis.password}")
    private String redisPassword;

    // 配置Redis连接工厂
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 创建Redis的单机配置
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisHost, redisPort);
        config.setPassword(redisPassword);
        RedisConnectionFactory conn = new LettuceConnectionFactory(config);
        logger.info("Redis初始化..., 结果: {}", conn);
        // 返回Lettuce连接工厂
        return conn;
    }

    // 配置RedisTemplate
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建RedisTemplate实例
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(connectionFactory);
        // 设置默认的序列化器为GenericJackson2JsonRedisSerializer，用于序列化键和值为JSON格式
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        // 设置键的序列化器为StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        // 设置值的序列化器为GenericJackson2JsonRedisSerializer
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 返回配置好的RedisTemplate实例
        return template;
    }


}
