package com.hendisantika;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-redis-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/21/23
 * Time: 07:43
 * To change this template use File | Settings | File Templates.
 */
@Path("/redisclient")
public class RedisResource {
    @Inject
    private RedisService service;
}
