package cz.ladicek.swarm.tiny.javaeeJaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@javax.enterprise.context.ApplicationScoped
public class RestApplication extends Application {
}
