package services;

import data.Obstacle;
import data.Position;
import data.Rover;
import enums.Direction;

import java.util.List;

import static enums.Status.NOK;
import static enums.Status.OK;

public class RoverPositionImpl implements RoverPosition {

    Impediment impediment;

    private RoverPositionImpl() {}

    public static RoverPositionImpl init() {
        RoverPositionImpl roverPosition = new RoverPositionImpl();
        roverPosition.impediment = new ImpedimentImpl();
        return roverPosition;
    }

    public void setImpediment(Impediment impediment) {
        this.impediment = impediment;
    }

    @Override
    public Rover move(Position position, Direction directionValue, List<Obstacle> obstacles) {
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
        if (OK.equals(impediment.check(xLocation, yLocation,obstacles))) {
            position.getX().setLocation(xLocation);
            position.getY().setLocation(yLocation);
            return new Rover(position, OK.name());
        } else {
            return new Rover(position, NOK.name());
        }
    }
}
