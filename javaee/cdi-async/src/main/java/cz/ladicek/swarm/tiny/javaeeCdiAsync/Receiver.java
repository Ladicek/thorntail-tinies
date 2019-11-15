package cz.ladicek.swarm.tiny.javaeeCdiAsync;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class Receiver {
    public void init(@ObservesAsync InitAsyncEvent event) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
