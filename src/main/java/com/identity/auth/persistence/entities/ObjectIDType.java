package com.identity.auth.persistence.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.Index;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
public class ObjectIDType implements Serializable {
    private Long objectId;
    private int objectType;

    public ObjectIDType() {
    }

    public ObjectIDType(Long objectId, int objectType) {
        this.objectId = objectId;
        this.objectType = objectType;
    }
}
