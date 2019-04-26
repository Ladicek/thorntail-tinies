package cz.ladicek.swarm.tiny.javaeeJaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
@javax.inject.Singleton
public class HelloResource {
    @GET
    public String get() {
        return "Hello from JAX-RS";
    }
}
