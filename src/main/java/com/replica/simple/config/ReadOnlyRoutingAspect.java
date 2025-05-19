package com.replica.simple.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Aspect
@Component
public class ReadOnlyRoutingAspect {

    @Before("execution(* com.replica..*Service.*(..))")
    public void route() {
        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        RoutingDataSource.use(readOnly ? "replica" : "master");
    }

    @After("execution(* com.replica..*Service.*(..))")
    public void clear() {
        RoutingDataSource.clear();
    }
}
