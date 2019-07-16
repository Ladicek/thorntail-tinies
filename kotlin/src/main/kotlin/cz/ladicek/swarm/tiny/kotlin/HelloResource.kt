package cz.ladicek.swarm.tiny.kotlin

import io.swagger.annotations.Api
import io.swagger.annotations.SwaggerDefinition
import io.swagger.annotations.Tag
import javax.ws.rs.DefaultValue
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Path("/")
@Api
@SwaggerDefinition(tags = [Tag(name = "Hello", description = "Hello World service")])
class HelloResource {
    @GET
    fun get(@QueryParam("name") @DefaultValue("World") name: String): String = "Hello, $name!"
}
