package data;

import enums.Direction;

public class Position {

    private Point x;
    private Point y;
    private Direction direction;

    public void setX(Point value) { x = value; }
    public Point getX() { return x; }
    public void setY(Point value) { y = value; }
    public Point getY() { return y; }
    public void setDirection(Direction value) {
        direction = value;
    }
    public Direction getDirection() {
        return direction;
    }

    public Position(Point xValue,
                    Point yValue,
                    Direction directionValue) {
        setX(xValue);
        setY(yValue);
        setDirection(directionValue);
    }
}