package services;

import data.Point;
import data.Position;
import data.Rover;
import enums.Direction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static enums.Direction.NORTH;
import static enums.Direction.SOUTH;
import static enums.Status.OK;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class RoverMoveTest {


    public static final int LEFT_STEP = -1;
    public static final int RIGHT_STEP = 1;

    private RoverMove roverMove;
    private Position position;
    private final Direction direction = NORTH;
    private Point x;
    private Point y;
    private  List obstacles;
    @Mock
    private RoverPositionImpl roverPosition;
    @Mock
    private RoverDirectionImpl roverDirection;

    private static final String FORWARD = "f";
    private static final String BACKWARD = "b";
    private static final String LEFT = "l";
    private static final String RIGHT = "r";

    @Before
    public void before() {
        initMocks(this);
        roverMove = RoverMove.init();
        roverMove.setRoverPosition(roverPosition);
        roverMove.setRoverDirection(roverDirection);
        x = new Point(0, 10);
        y = new Point(0, 10);
        position = new Position(x, y, direction);
        obstacles = new ArrayList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistingOrder_whenSendOrder_ThenExceptionIsThrown() {

        roverMove.sendOrder("p",position);
    }

    @Test()
    public void givenForwardOrder_whenSendOrder_ThenRoverPositionMoveIsCalled()  {
        when(roverPosition.move(position,NORTH,obstacles)).thenReturn(new Rover(position,OK.name()));

        roverMove.sendOrder(FORWARD,position);

        verify(roverPosition, times(1)).move(position,NORTH,obstacles);
    }

    @Test()
    public void givenBackwardOrder_whenSendOrder_ThenRoverPositionMoveIsCalled()  {
        when(roverPosition.move(position,NORTH,obstacles)).thenReturn(new Rover(position,OK.name()));

        roverMove.sendOrder(BACKWARD,position);

        verify(roverPosition, times(1)).move(position,SOUTH,obstacles);
    }
    @Test()
    public void givenLeftOrder_whenSendOrder_ThenRoverDirectionChangeIsCalled()  {
        when(roverDirection.change(position, LEFT_STEP)).thenReturn(new Rover(position,OK.name()));

        roverMove.sendOrder(LEFT,position);

        verify(roverDirection, times(1)).change(position,LEFT_STEP);
    }

    @Test()
    public void givenRightOrder_whenSendOrder_ThenRoverDirectionChangeIsCalled()  {
        when(roverDirection.change(position,RIGHT_STEP)).thenReturn(new Rover(position,OK.name()));

        roverMove.sendOrder(RIGHT,position);

        verify(roverDirection, times(1)).change(position,RIGHT_STEP);
    }
}
