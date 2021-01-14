package services;

import data.Obstacle;
import data.Position;
import data.Rover;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoverMove {
    RoverPosition roverPosition;
    RoverDirection roverDirection;
    List<Obstacle> obstacles;

    private RoverMove() {}

    public static RoverMove init() {
        RoverMove move = new RoverMove();
        move.roverDirection = new RoverDirectionImpl();
        move.roverPosition = RoverPositionImpl.init();
        move.obstacles = new ArrayList<>();
        return move;
    }

    public Rover sendOrder(String order, Position position) throws IllegalArgumentException {
        switch(StringUtils.upperCase(order)) {
            case "F":
                return roverPosition.move(position,position.getDirection(),obstacles);
            case "B":
                return roverPosition.move(position,position.getDirection().getBackwardDirection(),obstacles);
            case "L":
                return roverDirection.change(position,-1);
            case "R":
                return roverDirection.change(position,1);
            default:
                throw new IllegalArgumentException("Command " + order + " is unknown.");
        }
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void setRoverPosition(RoverPositionImpl roverPosition) {
        this.roverPosition = roverPosition;
    }

    public void setRoverDirection(RoverDirectionImpl roverDirection) {
        this.roverDirection = roverDirection;
    }
}
