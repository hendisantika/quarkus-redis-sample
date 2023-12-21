package com.hendisantika;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.string.StringCommands;
import jakarta.inject.Singleton;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-redis-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/21/23
 * Time: 07:38
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class RedisService {
    private final ReactiveKeyCommands<String> keys;
    private final StringCommands<String, Integer> cmd;
    private final RedisDataSource redisDS;

    public RedisService(RedisDataSource redisDS, ReactiveRedisDataSource reactiveRedisDS) {
        this.redisDS = redisDS;
        keys = reactiveRedisDS.key();
        cmd = redisDS.string(Integer.class);
    }
}
