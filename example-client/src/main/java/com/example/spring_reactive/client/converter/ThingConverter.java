package com.example.spring_reactive.client.converter;

import com.example.spring_reactive.api.java_client.model.Thing;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThingConverter {

    private static final Integer THING_EXTRACT_DELAY_MILLIS = 1500;

    private static final Logger log = LogManager.getLogger(ThingConverter.class);

    @SneakyThrows(InterruptedException.class)
    public static String extractContent(Thing thing) {
        log.info("Received request to extract content from Thing with ID {}, waiting {}ms", thing.getId(), THING_EXTRACT_DELAY_MILLIS);
        Thread.sleep(THING_EXTRACT_DELAY_MILLIS);
        log.info("Extracting content now");
        return thing.getContent();
    }
}
