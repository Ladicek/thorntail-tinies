package cz.ladicek.swarm.tiny.javaeeJsf;

import javax.enterprise.inject.Model;

@Model
public class Hello {
    public String hello() {
        return "Hello from JSF";
    }
}

