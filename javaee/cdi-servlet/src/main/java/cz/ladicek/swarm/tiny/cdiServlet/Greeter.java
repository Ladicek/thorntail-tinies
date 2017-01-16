package cz.ladicek.swarm.tiny.cdiServlet;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeter {
    public String hello() {
        return "Hello from servlet with CDI";
    }
}
