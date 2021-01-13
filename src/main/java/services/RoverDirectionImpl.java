package services;

import data.Position;
import enums.Direction;

public class RoverDirectionImpl implements RoverDirection {


    @Override
    public Position change(Position position, int directionStep) {
        Direction direction = position.getDirection();
        int directions = Direction.values().length;
        int index = (directions + direction.getValue() + directionStep) % directions;
        position.setDirection(Direction.values()[index]);
        return position;
    }
}
