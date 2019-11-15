package cz.ladicek.swarm.tiny.javaeeCdiAsync;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitAsyncEvent {
    @Inject
    private Event<InitAsyncEvent> initAsyncEvent;

    public void onStartup(@Observes @Initialized(ApplicationScoped.class) Object event) {
        System.out.println("?????????????????????????????????");
        initAsyncEvent.fireAsync(new InitAsyncEvent());
    }
}
