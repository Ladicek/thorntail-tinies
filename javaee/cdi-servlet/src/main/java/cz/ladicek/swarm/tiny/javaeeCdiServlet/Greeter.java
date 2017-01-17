package cz.ladicek.swarm.tiny.javaeeCdiServlet;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeter {
    public String hello() {
        return "Hello from servlet with CDI";
    }
}
