package services;

import data.Position;
import enums.Direction;


public class RoverPositionImpl implements RoverPosition {


    @Override
    public Position move(Position position, Direction directionValue) {
        int xLocation = position.getX().getLocation();
        int yLocation = position.getY().getLocation();
        switch (directionValue) {
            case NORTH:
                yLocation = position.getY().getForwardLocation();
                break;
            case EAST:
                xLocation = position.getX().getForwardLocation();
                break;
            case SOUTH:
                yLocation = position.getY().getBackwardLocation();
                break;
            case WEST:
                xLocation =  position.getX().getBackwardLocation();
                break;
        }
            position.getX().setLocation(xLocation);
            position.getY().setLocation(yLocation);
            return position;
    }
}
