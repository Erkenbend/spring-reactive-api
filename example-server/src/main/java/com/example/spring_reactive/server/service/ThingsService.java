package com.example.spring_reactive.server.service;

import com.example.spring_reactive.api.spring_server.model.Thing;
import com.example.spring_reactive.server.factory.ThingFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ThingsService {
    private static final Logger log = LogManager.getLogger(ThingsService.class);

    public Flux<Thing> getThings(Integer nbThings) {
        //return this.getThingsFromExistingStream(nbThings);
        return this.getThingsFromLiveEvents(nbThings);
    }

    public Flux<Thing> getThingsFromLiveEvents(Integer nbThings) {
        log.info("Begin processing request for {} things, using live events", nbThings);
        return Flux.create(emitter -> {
            this.getRawThings(nbThings)
                    .forEach(rawThing -> emitter.next(ThingFactory.fromContent(rawThing)));
            emitter.complete();
        }, FluxSink.OverflowStrategy.BUFFER);
    }

    public Flux<Thing> getThingsFromExistingStream(Integer nbThings) {
        log.info("Begin processing request for {} things, using existing stream", nbThings);
        return Flux.fromStream(this.getRawThings(nbThings))
                .log()
                .map(ThingFactory::fromContent);
    }

    private Stream<String> getRawThings(Integer nbThings) {
        return IntStream.range(0, nbThings)
                .mapToObj(i -> String.format("thing #%s", i));
    }
}
