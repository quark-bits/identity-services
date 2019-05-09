package com.identity.auth.business.managers;

import com.identity.auth.events.Event;

/**
 * Manager to Handle persisting of Events.
 */
public interface EventManager {
    void save(Event event);
}
