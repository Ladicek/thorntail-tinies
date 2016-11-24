package cz.ladicek.swarm.tiny.fractionAutodetectionCdiJaxrsEjb;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
    public String hello(String name) {
        return "Hello, " + name + "!";
    }
}
