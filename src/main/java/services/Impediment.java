package services;

import data.Obstacle;
import enums.Status;

import java.util.List;

/**
 * Contains the services to check if rovers can move
 */
public interface Impediment {

    /**
     * Checks if rover can move depending of obstacles.
     * @param x the actual position
     * @param y the int value to redirect.
     * @return the new status of rover (OK if can move, NOK otherwise).
     */
    Status check(int x, int y, List<Obstacle> obstacles) ;
}
