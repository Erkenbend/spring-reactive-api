# spring-reactive-api

TODO: good readme

## Build

`mvn clean install` in root dir

## Run

`mvn spring-boot:run`
- in `example-server` starts server on port 8081
- in `example-client` starts client on port 8082

## Use

Server endpoint: `GET http://localhost:8081/things?nbThings=5`

Client endpoint to trigger call to server: `GET http://localhost:8082/trigger`
