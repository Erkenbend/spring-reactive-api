package com.example.spring_reactive.server.factory;

import com.example.spring_reactive.api.spring_server.model.Thing;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class ThingFactory {

    private static final Integer THING_BUILD_DELAY_MILLIS = 1500;

    private static final Logger log = LogManager.getLogger(ThingFactory.class);

    @SneakyThrows(InterruptedException.class)
    public static Thing fromContent(String content) {
        log.info("Received request to build Thing from content \"{}\", waiting {}ms", content, THING_BUILD_DELAY_MILLIS);
        Thread.sleep(THING_BUILD_DELAY_MILLIS);
        log.info("Building Thing from content \"{}\" now", content);
        return (new Thing()).id(UUID.randomUUID().getMostSignificantBits()).content(content);
    }
}
