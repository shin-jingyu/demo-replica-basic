package com.replica.simple.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void use(String key) {
        contextHolder.set(key);
    }

    public static void clear() {
        contextHolder.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return contextHolder.get() != null ? contextHolder.get() : "master";
    }
}
