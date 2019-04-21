package com.identity.auth.events;

import com.identity.auth.events.user.UserObservable;
import com.identity.auth.events.user.UserObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Register Event Handlers on context Refresh.
 */
@Component
public class RegisterEventHandlersOnStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserObserver userObserver;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Register UserObserver
        UserObservable.INSTANCE.register(userObserver);
    }
}
