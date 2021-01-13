package services;

import data.Position;

/**
 * Contains the service to change direction, move position and check obstacles.
 */
public interface RoverMove {

    /**
     * @param order order command (f = forward, b = backward, l = turn left, r = turn right)
     * @param actualPosition the actual position of rover.
     * @return the new position.
     */
    Position sendOrder(String order, Position actualPosition) throws Exception;
}
