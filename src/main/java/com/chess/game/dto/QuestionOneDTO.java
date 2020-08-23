package com.chess.game.dto;

import com.chess.game.model.Coordinate;

/**
 * @author Burak Naroglu
 */

public class QuestionOneDTO {

    private Integer n;

    private Coordinate coordinate;

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
