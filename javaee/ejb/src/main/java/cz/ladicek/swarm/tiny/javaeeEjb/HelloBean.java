package cz.ladicek.swarm.tiny.javaeeEjb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {
    public String hello() {
        return "Hello from EJB";
    }
}
