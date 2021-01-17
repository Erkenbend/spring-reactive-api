package com.example.spring_reactive.server.controller;

import com.example.spring_reactive.api.spring_server.handler.ThingsApi;
import com.example.spring_reactive.api.spring_server.model.Thing;
import com.example.spring_reactive.server.service.ThingsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class ThingsController implements ThingsApi {

    private static final Logger log = LogManager.getLogger(ThingsController.class);

    private final ThingsService thingsService;

    public ThingsController(ThingsService thingsService) {
        this.thingsService = thingsService;
    }

    @Override
    public Mono<ResponseEntity<Flux<Thing>>> listThings(
            @NotNull @Valid @RequestParam(value = "nbThings") Integer nbThings,
            ServerWebExchange exchange
    ) {
        log.info("Begin of Controller, {} things requested", nbThings);
        Flux<Thing> things = thingsService.getThings(nbThings);
        log.info("Flux obtained from ThingsService");
        return Mono.just(new ResponseEntity<>(things, HttpStatus.OK));
    }
}
