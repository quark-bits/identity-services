package com.identity.auth.business.managers.impl;

import com.identity.auth.business.managers.EventManager;
import com.identity.auth.events.Event;
import com.identity.auth.persistence.entities.EventEntity;
import com.identity.auth.persistence.respositories.EventRepository;
import com.identity.auth.utils.EventConverter;
import org.springframework.stereotype.Component;

@Component("eventManager")
public class DefaultEventManager implements EventManager {

    EventRepository eventRepository;

    public DefaultEventManager(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void save(Event event) {
        EventEntity eventEntity = EventConverter.toEventEntity(event);
        eventRepository.save(eventEntity);
    }
}
