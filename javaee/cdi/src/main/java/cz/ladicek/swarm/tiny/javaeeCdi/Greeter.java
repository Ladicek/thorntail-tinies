package cz.ladicek.swarm.tiny.javaeeCdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeter {
    public String hello() {
        return "Hello from servlet with CDI";
    }
}
