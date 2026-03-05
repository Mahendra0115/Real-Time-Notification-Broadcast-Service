package com.health.notification.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configuration class for enabling and configuring WebSocket messaging
 * using STOMP protocol in the Notification System.
 *
 * <p>
 * This class sets up:
 * <ul>
 *     <li>STOMP message broker with topic-based messaging</li>
 *     <li>Application destination prefixes</li>
 *     <li>WebSocket endpoint registration with SockJS fallback</li>
 * </ul>
 * </p>
 *
 * <p>
 * Endpoint exposed: <b>/ws</b><br>
 * Broker prefix: <b>/topic</b><br>
 * Application prefix: <b>/app</b>
 * </p>
 *
 * @author Mahendra
 * @since 1.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker for handling messages between
     * clients and the server.
     *
     * <p>
     * enableSimpleBroker("/topic"):
     * Enables a simple in-memory message broker for destinations
     * starting with "/topic".
     *
     * setApplicationDestinationPrefixes("/app"):
     * Messages sent from clients to the server must start with "/app".
     * </p>
     *
     * @param config the MessageBrokerRegistry used to configure broker options
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registers STOMP over WebSocket endpoint for client connections.
     *
     * <p>
     * Endpoint: "/ws"<br>
     * setAllowedOriginPatterns("*") allows cross-origin requests
     * (should be restricted in production).<br>
     * withSockJS() enables fallback options for browsers that do not
     * support native WebSocket.
     * </p>
     *
     * @param registry the StompEndpointRegistry used to register endpoints
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
