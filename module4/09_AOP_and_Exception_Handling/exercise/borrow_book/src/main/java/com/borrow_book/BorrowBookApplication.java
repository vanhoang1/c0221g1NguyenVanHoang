package com.borrow_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class BorrowBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowBookApplication.class, args);
    }

}
