package com.borrow_book.controller.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerBook {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing(pointcut = "execution(public * com.borrow_book.controller.BorrowBookController.*(..))")
    public void logError(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.error("class name :" +className);
        logger.error("method :" +method);
        logger.error("args :" +args);
    }
    @AfterReturning(pointcut ="execution(public * com.borrow_book.controller.BorrowBookController.*(..))")
    public  void  logReturn(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("class name :" +className);
        logger.info("method :" +method);
        logger.info("args :" +args);
    }
}
