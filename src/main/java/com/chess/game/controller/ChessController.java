package com.chess.game.controller;

import com.chess.game.constants.GlobalConstants;
import com.chess.game.dto.QuestionOneDTO;
import com.chess.game.dto.QuestionTwoDTO;
import com.chess.game.model.Coordinate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Burak Naroglu
 */

@RestController
@RequestMapping("chess")
public class ChessController {

    @PostMapping("question-1")
    public ResponseEntity question1(@RequestBody QuestionOneDTO questionOneDTO) {
        if (validation(questionOneDTO.getCoordinate(), questionOneDTO.getN())) {
            return calculateAccessiblePoint(questionOneDTO.getCoordinate(), questionOneDTO.getN(), null);
        }
        return new ResponseEntity(GlobalConstants.ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("question-2")
    public ResponseEntity question2(@RequestBody QuestionTwoDTO questionTwoDTO) {
        if (validation(questionTwoDTO.getCoordinate(), questionTwoDTO.getN())) {
            return calculateAccessiblePoint(questionTwoDTO.getCoordinate(), questionTwoDTO.getN(), questionTwoDTO.getkCoordinates());
        }
        return new ResponseEntity(GlobalConstants.ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity calculateAccessiblePoint(Coordinate coordinate, Integer n, List<Coordinate> kCoordinates) {

        Integer xCoordinateCalculate = xIncreaseAndYFixedCalculate(
            coordinate.getX(), coordinate.getY(), n, kCoordinates) + xDecreaseAndYFixedCalculate(coordinate.getX(), coordinate.getY(), n,
            kCoordinates);

        Integer yCoordinateCalculate =
            yIncreaseAndXFixedCalculate(coordinate.getX(), coordinate.getY(), n, kCoordinates) + yDecreaseAndXFixedCalculate(coordinate.getX(),
                coordinate.getY(), n, kCoordinates);

        Integer crossCoordinateCalculate = xAndYIncreaseCalculate(coordinate.getX(), coordinate.getY(), n, kCoordinates) + xAndYDecreaseCalculate(
            coordinate.getX(), coordinate.getY(), n, kCoordinates) + xDecreaseAndYIncreaseCalculate(coordinate.getX(), coordinate.getY(), n,
            kCoordinates)
            + xIncreaseAndYDecreaseCalculate(coordinate.getX(), coordinate.getY(), n, kCoordinates);

        return new ResponseEntity(xCoordinateCalculate + yCoordinateCalculate + crossCoordinateCalculate, HttpStatus.OK);
    }

    public Integer yDecreaseAndXFixedCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (y.equals(1)) {
            return 0;
        }

        Integer count = 0;

        for (int i = 0; i < n; i++) {
            --y;

            if (y.equals(1)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer yIncreaseAndXFixedCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (y.equals(n)) {
            return 0;
        }

        Integer count = 0;

        for (int i = 0; i < n; i++) {
            ++y;

            if (y.equals(n)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer xDecreaseAndYFixedCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (x.equals(1)) {
            return 0;
        }

        Integer count = 0;

        for (int i = 0; i < n; i++) {
            --x;

            if (x.equals(1)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer xIncreaseAndYFixedCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (x.equals(n)) {
            return 0;
        }

        Integer count = 0;

        for (int i = 0; i < n; i++) {
            ++x;

            if (x.equals(n)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer xIncreaseAndYDecreaseCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (x.equals(n)) {
            return 0;
        }

        Integer count = 0;

        for (int i = 0; i < n; i++) {

            ++x;
            --y;

            if (y.equals(1)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer xDecreaseAndYIncreaseCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (y.equals(n)) {
            return 0;
        }

        Integer count = 0;

        for (int i = 0; i < n; i++) {

            if (!y.equals(n)) {
            }

            ++y;
            --x;

            if (x.equals(1)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer xAndYDecreaseCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (x.equals(1) || y.equals(1)) {
            return 0;
        }

        Integer count = 0;

        for (int i = n; i > 0; i--) {
            --x;
            --y;

            if (x.equals(1) || y.equals(1)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public Integer xAndYIncreaseCalculate(Integer x, Integer y, Integer n, List<Coordinate> kCoordinates) {

        if (x.equals(n) || y.equals(n)) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            ++x;
            ++y;

            if (x.equals(n) || y.equals(n)) {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                }
                break;
            } else {
                if (checkObstacle(x, y, kCoordinates)) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public boolean checkObstacle(Integer x, Integer y, List<Coordinate> kCoordinates) {
        return CollectionUtils.isEmpty(kCoordinates) ? Boolean.TRUE
            : kCoordinates.stream().noneMatch(coordinate -> coordinate.getX().equals(x) && coordinate.getY().equals(y));
    }

    public boolean validation(Coordinate coordinate, Integer n) {
        return (coordinate.getX() > n || coordinate.getY() > n) ? Boolean.FALSE : Boolean.TRUE;
    }

}

