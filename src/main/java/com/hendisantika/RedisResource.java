package com.hendisantika;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

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

    @PUT
    @Path("/{key}")
    public void increment(String key, Integer value) {
        service.increment(key, value);
    }

    @DELETE
    @Path("/{key}")
    public Uni<Void> delete(String key) {
        return service.delete(key);
    }
}
