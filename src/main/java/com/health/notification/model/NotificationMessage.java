package com.health.notification.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NotificationMessage {
    private String message;
    private String timestamp;

    public NotificationMessage() {}

    public NotificationMessage(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    // getters & setters
}

