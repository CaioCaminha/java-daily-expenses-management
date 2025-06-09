package com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "db")
public class R2DBCProperties {

    String name, user, password, url;
    Server server;

    @Data
    public static class Server {
        String host;
        Integer port;
    }

}
