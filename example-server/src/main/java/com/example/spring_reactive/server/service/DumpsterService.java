package com.example.spring_reactive.server.service;

import com.example.spring_reactive.api.spring_server.model.Thing;
import com.example.spring_reactive.server.factory.ThingFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Sinks;

/**
 * Old tries from ThingsService that are broken or not used anymore
 */
public class DumpsterService {
    /*
    private Flux<Thing> getThingsFromPushingChain(Integer nbThings) {
        Sinks.Many<String> rawThingsSink = Sinks.many().unicast().onBackpressureBuffer();
        Sinks.Many<String> upperRawThingsSink = Sinks.many().unicast().onBackpressureBuffer();
        Sinks.Many<Thing> thingsSink = Sinks.many().unicast().onBackpressureBuffer();

        upperRawThingsSink.asFlux().subscribe(upperRawThing ->
                thingsSink.emitNext(ThingFactory.fromContent(upperRawThing), Sinks.EmitFailureHandler.FAIL_FAST));
        rawThingsSink.asFlux().subscribe(rawThing ->
                upperRawThingsSink.emitNext(this.toUpperSlow(rawThing), Sinks.EmitFailureHandler.FAIL_FAST));
        this.getRawThings(nbThings).forEach(rawThing ->
                rawThingsSink.emitNext(rawThing, Sinks.EmitFailureHandler.FAIL_FAST));

        rawThingsSink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
        upperRawThingsSink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
        thingsSink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);

        return thingsSink.asFlux();
    }

    private Flux<Thing> getThingsFromComplexPipeline(Integer nbThings) {
        Sinks.Many<String> upperRawThingsSink = Sinks.many().unicast().onBackpressureBuffer();
        Sinks.Many<String> rawThingsSink = Sinks.many().unicast().onBackpressureBuffer();
        Sinks.Many<Thing> thingsSink = Sinks.many().unicast().onBackpressureBuffer();
        Flux<String> rawThingsFlux = this.pushRawThings(nbThings, rawThingsSink);
        Flux<String> upperRawThingsFlux = this.upperRawThings(rawThingsFlux, upperRawThingsSink);
        return this.convertRawThings(upperRawThingsFlux, thingsSink);
    }

    private Flux<Thing> convertRawThings(Flux<String> rawThingsFlux, Sinks.Many<Thing> thingsSink) {
        rawThingsFlux.subscribe(rawThing -> thingsSink.emitNext(ThingFactory.fromContent(rawThing), Sinks.EmitFailureHandler.FAIL_FAST));
        thingsSink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
        return thingsSink.asFlux();
    }

    private Flux<String> upperRawThings(Flux<String> rawThingsFlux, Sinks.Many<String> upperRawThingsSink) {
        rawThingsFlux.subscribe(rawThing -> upperRawThingsSink.emitNext(this.toUpperSlow(rawThing), Sinks.EmitFailureHandler.FAIL_FAST));
        upperRawThingsSink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
        return upperRawThingsSink.asFlux();
    }

    private Flux<String> pushRawThings(Integer nbThings, Sinks.Many<String> rawThingsSink) {
        this.getRawThings(nbThings).forEach(rawThing -> rawThingsSink.emitNext(rawThing, Sinks.EmitFailureHandler.FAIL_FAST));
        rawThingsSink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
        return rawThingsSink.asFlux();
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
    */
}
