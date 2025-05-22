package com.caiocaminha.javadailyexpenses.core.gateway.r2dbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "db.config")
public class R2DBCProperties {

    String name, user, password, url;
    Server server;


    public static class Server {
        String host;
        Integer port;
    }

}
