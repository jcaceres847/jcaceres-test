package service;

import data.Position;

/**
 * Contains the services to move rover of position.
 */
public interface RoverMove {

    /**
     * @param order Command order
     * @return the new Position of Rover.
     */
    Position sendOrder(String order, Position actualPosition);
}
