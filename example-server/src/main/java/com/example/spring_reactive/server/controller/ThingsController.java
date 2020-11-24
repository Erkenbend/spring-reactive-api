package com.example.spring_reactive.server.controller;

import com.example.spring_reactive.api.spring_server.handler.ThingsApi;
import com.example.spring_reactive.api.spring_server.model.Thing;
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

    @Override
    public Mono<ResponseEntity<Flux<Thing>>> listThings(
            @NotNull @Valid @RequestParam(value = "nbThings") Integer nbThings,
            ServerWebExchange exchange
    ) {
        Thing thing = new Thing();
        thing.id(1L).content("test");
        return Mono.just(new ResponseEntity<>(Flux.just(thing), HttpStatus.OK));
    }
}
