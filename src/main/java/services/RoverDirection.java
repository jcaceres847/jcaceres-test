package services;

import data.Position;
import data.Rover;


/**
 * Contains the services to change direction.
 */
public interface RoverDirection {

    /**
     * Change the direction to the Right depending of the actual direction.
     * @param position the actual position
     * @param directionStep the int value to redirect.
     * @return the rover vehicle with its new position and status.
     */
    Rover change(Position position, int directionStep) ;
}
