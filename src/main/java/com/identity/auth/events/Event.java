package com.identity.auth.events;

/**
 * Marker Interface to be implemented by all Event Class
 */
public interface Event {
    Long getObjectId();

    int getObjectType();

    String getEventType();
}
