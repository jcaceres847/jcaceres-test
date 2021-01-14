package services;

import data.Position;
import data.Rover;
import enums.Direction;

import static enums.Status.OK;


public class RoverDirectionImpl implements RoverDirection {


    @Override
    public Rover change(Position position, int directionStep) {
        Direction direction = position.getDirection();
        int directions = Direction.values().length;
        int index = (directions + direction.getValue() + directionStep) % directions;
        position.setDirection(Direction.values()[index]);
        return new Rover(position, OK.name());
    }
}
