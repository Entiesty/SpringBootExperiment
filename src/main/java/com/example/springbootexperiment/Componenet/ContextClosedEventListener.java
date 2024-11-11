package com.example.springbootexperiment.Componenet;

import jakarta.annotation.Nullable;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(@Nullable ContextClosedEvent contextClosedEvent) {
        System.out.println("[ApplicationListener] ApplicationContext closed!");
    }
}
