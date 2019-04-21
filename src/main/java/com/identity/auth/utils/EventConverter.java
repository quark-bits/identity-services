package com.identity.auth.utils;

import com.identity.auth.events.Event;
import com.identity.auth.persistence.entities.EventEntity;
import com.identity.auth.persistence.entities.ObjectIDType;

public class EventConverter {

    /**
     * Convert Event to EventEntity
     * @param event
     * @return
     */
    public static EventEntity toEventEntity(Event event){
        EventEntity eventEntity = new EventEntity();

        // Composite Key
        ObjectIDType objectIDType = new ObjectIDType();
        objectIDType.setObjectId(event.getObjectId());
        objectIDType.setObjectType(event.getObjectType());
        eventEntity.setIdType(objectIDType);

        eventEntity.setEventType(event.getEventType());
        return eventEntity;
    }
}
