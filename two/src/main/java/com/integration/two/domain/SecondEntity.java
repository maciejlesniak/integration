package com.integration.two.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Maciej Lesniak
 */
@Entity
public class SecondEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long firstId;
    private Integer score;

    protected SecondEntity() {
        // protected hibernate constructor
    }

    public SecondEntity(Integer score, Long firstId) {
        this.score = score;
        this.firstId = firstId;
    }

    public Long getId() {
        return id;
    }

    public Long getFirstId() {
        return firstId;
    }

    public Integer getScore() {
        return score;
    }
}
