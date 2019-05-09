package com.identity.auth;

public enum AuthAppConstants {
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    UNAUTHORIZED("UNAUTHORIZED"),
    UNAUTHENTICATED("UNAUTHENTICATED"),

    DEFAULT_SALT_LENGTH(32,"DEFAULT_SALT_LENGTH");

    private int code;
    private String description;

    AuthAppConstants(int code, String description) {
        this.code = code;
        this.description = description;
    }

    AuthAppConstants(String description) {
        this.description = description;
    }

    AuthAppConstants(int code) {
        this.code = code;
    }
}
