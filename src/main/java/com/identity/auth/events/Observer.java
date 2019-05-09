package com.identity.auth.events;

// Listeners will implement
public interface Observer<T extends Event> {
    void update(T t);
}
