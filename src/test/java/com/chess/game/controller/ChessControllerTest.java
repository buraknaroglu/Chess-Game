package com.chess.game.controller;

import com.chess.game.data.TestData;
import com.chess.game.dto.QuestionOneDTO;
import com.chess.game.dto.QuestionTwoDTO;
import com.chess.game.model.Coordinate;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Burak Naroglu
 */

@RunWith(SpringRunner.class)
public class ChessControllerTest {

    @Spy
    @InjectMocks
    private ChessController chessController;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validationSuccess() {
        boolean response = chessController.validation(TestData.createCoordinate(), 8);
        Assert.assertTrue(response);
    }

    @Test
    public void validationXCheck() {
        Coordinate coordinate = TestData.createCoordinate();
        coordinate.setX(10);
        boolean response = chessController.validation(coordinate, 8);
        Assert.assertFalse(response);
    }

    @Test
    public void validationYCheck() {
        Coordinate coordinate = TestData.createCoordinate();
        coordinate.setY(10);
        boolean response = chessController.validation(coordinate, 8);
        Assert.assertFalse(response);
    }

    @Test
    public void checkObstacleReturnFalse() {
        boolean response = chessController.checkObstacle(3, 5, TestData.createKCoordinates());
        Assert.assertFalse(response);
    }

    @Test
    public void checkObstacleReturnTrue() {
        boolean response = chessController.checkObstacle(1, 5, TestData.createKCoordinates());
        Assert.assertTrue(response);
    }

    @Test
    public void checkObstacleKCoordinateNull() {
        boolean response = chessController.checkObstacle(1, 5, null);
        Assert.assertTrue(response);
    }


    @Test
    public void xAndYIncreaseCalculate() {
        Integer response = chessController.xAndYIncreaseCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("4", response.toString());
    }

    @Test
    public void xAndYIncreaseCalculateEqualsN() {
        Integer response = chessController.xAndYIncreaseCalculate(8, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xAndYIncreaseCalculateExistKCoordinate() {
        List<Coordinate> kCoordinates = TestData.createKCoordinates();
        kCoordinates.add(TestData.createKCoordinate());
        Integer response = chessController.xAndYIncreaseCalculate(8, 4, 8, kCoordinates);
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xAndYDecreaseCalculate() {
        Integer response = chessController.xAndYDecreaseCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("3", response.toString());
    }

    @Test
    public void xAndYDecreaseCalculateXEqualsOne() {
        Integer response = chessController.xAndYDecreaseCalculate(1, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xDecreaseAndYIncreaseCalculate() {
        Integer response = chessController.xDecreaseAndYIncreaseCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xDecreaseAndYIncreaseCalculateXEqualsOne() {
        Integer response = chessController.xDecreaseAndYIncreaseCalculate(1, 8, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xIncreaseAndYDecreaseCalculate() {
        Integer response = chessController.xIncreaseAndYDecreaseCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("3", response.toString());
    }

    @Test
    public void xIncreaseAndYDecreaseCalculateEqualsN() {
        Integer response = chessController.xIncreaseAndYDecreaseCalculate(8, 8, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xIncreaseAndYFixedCalculate() {
        Integer response = chessController.xIncreaseAndYFixedCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("4", response.toString());
    }

    @Test
    public void xIncreaseAndYFixedCalculateEqualsN() {
        Integer response = chessController.xIncreaseAndYFixedCalculate(8, 8, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void xDecreaseAndYFixedCalculate() {
        Integer response = chessController.xDecreaseAndYFixedCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("3", response.toString());
    }

    @Test
    public void xDecreaseAndYFixedCalculateXEqualsOne() {
        Integer response = chessController.xDecreaseAndYFixedCalculate(1, 8, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void yIncreaseAndXFixedCalculate() {
        Integer response = chessController.yIncreaseAndXFixedCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void yIncreaseAndXFixedCalculateYEqualsN() {
        Integer response = chessController.yIncreaseAndXFixedCalculate(1, 8, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void yDecreaseAndXFixedCalculate() {
        Integer response = chessController.yDecreaseAndXFixedCalculate(4, 4, 8, TestData.createKCoordinates());
        Assert.assertEquals("3", response.toString());
    }

    @Test
    public void yDecreaseAndXFixedCalculateYEqualsOne() {
        Integer response = chessController.yDecreaseAndXFixedCalculate(1, 1, 8, TestData.createKCoordinates());
        Assert.assertEquals("0", response.toString());
    }

    @Test
    public void calculateAccessiblePoint() {
        ResponseEntity response = chessController.calculateAccessiblePoint(TestData.createCoordinate(), 8, TestData.createKCoordinates());
        Assert.assertEquals("20", response.getBody().toString());
    }

    @Test
    public void question2() {
        ResponseEntity response = chessController.question2(TestData.createQuestioneTwoDTO());
        Assert.assertEquals("20", response.getBody().toString());
    }

    @Test
    public void question1() {
        ResponseEntity response = chessController.question1(TestData.createQuestioneOneDTO());
        Assert.assertEquals("27", response.getBody().toString());
    }

    @Test
    public void question2Error() {
        QuestionTwoDTO questioneTwoDTO = TestData.createQuestioneTwoDTO();
        questioneTwoDTO.getCoordinate().setX(10);
        ResponseEntity response = chessController.question2(questioneTwoDTO);
        Assert.assertEquals(500, response.getStatusCode().value());
    }

    @Test
    public void question1Error() {
        QuestionOneDTO questioneOneDTO = TestData.createQuestioneOneDTO();
        questioneOneDTO.getCoordinate().setX(10);
        ResponseEntity response = chessController.question1(questioneOneDTO);
        Assert.assertEquals(500, response.getStatusCode().value());
    }

}
