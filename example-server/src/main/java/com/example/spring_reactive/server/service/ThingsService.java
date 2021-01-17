package com.example.spring_reactive.server.service;

import com.example.spring_reactive.api.spring_server.model.Thing;
import com.example.spring_reactive.server.factory.ThingFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ThingsService {
    private static final Logger log = LogManager.getLogger(ThingsService.class);

    public Flux<Thing> getThings(Integer nbThings) {
        log.info("Begin processing request for {} things", nbThings);
        return Flux.fromStream(this.getRawThings(nbThings))
                .log()
                .map(ThingFactory::fromContent);
    }

    private Stream<String> getRawThings(Integer nbThings) {
        return IntStream.range(0, nbThings)
                .mapToObj(i -> String.format("thing #%s", i));
    }
}
