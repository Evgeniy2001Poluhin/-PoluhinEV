package com.example.urlshortener;

import java.util.UUID;

public class User {
    private String userId;

    public User() {
        this.userId = UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }
}