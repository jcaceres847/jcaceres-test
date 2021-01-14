package services;

import data.Obstacle;
import data.Position;
import data.Rover;
import enums.Direction;

import java.util.List;

/**
 * Contains the services to change position if not found obstacles.
 */
public interface RoverPosition {

    /**
     * Contains the service to move the position.
     * @param  position the actual position.
     * @param  directionValue the direction to move.
     * @param  obstacles the list of obstacles.
     * @return the new position and status of rover.
     */
    Rover move(Position position, Direction directionValue, List<Obstacle> obstacles) ;
}
