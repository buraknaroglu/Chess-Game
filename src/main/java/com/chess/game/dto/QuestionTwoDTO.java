package com.chess.game.dto;

import com.chess.game.model.Coordinate;
import java.util.List;

/**
 * @author Burak Naroglu
 */

public class QuestionTwoDTO {

    private Integer n;

    private Coordinate coordinate;

    private List<Coordinate> kCoordinates;

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

    public List<Coordinate> getkCoordinates() {
        return kCoordinates;
    }

    public void setkCoordinates(List<Coordinate> kCoordinates) {
        this.kCoordinates = kCoordinates;
    }
}
