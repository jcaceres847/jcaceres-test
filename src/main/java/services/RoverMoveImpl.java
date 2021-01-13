package services;

import data.Position;
import org.apache.commons.lang3.StringUtils;


public class RoverMoveImpl implements RoverMove {

    RoverPosition roverPosition;
    RoverDirection roverDirection;

    @Override
    public Position sendOrder(String order, Position position) throws Exception {
        switch(StringUtils.upperCase(order)) {
            case "F":
                return roverPosition.move(position,position.getDirection());
            case "B":
                return roverPosition.move(position,position.getDirection().getBackwardDirection());
            case "L":
                return roverDirection.change(position,-1);
            case "R":
                return roverDirection.change(position,1);
            default:
                throw new Exception("Command " + order + " is unknown.");
        }
    }

    public void setRoverPosition(RoverPositionImpl roverPosition) {
        this.roverPosition = roverPosition;
    }

    public void setRoverDirection(RoverDirectionImpl roverDirection) {
        this.roverDirection = roverDirection;
    }
}
