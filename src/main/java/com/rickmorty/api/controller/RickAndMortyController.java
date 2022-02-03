package com.rickmorty.api.controller;

import com.rickmorty.api.consumer.RickAndMortyClientFacade;
import com.rickmorty.api.model.CharacterModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/webclient")
public class RickAndMortyController {

    @Autowired
    private RickAndMortyClientFacade rickAndMortyClientFacade;

    @GetMapping(path = "/character/{id}")
    public Mono<CharacterModelResponse> getCharacterById(@PathVariable String id){

        return rickAndMortyClientFacade.getCharacterById(id);

    }
}
