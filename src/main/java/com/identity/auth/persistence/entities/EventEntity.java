package com.identity.auth.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
public class EventEntity extends BaseEntity {
    private Long id;
    private Long objectId;
    private int objectType;
    private String eventType;

    public EventEntity() {
        super();
    }
}
