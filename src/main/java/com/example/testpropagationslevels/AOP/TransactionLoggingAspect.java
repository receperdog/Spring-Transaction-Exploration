package com.example.testpropagationslevels.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionLoggingAspect {
    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransaction(JoinPoint joinPoint) {
        System.out.println("Transaction started for method: " + joinPoint.getSignature().getName());
    }

    @After("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void afterTransaction(JoinPoint joinPoint) {
        System.out.println("Transaction ended for method: " + joinPoint.getSignature().getName());
    }
}
