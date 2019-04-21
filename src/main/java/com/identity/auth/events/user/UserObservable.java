package com.identity.auth.events.user;

import com.identity.auth.events.Observable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User Observable Singleton
 */
public enum UserObservable implements Observable<UserObserver,UserEvent> {
    INSTANCE;

    private static Set<UserObserver> userObservers = Collections.synchronizedSet(new HashSet<>());

    /* private Constructor */
    UserObservable() {}

    public void register(UserObserver userObserver){
        userObservers.add(userObserver);
    }

    public void unRegister(UserObserver userObserver){
        userObservers.remove(userObserver);
    }

    public void notifyObservers(UserEvent userEvent){
        for (UserObserver userObserver: userObservers) {
            userObserver.update(userEvent);
        }
    }
}
