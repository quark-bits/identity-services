package com.identity.auth.events.user;

import com.identity.auth.business.managers.EventManager;
import com.identity.auth.business.managers.impl.DefaultEventManager;
import com.identity.auth.events.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Listener that observes for UserEvents.
@Component
public class UserObserver implements Observer<UserEvent> {

    @Autowired
    EventManager eventManager;

    public void update(UserEvent userEvent){
        eventManager.save(userEvent);
    }
}
