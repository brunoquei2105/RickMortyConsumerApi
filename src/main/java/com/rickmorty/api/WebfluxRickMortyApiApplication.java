package com.rickmorty.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import javax.print.attribute.standard.Media;
import java.util.function.Consumer;

@SpringBootApplication
public class WebfluxRickMortyApiApplication {

    @Value("${uri.baseUrl}")
    private String baseUrl;

    public static Consumer<HttpHeaders> consumerHeader(HttpHeaders headers){
        return httpHeaders -> httpHeaders.addAll(headers);
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public static void main(String[] args) {

        SpringApplication.run(WebfluxRickMortyApiApplication.class, args);
    }

}
