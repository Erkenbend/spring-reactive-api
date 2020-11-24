# openapi-java-client

Example reactive API
- API version: 1.0.0
  - Build date: 2020-11-24T22:00:35.993300300+01:00[Europe/Berlin]

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.example.spring_reactive.api.spring_server.handler.ApiClient;
import com.example.spring_reactive.api.spring_server.handler.ApiException;
import com.example.spring_reactive.api.spring_server.handler.Configuration;
import com.example.spring_reactive.api.spring_server.handler.models.*;
import com.example.spring_reactive.api.spring_server.handler.ThingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ThingsApi apiInstance = new ThingsApi(defaultClient);
    Integer nbThings = 56; // Integer | How many things to return
    try {
      List<Thing> result = apiInstance.listThings(nbThings);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThingsApi#listThings");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ThingsApi* | [**listThings**](docs/ThingsApi.md#listThings) | **GET** /things | List things


## Documentation for Models

 - [Error](docs/Error.md)
 - [Thing](docs/Thing.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


