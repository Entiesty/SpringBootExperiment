package com.example.springbootexperiment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.example.springbootexperiment.mapper")
public class SpringBootExperimentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExperimentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            System.out.println("容器中注入的Bean为：");
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            for(String beanName : beanNames) {
                if (beanName.startsWith("book") || beanName.startsWith("user")) {
                    System.out.println(beanName);
                }
            }
        };
    }
}
