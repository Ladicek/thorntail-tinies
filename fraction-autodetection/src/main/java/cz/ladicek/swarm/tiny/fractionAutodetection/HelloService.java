package cz.ladicek.swarm.tiny.fractionAutodetection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
    public String hello(String name) {
        return "Hello, " + name + "!";
    }
}
