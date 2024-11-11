package com.example.springbootexperiment.Componenet;

import jakarta.annotation.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImplBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(@Nullable Object bean,@Nullable String beanName) throws BeansException {
        if("bookServiceImpl".equals(beanName)) {
            System.out.println("Hello！postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean,@Nullable String beanName) throws BeansException {
        if("bookServiceImpl".equals(beanName)) {
            System.out.println("Hello！postProcessAfterInitialization");
        }
        return bean;
    }
}
