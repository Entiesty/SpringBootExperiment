package com.example.springbootexperiment.Componenet;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ContextClosedEventAnnotationListener {
    @EventListener
    @Order(2)
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("[EventListener] ApplicationContext closed!");
    }
}
