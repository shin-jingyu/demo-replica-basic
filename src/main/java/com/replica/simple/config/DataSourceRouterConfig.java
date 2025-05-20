package com.replica.simple.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DataSourceRouterConfig {

    private final MasterReplicaProperties props;

    @Bean
    public DataSource routingDataSource() {
        DataSource master = props.getMaster().initializeDataSourceBuilder().build();
        DataSource replica = props.getReplica().initializeDataSourceBuilder().build();
        RoutingDataSource routing = new RoutingDataSource();
        Map<Object, Object> targets = new HashMap<>();
        targets.put("master", master);
        targets.put("replica", replica);

        routing.setTargetDataSources(targets);
        routing.setDefaultTargetDataSource(master);

        return routing;
    }

    @Primary
    @Bean
    public DataSource dataSource(DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }
}
