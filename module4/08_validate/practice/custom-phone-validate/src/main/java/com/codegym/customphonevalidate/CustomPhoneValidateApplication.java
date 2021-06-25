package com.codegym.customphonevalidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication

public class CustomPhoneValidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomPhoneValidateApplication.class, args);
    }

}
