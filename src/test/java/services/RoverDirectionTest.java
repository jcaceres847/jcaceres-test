package services;

import org.junit.Before;
import org.junit.Test;
import data.Point;
import data.Position;
import data.Rover;
import enums.Direction;

import java.util.List;

import static enums.Direction.EAST;
import static enums.Direction.NORTH;
import static enums.Direction.SOUTH;
import static enums.Direction.WEST;
import static enums.Status.OK;
import static org.junit.Assert.assertEquals;


public class RoverDirectionTest {
    public static final int DIRECTION_STEP_LEFT = -1;
    public static final int DIRECTION_STEP_RIGHT = 1;

    private RoverDirection roverDirection;
    private Position roverPosition;
    private final Direction direction = NORTH;
    private Point x;
    private Point y;
    @Before
    public void before() {
        roverDirection = new RoverDirectionImpl();
        x = new Point(0, 10);
        y = new Point(0, 10);
        roverPosition = new Position(x, y, direction);
    }

    @Test
    public void givenDirectionNorth_whenChangeDirectionLeft_ThenNewPositionIsWest() {
        Rover result = roverDirection.change(roverPosition, DIRECTION_STEP_LEFT);

        assertDirection(WEST, result);
    }

    @Test
    public void givenDirectionNorth_whenChangeDirectionRight_ThenNewPositionIsEast() {
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_RIGHT);

        assertDirection(EAST, result);
    }

    @Test
    public void givenDirectionWest_whenChangeDirectionLeft_ThenNewPositionIsSouth() {
        roverPosition = new Position(x, y, WEST);
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_LEFT);

        assertDirection(SOUTH, result);
    }

    @Test
    public void givenDirectionWest_whenChangeDirectionRight_ThenNewPositionIsNorth() {
        roverPosition = new Position(x, y, WEST);
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_RIGHT);

        assertDirection(NORTH, result);
    }

    @Test
    public void givenDirectionSouth_whenChangeDirectionLeft_ThenNewPositionIsEast() {
        roverPosition = new Position(x, y, SOUTH);
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_LEFT);

        assertDirection(EAST, result);
    }

    @Test
    public void givenDirectionSouth_whenChangeDirectionRight_ThenNewPositionIsWest() {
        roverPosition = new Position(x, y, SOUTH);
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_RIGHT);

        assertDirection(WEST, result);
    }


    @Test
    public void givenDirectionEast_whenChangeDirectionRight_ThenNewPositionIsNorth() {
        roverPosition = new Position(x, y, EAST);
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_LEFT);

        assertDirection(NORTH, result);
    }

    @Test
    public void givenDirectionEast_whenChangeDirectionLeft_ThenNewPositionIsNorth() {
        roverPosition = new Position(x, y, EAST);
        Rover result = roverDirection.change(roverPosition,DIRECTION_STEP_RIGHT);

        assertDirection(SOUTH, result);
    }

    private void assertDirection(Direction expected, Rover result) {
        assertEquals("The direction must matched",expected,result.getPosition().getDirection());
        assertEquals("the status must be OK", OK.name(),result.getStatus());
    }
}
