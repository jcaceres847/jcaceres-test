package service;

import data.Position;
import org.junit.Before;
import org.junit.Test;
import data.Position;

import static org.junit.Assert.assertEquals;

public class RoverMoveTest {

    private static final String FORWARD = "f";
    private static final String BACKWARD = "b";
    private static final String LEFT = "l";
    private static final String RIGHT = "r";
    private static final String NORTH = "n";
    private static final String SOUTH = "s";
    private static final String EAST = "e";
    private static final String WEST = "w";
    RoverMove roverMove ;

    @Before
    public void before() {
        roverMove = new RoverMoveImpl();
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(NORTH).build();

        Position result = roverMove.sendOrder(FORWARD,actualPosition);

        Position expected = Position.builder().x(0).y(1).z(NORTH).build();
        assertActualPosition(result,expected);

    }

    //TODO. in the next refactoring the y value should be 0 instead of 11
    @Test
    public void givenOrderForwardAndPointX0Y10DirectionNorth_whenSendOrder_ThenNewPositionIsReturn() {
        Position actualPosition = Position.builder().x(0).y(10).z(NORTH).build();

        Position result = roverMove.sendOrder(FORWARD,actualPosition);

        Position expected = Position.builder().x(0).y(11).z(NORTH).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderForwardAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(EAST).build();

        Position result = roverMove.sendOrder(FORWARD,actualPosition);

        Position expected = Position.builder().x(1).y(0).z(EAST).build();
        assertActualPosition(result,expected);
    }

    //TODO. in the next refactoring the x value should be 0 instead of 11
    @Test
    public void givenOrderForwardAndPointX10Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn() {
        Position actualPosition = Position.builder().x(10).y(10).z(EAST).build();

        Position result = roverMove.sendOrder(FORWARD,actualPosition);

        Position expected = Position.builder().x(11).y(10).z(EAST).build();
        assertActualPosition(result,expected);
    }

    //TODO. in the next refactoring the x value should be have the sizex instead of -1
    @Test
    public void givenOrderForwardAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn() {
        Position actualPosition = Position.builder().x(0).y(0).z(WEST).build();

        Position result = roverMove.sendOrder(FORWARD,actualPosition);

        Position expected = Position.builder().x(-1).y(0).z(WEST).build();
        assertActualPosition(result,expected);
    }

    //TODO. in the next refactoring the y value should be have the sizey instead of -1
    @Test
    public void givenOrderForwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(SOUTH).build();

        Position result = roverMove.sendOrder(FORWARD,actualPosition);

        Position expected = Position.builder().x(0).y(-1).z(SOUTH).build();
        assertActualPosition(result,expected);
    }



    //TODO. in the next refactoring the y value should be have the sizey instead of -1
    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(NORTH).build();
        Position result = roverMove.sendOrder(BACKWARD,actualPosition);

        Position expected = Position.builder().x(0).y(-1).z(NORTH).build();
        assertActualPosition(result,expected);
    }


    //TODO. in the next refactoring the x value should be have the sizex instead of -1
    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(EAST).build();
        Position result = roverMove.sendOrder(BACKWARD,actualPosition);

        Position expected = Position.builder().x(-1).y(0).z(EAST).build();
        assertActualPosition(result,expected);
    }


    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(WEST).build();
        Position result = roverMove.sendOrder(BACKWARD,actualPosition);

        Position expected = Position.builder().x(1).y(0).z(WEST).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderBackwardAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(SOUTH).build();

        Position result = roverMove.sendOrder(BACKWARD,actualPosition);

        Position expected = Position.builder().x(0).y(1).z(SOUTH).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderLeftAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(NORTH).build();
        Position result = roverMove.sendOrder(LEFT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(WEST).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderLeftAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(EAST).build();
        Position result = roverMove.sendOrder(LEFT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(NORTH).build();
        assertActualPosition(result,expected);
    }



    @Test
    public void givenOrderLeftAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(WEST).build();
        Position result = roverMove.sendOrder(LEFT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(SOUTH).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderLeftAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(SOUTH).build();
        Position result = roverMove.sendOrder(LEFT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(EAST).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderRightAndPointX0Y0DirectionNorth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(NORTH).build();
        Position result = roverMove.sendOrder(RIGHT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(EAST).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderRightAndPointX0Y0DirectionEast_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(EAST).build();
        Position result = roverMove.sendOrder(RIGHT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(SOUTH).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderRightAndPointX0Y0DirectionWest_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(WEST).build();
        Position result = roverMove.sendOrder(RIGHT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(NORTH).build();
        assertActualPosition(result,expected);
    }

    @Test
    public void givenOrderRightAndPointX0Y0DirectionSouth_whenSendOrder_ThenNewPositionIsReturn()  {
        Position actualPosition = Position.builder().x(0).y(0).z(SOUTH).build();
        Position result = roverMove.sendOrder(RIGHT,actualPosition);

        Position expected = Position.builder().x(0).y(0).z(WEST).build();
        assertActualPosition(result,expected);
    }

    private void assertActualPosition(Position result, Position expected) {
        assertEquals("The coordinate y point should matched",expected.getY(), result.getY());
        assertEquals("The coordinate x point should matched",expected.getX(), result.getX());
        assertEquals("The direction should matched",expected.getZ(), result.getZ());
    }
}
