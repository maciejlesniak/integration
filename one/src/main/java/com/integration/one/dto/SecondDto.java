package com.integration.one.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maciej Lesniak
 */
public class SecondDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("score")
    private Integer score;

    public SecondDto(@JsonProperty("id") Long id,
                     @JsonProperty("score") Integer score) {
        this.id = id;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }
}
