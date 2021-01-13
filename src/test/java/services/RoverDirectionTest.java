package services;

import data.Point;
import data.Position;
import enums.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static enums.Direction.EAST;
import static enums.Direction.NORTH;
import static enums.Direction.SOUTH;
import static enums.Direction.WEST;


public class RoverDirectionTest {
    public static final int DIRECTION_STEP_LEFT = -1;
    public static final int DIRECTION_STEP_RIGHT = 1;
    public static final String THE_DIRECTION_MUST_MATCHED = "The direction must matched";

    private RoverDirectionImpl roverDirection;
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
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_LEFT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,WEST,result.getDirection());
    }

    @Test
    public void givenDirectionNorth_whenChangeDirectionRight_ThenNewPositionIsEast() {
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_RIGHT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,EAST,result.getDirection());
    }

    @Test
    public void givenDirectionWest_whenChangeDirectionLeft_ThenNewPositionIsSouth() {
        roverPosition = new Position(x, y, WEST);
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_LEFT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,SOUTH,result.getDirection());
    }

    @Test
    public void givenDirectionWest_whenChangeDirectionRight_ThenNewPositionIsNorth() {
        roverPosition = new Position(x, y, WEST);
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_RIGHT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,NORTH,result.getDirection());
    }

    @Test
    public void givenDirectionSouth_whenChangeDirectionLeft_ThenNewPositionIsEast() {
        roverPosition = new Position(x, y, SOUTH);
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_LEFT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,EAST,result.getDirection());
    }

    @Test
    public void givenDirectionSouth_whenChangeDirectionRight_ThenNewPositionIsWest() {
        roverPosition = new Position(x, y, SOUTH);
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_RIGHT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,WEST,result.getDirection());
    }


    @Test
    public void givenDirectionEast_whenChangeDirectionRight_ThenNewPositionIsNorth() {
        roverPosition = new Position(x, y, EAST);
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_LEFT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,NORTH,result.getDirection());
    }

    @Test
    public void givenDirectionEast_whenChangeDirectionLeft_ThenNewPositionIsNorth() {
        roverPosition = new Position(x, y, EAST);
        Position result = roverDirection.change(roverPosition, DIRECTION_STEP_RIGHT);

        assertEquals(THE_DIRECTION_MUST_MATCHED,SOUTH,result.getDirection());
    }
}
