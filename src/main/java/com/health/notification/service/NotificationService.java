package com.health.notification.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.health.notification.model.NotificationMessage;

/**
 * Service class responsible for handling notification broadcasting.
 *
 * <p>
 * This service uses Spring's {@link SimpMessagingTemplate} to send
 * real-time notifications to all subscribed WebSocket clients.
 * </p>
 *
 * <p>
 * Notifications are published to the topic:
 * <b>/topic/notifications</b>
 * </p>
 *
 * <p>
 * Used in a real-time communication system powered by WebSocket (STOMP).
 * </p>
 *
 * @author
 */
@Service
public class NotificationService {

    /**
     * Spring messaging template used to send messages
     * to WebSocket destinations.
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * Broadcasts a notification message to all subscribed clients.
     *
     * <p>
     * This method creates a {@link NotificationMessage} object
     * with the provided message and the current timestamp,
     * then sends it to the WebSocket topic
     * <b>/topic/notifications</b>.
     * </p>
     *
     * @param message the notification message content to be sent
     */
    public void broadcast(String message) {
        NotificationMessage notification =
                new NotificationMessage(message, LocalDateTime.now().toString());

        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }
}
