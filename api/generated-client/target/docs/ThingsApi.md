# ThingsApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listThings**](ThingsApi.md#listThings) | **GET** /things | List things


<a name="listThings"></a>
# **listThings**
> List&lt;Thing&gt; listThings(nbThings)

List things

This takes some time

### Example
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **nbThings** | **Integer**| How many things to return |

### Return type

[**List&lt;Thing&gt;**](Thing.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A list of things |  -  |
**0** | Unexpected error |  -  |

