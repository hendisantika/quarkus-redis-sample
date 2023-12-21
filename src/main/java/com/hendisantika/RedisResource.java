package com.hendisantika;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

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
@Path("/redis")
public class RedisResource {
    @Inject
    private RedisService service;

    @GET
    public Uni<List<String>> keys() {
        return service.keys();
    }

    @Path("/{command}/{parameter}")
    @POST
    public String execute(String command, String parameter) {
        return service.execute(command, parameter);
    }

    @POST
    public Data create(Data data) {
        service.set(data);
        return data;
    }

    @GET
    @Path("/{key}")
    public Data get(String key) {
        return new Data(key, service.get(key));
    }
}
