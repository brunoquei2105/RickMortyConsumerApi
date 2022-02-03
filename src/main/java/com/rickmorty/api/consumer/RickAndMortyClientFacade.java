package com.rickmorty.api.consumer;

import com.rickmorty.api.WebfluxRickMortyApiApplication;
import com.rickmorty.api.model.CharacterModelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClientFacade {

    @Autowired
    private WebClient webClient;

    public CharacterModelResponse getAllCharacter(){
        return webClient
                .get()
                .uri("/character")
                .retrieve()
                .bodyToFlux(CharacterModelResponse.class)
                .blockLast();
    }

    public Mono<CharacterModelResponse> getCharacterById(String id){
        return webClient
                .get()
                .uri("/character/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, erro -> Mono.error(new RuntimeException("Resource not Found: "+ id)))
                .bodyToMono(CharacterModelResponse.class);
    }
}
