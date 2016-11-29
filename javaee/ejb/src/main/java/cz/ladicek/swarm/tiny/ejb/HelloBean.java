package cz.ladicek.swarm.tiny.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {
    public String hello() {
        return "Hello from EJB";
    }
}
