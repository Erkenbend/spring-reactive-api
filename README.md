# spring-reactive-api

TODO: improve readme

## Build

`mvn clean install` in root dir

## Run

`mvn spring-boot:run`
- in `example-server` starts server on port 8081
- in `example-client` starts client on port 8082

## Use

Server endpoint: `GET http://localhost:8081/things?nbThings=5`

Client endpoint to trigger call to server: `GET http://localhost:8082/trigger`

## Flow

Simple chain:
- Trigger Client endpoint
- Client requests a number of `Thing`s
- Server processes request:
    - Raw data for the `Thing` is generated (eg String "thing #0")
    - String gets transformed to uppercase (eg "THING #0") --> takes 1s per object
    - `Thing` gets constructed from String (String becomes field content + id is generated) --> takes 1.5s per object
    - `Thing`s are returned to Client
- Client transforms received objects (extract content as String) --> takes 1.5s per object
- Client endpoint returns list of Strings

If all done synchronously, it would take `1*n + 1.5*n + 1.5*n = 4*n` seconds
to receive a response for `n` objects. But because of smart `Flux`
chaining it only takes about `1 + 1.5 + 1.5*n = 1.5*n + 2.5` seconds.
That's 10 seconds for 5 objects (compared to 20 for sync variant),
with the gap growing for larger requests.

# Contribute

## Next steps

- Add DB and reactive repository with R2DBC
- Add security
- ???
- Profit
