package com.chess.game.data;

import com.chess.game.dto.QuestionOneDTO;
import com.chess.game.dto.QuestionTwoDTO;
import com.chess.game.model.Coordinate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Burak Naroglu
 */

public class TestData {

    public static Coordinate createCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(4);
        coordinate.setY(4);
        return coordinate;
    }

    public static Coordinate createKCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(5);
        coordinate.setY(5);
        return coordinate;
    }

    public static QuestionOneDTO createQuestioneOneDTO() {
        QuestionOneDTO questionOneDTO = new QuestionOneDTO();
        questionOneDTO.setCoordinate(createCoordinate());
        questionOneDTO.setN(8);
        return questionOneDTO;
    }

    public static QuestionTwoDTO createQuestioneTwoDTO() {
        QuestionTwoDTO questionTwoDTO = new QuestionTwoDTO();
        questionTwoDTO.setCoordinate(createCoordinate());
        questionTwoDTO.setN(8);
        questionTwoDTO.setkCoordinates(createKCoordinates());
        return questionTwoDTO;
    }

    public static List<Coordinate> createKCoordinates() {
        Coordinate coordinateOne = new Coordinate();
        coordinateOne.setX(3);
        coordinateOne.setY(5);

        Coordinate coordinateTwo = new Coordinate();
        coordinateTwo.setX(4);
        coordinateTwo.setY(5);

        List<Coordinate> kCoordinate = new ArrayList<>();
        kCoordinate.add(coordinateOne);
        kCoordinate.add(coordinateTwo);

        return kCoordinate;
    }

}

