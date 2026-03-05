package com.health.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Configuration class for Redis setup.
 *
 * <p>
 * This class configures the Redis connection and provides
 * a {@link RedisTemplate} bean to interact with the Redis server.
 * </p>
 *
 * <p>
 * Redis is used for caching and can also be used for
 * Pub/Sub messaging in a scalable notification system.
 * </p>
 *
 * @author Mahendra
 */
@Configuration
public class RedisConfig {

    /**
     * Creates a Redis connection factory using Lettuce client.
     *
     * <p>
     * The hostname "redis" refers to the Docker service name
     * defined in docker-compose.yml. When running locally without Docker,
     * this should be changed to "localhost".
     * </p>
     *
     * @return RedisConnectionFactory instance configured with host and port
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory("redis", 6379);    // use for docker 
    	return new LettuceConnectionFactory("localhost", 6379);

    }

    /**
     * Creates a RedisTemplate bean for performing Redis operations.
     *
     * <p>
     * RedisTemplate provides high-level methods to interact with Redis,
     * such as storing and retrieving key-value pairs.
     * </p>
     *
     * @return RedisTemplate configured with the RedisConnectionFactory
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }
}
