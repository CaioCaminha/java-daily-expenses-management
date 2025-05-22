package com.caiocaminha.javadailyexpenses.core.gateway.r2dbc.config;


import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class R2DBCConfiguration {

    R2DBCProperties properties;

    public R2DBCConfiguration() {

    }



    //TODO -> Investigate if this is the correct way of creating ConnectionFactory Bean
    //TODO -> Try Using ConnectionFactories.get(...)
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration
                        .builder()
                        .username(properties.user)
                        .password(properties.password)
                        .database(properties.name)
                        .host(properties.server.host)
                        .port(properties.server.port)
                        .build()
        );
    }


}
