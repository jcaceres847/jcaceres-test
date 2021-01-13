package services;

import data.Position;
import enums.Direction;

/**
 * Contains the services to change position if not found obstacles.
 */
public interface RoverPosition {

    /**
     * Contains the service to move the position.
     * @param  position the actual position.
     * @param  directionValue the direction to move.
     * @return the new position of rover.
     */
    Position move(Position position, Direction directionValue) ;
}
