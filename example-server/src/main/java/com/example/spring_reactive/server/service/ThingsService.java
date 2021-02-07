package com.example.spring_reactive.server.service;

import com.example.spring_reactive.api.spring_server.model.Thing;
import com.example.spring_reactive.server.db.repository.ThingsRepository;
import com.example.spring_reactive.server.factory.ThingFactory;
import com.example.spring_reactive.server.mapping.ThingMapper;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ThingsService {
    private static final Logger log = LogManager.getLogger(ThingsService.class);

    private static final Integer UPPERCASE_CONVERSION_DELAY_MILLIS = 1000;

    private final ThingsRepository thingsRepository;

    public ThingsService(ThingsRepository thingsRepository) {
        this.thingsRepository = thingsRepository;
    }

    public Flux<Thing> getThings(Integer nbThings) {
        //return this.getThingsFromExistingStream(nbThings);
        //return this.getThingsFromLiveEvents(nbThings);
        //return this.getThingsFromComplexPipeline(nbThings);
        //return this.getThingsFromPushingChain(nbThings);
        return this.getThingsFromWithScheduler(nbThings);
    }

    private Flux<Thing> getThingsFromWithScheduler(Integer nbThings) {
        return Flux.fromStream(this.getRawThings(nbThings))
                .publishOn(Schedulers.newParallel("Upper"))
                .map(this::toUpperSlow)
                .publishOn(Schedulers.newParallel("Factory"))
                .map(ThingFactory::fromContent);
    }

    private Stream<String> getRawThings(Integer nbThings) {
        // TODO: get from DB
        return IntStream.range(0, nbThings)
                .mapToObj(i -> String.format("thing #%s", i));
    }

    @SneakyThrows(InterruptedException.class)
    private String toUpperSlow(String input) {
        log.info("Converting input \"{}\" to uppercase, waiting {}ms", input, UPPERCASE_CONVERSION_DELAY_MILLIS);
        Thread.sleep(UPPERCASE_CONVERSION_DELAY_MILLIS);
        log.info("Converting input to uppercase \"{}\" now", input);
        return input.toUpperCase();
    }

    public Mono<Boolean> saveThings(Flux<Thing> things) {
        log.info("Begin converting and saving things from flux");
        return thingsRepository
                .saveAll(things.map(ThingMapper.INSTANCE::thingApiToDb).log())
                .log()
                .map(t -> true)
                .reduce((a, b) -> a && b);
    }
}
