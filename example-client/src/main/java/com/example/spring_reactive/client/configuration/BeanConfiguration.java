package com.example.spring_reactive.client.configuration;

import com.example.spring_reactive.api.java_client.handler.ApiClient;
import com.example.spring_reactive.api.java_client.handler.ThingsApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Value("${api.server.address}")
    private String serverAddress;

    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(serverAddress);
        return apiClient;
    }

    @Bean
    public ThingsApi thingsApi() {
        return new ThingsApi(apiClient());
    }
}
