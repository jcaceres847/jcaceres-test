package services;

import org.junit.Before;
import org.junit.Test;
import data.Obstacle;
import data.Point;
import data.Position;
import data.Rover;
import enums.Direction;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.Direction.EAST;
import static enums.Direction.NORTH;
import static enums.Direction.SOUTH;
import static enums.Direction.WEST;
import static enums.Status.NOK;
import static enums.Status.OK;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RoverPositionTest {
    private RoverPositionImpl roverPosition;
    private Position position;
    private final Direction direction = NORTH;
    private Point x;
    private Point y;
    private static final String COORDINATE_POINTS_Y_SHOULD_MATCHED = "The coordinate y point should matched";
    private static final String COORDINATES_POINTS_X_SHOULD_MATCHED = "The coordinate x point should matched";
    private List obstacles;
    @Mock
    private ImpedimentImpl impediment;

    @Before
    public void before() {
        initMocks(this);
        roverPosition = RoverPositionImpl.init();
        roverPosition.setImpediment(impediment);
        x = new Point(0, 10);
        y = new Point(0, 10);
        position = new Position(x, y, direction);
        obstacles = new ArrayList<>();
    }


    @Test
    public void givenOrderForwardAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn() {
        int expected = y.getLocation() + 1;
        when(impediment.check(position.getX().getLocation(),expected,obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection(), obstacles);

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getPosition().getY().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y10DirectionNorth_whenSendOrder_ThenNewPositionIsReturn() {
        position.setY(new Point(10, 10));
        int expected = 0;
        when(impediment.check(position.getX().getLocation(),expected,obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection(), obstacles);

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getPosition().getY().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn() {
        position = new Position(x, y, EAST);
        int expected = x.getLocation() + 1;
        when(impediment.check(expected,position.getY().getLocation(),obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection(), obstacles);

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getPosition().getX().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX10Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn() {
        x = new Point(10, 10);
        position = new Position(x, y, EAST);
        int expected = 0;
        when(impediment.check(expected,position.getY().getLocation(),obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection(), obstacles);

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getPosition().getX().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn() {
        position = new Position(x, y, WEST);
        int expected = x.getMaxLocation();
        when(impediment.check(expected,position.getY().getLocation(),obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection(), obstacles);

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getPosition().getX().getLocation());
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn() {
        position = new Position(x, y, SOUTH);
        int expected = y.getMaxLocation();
        when(impediment.check(position.getX().getLocation(),expected,obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection(), obstacles);

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getPosition().getY().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn() {
        int expected = y.getMaxLocation();
        when(impediment.check(position.getX().getLocation(),expected,obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection().getBackwardDirection(), obstacles);

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getPosition().getY().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        position = new Position(x, y, EAST);
        int expected = x.getMaxLocation();
        when(impediment.check(expected,position.getY().getLocation(),obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection().getBackwardDirection(), obstacles);

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getPosition().getX().getLocation());
    }


    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn(){
        position = new Position(x, y, WEST);
        int expected = x.getLocation() + 1;
        when(impediment.check(expected,position.getY().getLocation(),obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection().getBackwardDirection(), obstacles);

        assertEquals(COORDINATES_POINTS_X_SHOULD_MATCHED,expected,result.getPosition().getX().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn(){
        position = new Position(x, y,SOUTH);
        int expected = y.getLocation() + 1;
        when(impediment.check(position.getX().getLocation(),expected,obstacles)).thenReturn(OK);

        Rover result = roverPosition.move(position, position.getDirection().getBackwardDirection(), obstacles);

        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,expected,result.getPosition().getY().getLocation());
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturnAndStatusNOK(){
        position = new Position(x, y,SOUTH);
        int expected = y.getLocation() + 1;
        when(impediment.check(position.getX().getLocation(),expected,obstacles)).thenReturn(NOK);

        Rover result = roverPosition.move(position, position.getDirection().getBackwardDirection(), obstacles);

        assertEquals("the status should match",NOK.name(),result.getStatus());
        assertEquals(COORDINATE_POINTS_Y_SHOULD_MATCHED,0,result.getPosition().getY().getLocation());
    }
}
