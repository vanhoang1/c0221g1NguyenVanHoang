package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ProductApplication {
    @Bean("messageSource")
    public MessageSource productMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("static/messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
