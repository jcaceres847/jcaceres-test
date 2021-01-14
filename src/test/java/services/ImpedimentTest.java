package services;

import data.Obstacle;
import data.Point;
import data.Position;
import data.Rover;
import enums.Direction;
import enums.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
;
import static enums.Status.NOK;
import static enums.Status.OK;
import static org.junit.Assert.assertEquals;
import static enums.Direction.NORTH;

public class ImpedimentTest {
    private Impediment impediment;
    private List obstacles;
    private final Direction direction = NORTH;

    @Before
    public void before() {
        impediment = new ImpedimentImpl();
        obstacles = new ArrayList<>();
    }

    @Test
    public void givenFuturePositionX0Y1AndObstaclesEmpty_whenCheck_ThenStatusOKIsReturned() {
        Status result = impediment.check(0,1,obstacles);

        assertEquals("the status should match",OK,result);
    }

    @Test
    public void givenFuturePositionX0Y1AndObstaclesX0Y1_whenCheck_ThenStatusNOKIsReturn() {
        Status result = impediment.check(0,1,Arrays.asList(new Obstacle(0,1)));

        assertEquals("the status should match",NOK,result);
    }

    @Test
    public void givenFuturePositionX0Y1AndObstaclesX2Y3X0Y1_whenCheck_ThenStatusNOKIsReturn() {
        Status result = impediment.check(0,1,Arrays.asList(new Obstacle(2,3),new Obstacle(0,1)));

        assertEquals("the status should match",NOK,result);
    }
}
