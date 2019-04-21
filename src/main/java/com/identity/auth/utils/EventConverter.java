package com.identity.auth.utils;

import com.identity.auth.events.Event;
import com.identity.auth.persistence.entities.EventEntity;

public class EventConverter {

    /**
     * Convert Event to EventEntity
     * @param event
     * @return
     */
    public static EventEntity toEventEntity(Event event){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setObjectId(event.getObjectId());
        eventEntity.setObjectType(event.getObjectType());
        eventEntity.setEventType(event.getEventType());
        return eventEntity;
    }
}
