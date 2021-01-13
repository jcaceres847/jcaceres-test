package services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import data.Point;
import data.Position;
import enums.Direction;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static enums.Direction.NORTH;

public class RoverMoveTest {


    private RoverMoveImpl roverMove;
    private Position position;
    private final Direction direction = NORTH;
    private Point x;
    private Point y;
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
        roverMove = new RoverMoveImpl();
        roverMove.setRoverPosition(roverPosition);
        roverMove.setRoverDirection(roverDirection);
        x = new Point(0, 10);
        y = new Point(0, 10);
        position = new Position(x, y, direction);
    }

    @Test(expected = Exception.class)
    public void givenNotExistingOrder_whenSendOrder_ThenExceptionIsThrown() throws Exception {
        roverMove.sendOrder("p",position);
    }

    @Test()
    public void givenForwardOrder_whenSendOrder_ThenRoverPositionMoveIsCalled() throws Exception {
        when(roverPosition.move(any(),any())).thenReturn(new Position(x,y,NORTH));

        roverMove.sendOrder(FORWARD,position);

        verify(roverPosition, times(1)).move(any(),any());
    }

    @Test()
    public void givenBackwardOrder_whenSendOrder_ThenRoverPositionMoveIsCalled() throws Exception {
        when(roverPosition.move(any(),any())).thenReturn(new Position(x,y,NORTH));

        roverMove.sendOrder(BACKWARD,position);

        verify(roverPosition, times(1)).move(any(),any());
    }
    @Test()
    public void givenLeftOrder_whenSendOrder_ThenRoverDirectionChangeIsCalled() throws Exception {
        when(roverDirection.change(any(),anyInt())).thenReturn(new Position(x,y,NORTH));

        roverMove.sendOrder(LEFT,position);

        verify(roverDirection, times(1)).change(any(),anyInt());
    }

    @Test()
    public void givenRightOrder_whenSendOrder_ThenRoverDirectionChangeIsCalled() throws Exception {
        when(roverDirection.change(any(),anyInt())).thenReturn(new Position(x,y,NORTH));

        roverMove.sendOrder(RIGHT,position);

        verify(roverDirection, times(1)).change(any(),anyInt());
    }
}
