package services;

import data.Position;
/**
 * Contains the services to change direction.
 */
public interface RoverDirection {

    /**
     * Change the direction to the Right depending of the actual direction.
     * @param actualPosition the actual position
     * @param directionStep the int value to redirect.
     * @return the new position.
     */
    Position change(Position actualPosition, int directionStep) throws Exception;
}
