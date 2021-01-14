package data;

public class Obstacle {

    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public void setX(final int value) {
        x = value;
    }

    public int getY() {
        return y;
    }
    public void setY(final int value) {
        y = value;
    }

    public Obstacle(final int xValue, final int yValue) {
        setX(xValue);
        setY(yValue);
    }
}
