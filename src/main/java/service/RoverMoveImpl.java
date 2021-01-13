package service;

import data.Position;

public class RoverMoveImpl implements RoverMove {

    @Override
    public Position sendOrder(String order, Position actualPosition) {
        String roverz = actualPosition.getZ();
        int y = actualPosition.getY();
        int x = actualPosition.getX();
        String z = actualPosition.getZ();
        if (order.equals("f")) {
            if (roverz.equals("n")) {
                y += 1;
            }
            if (roverz.equals("w")) {
                x -= 1;
            }
            if (roverz.equals("s")) {
                y -= 1;
            }
            if (roverz.equals("e")) {
                x += 1;
            }
        }
        if (order.equals("b")) {
            if (roverz.equals("n")) {
                y -= 1;
            }
            if (roverz.equals("w")) {
                x += 1;
            }
            if (roverz.equals("s")) {
                y += 1;
            }
            if (roverz.equals("e")) {
                x -= 1;
            }
        }
        if (order.equals("l")) {
            if (roverz.equals("n")) {
                z = "w";
            }
            if (roverz.equals("w")) {
                z = "s";
            }
            if (roverz.equals("s")) {
                z = "e";
            }
            if (roverz.equals("e")) {
                z = "n";
            }
        }
        if (order.equals("r")) {
            if (roverz.equals("n")) {
                z = "e";
            }
            if (roverz.equals("e")) {
                z = "s";
            }
            if (roverz.equals("s")) {
                z = "w";
            }
            if (roverz.equals("w")) {
                z = "n";
            }
        }
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        position.setZ(z);
        return position;
    }
}
