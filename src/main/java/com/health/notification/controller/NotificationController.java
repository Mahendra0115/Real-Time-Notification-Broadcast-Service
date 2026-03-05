package com.health.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.health.notification.service.NotificationService;

/**
 * REST controller responsible for handling notification-related APIs.
 *
 * <p>
 * This controller exposes endpoints to trigger real-time notifications
 * using the {@link NotificationService}.
 * </p>
 *
 * <p>
 * Base URL: <b>/api</b>
 * </p>
 */
@RestController
@RequestMapping("/api")
public class NotificationController {

    /**
     * Service layer used to broadcast notifications
     * to WebSocket subscribers.
     */
    @Autowired
    private NotificationService notificationService;

    /**
     * Sends a notification message to all connected WebSocket clients.
     *
     * <p>
     * This endpoint triggers the broadcast mechanism which pushes
     * the message instantly to all subscribers listening on
     * <b>/topic/notifications</b>.
     * </p>
     *
     * Example request:
     * <pre>
     * POST /api/notify?message=Hello
     * </pre>
     *
     * @param message the notification message content
     * @return HTTP 200 response with confirmation message
     */
    @PostMapping("/notify")
    public ResponseEntity<String> notifyAll(@RequestParam String message) {
        notificationService.broadcast(message);
        return ResponseEntity.ok("Notification sent");
    }
}
