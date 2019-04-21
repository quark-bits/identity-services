package com.identity.auth.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "events")
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class EventEntity extends BaseEntity {

    @Embedded
    private ObjectIDType idType;

    private String eventType;

    public EventEntity() {
        super();
    }
}
