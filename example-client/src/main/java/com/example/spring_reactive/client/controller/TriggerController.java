package com.example.spring_reactive.client.controller;

import com.example.spring_reactive.api.java_client.handler.ThingsApi;
import com.example.spring_reactive.api.java_client.model.Thing;
import com.example.spring_reactive.client.converter.ThingConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TriggerController {

    private static final Logger log = LogManager.getLogger(TriggerController.class);

    private static final Integer NB_THINGS_TO_REQUEST = 5;

    private final ThingsApi thingsApi;

    public TriggerController(ThingsApi thingsApi) {
        this.thingsApi = thingsApi;
    }

    @GetMapping("/trigger/naive")
    public ResponseEntity<List<String>> getThingsFromServer() {
        log.info("Begin of Controller, requesting {} things", NB_THINGS_TO_REQUEST);
        Flux<Thing> things = thingsApi.listThings(5);
        log.info("Received things from Server, beginning extraction process");
        return new ResponseEntity<>(
                things.map(ThingConverter::extractContent)
                        .collect(Collectors.toList())
                        .block(),
                HttpStatus.OK
        );
    }
}
