package com.rickmorty.api.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharacterModelResponse implements Serializable{


    private String id;
    private String name;
    private String status;
    private String species;
    private String image;
    private List<String> episode;
}
