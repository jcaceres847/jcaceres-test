package services;

import data.Obstacle;
import enums.Status;

import java.util.List;

import static enums.Status.NOK;
import static enums.Status.OK;

public class ImpedimentImpl implements Impediment{

    @Override
    public Status check(int x, int y, List<Obstacle> obstacles) {
        if (!hasObstacle(x, y,obstacles)) {
            return OK;
        } else {
            return NOK;
        }
    }

    private boolean hasObstacle(int xLocation, int yLocation, List<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == xLocation && obstacle.getY() == yLocation) {
                return true;
            }
        }
        return false;
    }
}
