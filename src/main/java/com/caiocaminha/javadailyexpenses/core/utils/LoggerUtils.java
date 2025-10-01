package com.caiocaminha.javadailyexpenses.core.utils;

import com.google.common.base.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class LoggerUtils {

    private final static Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    public static <T extends Class> void logInfo(
            String message
    ) {
        logger.info(message);
    }

    public static <T> void log(
            Class<T> clazz,
            Consumer<Logger> consumer
    ) {
        Logger logger = LoggerFactory.getLogger(clazz);
        consumer.accept(logger);
    }

}
