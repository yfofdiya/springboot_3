package com.example.client.config;

import com.example.client.service.StudentClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient studentServiceWebClient() {
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Bean
    public StudentClientService service() {
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory
                        .builder(WebClientAdapter.forClient(studentServiceWebClient()))
                        .build();
        return proxyFactory.createClient(StudentClientService.class);
    }
}
