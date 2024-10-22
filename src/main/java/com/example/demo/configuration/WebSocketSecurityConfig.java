/*package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@SuppressWarnings("deprecation")
@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
            .simpDestMatchers("/app/**").authenticated()  // Secure messages going to /app/**
            .simpSubscribeDestMatchers("/user/queue/**").authenticated()  // Secure user message subscriptions
            .anyMessage().denyAll();  // Deny any other messages
    }

    @Override
    protected boolean sameOriginDisabled() {
        return true;  // Allow cross-origin requests for WebSocket
    }
}*/


