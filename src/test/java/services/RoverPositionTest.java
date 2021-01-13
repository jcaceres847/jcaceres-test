package services;

import org.junit.Before;
import org.junit.Test;
import data.Point;
import data.Position;
import enums.Direction;

import static org.junit.Assert.assertEquals;


import static enums.Direction.EAST;
import static enums.Direction.NORTH;
import static enums.Direction.SOUTH;
import static enums.Direction.WEST;


public class RoverPositionTest {
    public static final String COORDINATE_POINTS_Y_SHOULD_MATCHED = "The coordinate y point should matched";
    public static final String COORDINATES_POINTS_X_SHOULD_MATCHED = "The coordinate x point should matched";
    private RoverPositionImpl roverPosition;
    private Position position;
    private final Direction direction = NORTH;
    private Point x;
    private Point y;

    @Before
    public void before() {
        roverPosition = new RoverPositionImpl();
        x = new Point(0, 10);
        y = new Point(0, 10);
        position = new Position(x, y, direction);
    }


    @Test
    public void givenOrderForwardAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn() {
        int expected = y.getLocation() + 1;

        Position result = roverPosition.move(position, position.getDirection());

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getY().getLocation());
    }


    @Test
    public void givenOrderForwardAndPointX0Y10DirectionNorth_whenSendOrder_ThenNewPositionIsReturn() {
        position.setY(new Point(10, 10));
        int expected = 0;

        Position result = roverPosition.move(position, position.getDirection());

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getY().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn() {
        position = new Position(x, y, EAST);
        int expected = x.getLocation() + 1;

        Position result = roverPosition.move(position, position.getDirection());

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getX().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX10Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        x = new Point(10, 10);
        position = new Position(x, y, EAST);
        int expected = 0;

        Position result = roverPosition.move(position, position.getDirection());

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getX().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn()  {
        position = new Position(x, y, WEST);
        int expected = x.getMaxLocation();

        Position result = roverPosition.move(position, position.getDirection());

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getX().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn()  {
        position = new Position(x, y, SOUTH);
        int expected = y.getMaxLocation();

        Position result = roverPosition.move(position, position.getDirection());

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getY().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn()  {
        int expected = y.getMaxLocation();

        Position result = roverPosition.move(position, position.getDirection().getBackwardDirection());

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getY().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        position = new Position(x, y, EAST);
        int expected = x.getMaxLocation();

        Position result = roverPosition.move(position, position.getDirection().getBackwardDirection());

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getX().getLocation());
    }


    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn()  {
        position = new Position(x, y, WEST);
        int expected = x.getLocation() + 1;

        Position result = roverPosition.move(position, position.getDirection().getBackwardDirection());

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getX().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn()  {
        position = new Position(x, y,SOUTH);
        int expected = y.getLocation() + 1;

        Position result = roverPosition.move(position, position.getDirection().getBackwardDirection());

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getY().getLocation());
   }
}