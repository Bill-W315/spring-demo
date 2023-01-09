package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Person {
    private UUID id;
    //@NotBlank
    private String name;

    public Person(){}

    public Person(@JsonProperty UUID id, @JsonProperty String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
