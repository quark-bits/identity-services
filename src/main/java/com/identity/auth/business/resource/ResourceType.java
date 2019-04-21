package com.identity.auth.business.resource;

import lombok.Getter;

@Getter
public enum ResourceType {
    USER(1),
    GROUP(2);

    private int type;

    ResourceType(int type) {
        this.type = type;
    }
}
