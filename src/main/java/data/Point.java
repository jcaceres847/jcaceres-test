package data;

public class Point {

    private int location;
    private int maxLocation;

    public void setLocation(int value) { location = value; }
    public int getLocation() { return location; }
    public void setMaxLocation(int value) { maxLocation = value; }
    public int getMaxLocation() { return maxLocation; }

    public Point(int locationValue, int maxLocationValue) {
        setLocation(locationValue);
        setMaxLocation(maxLocationValue);
    }

    public int getForwardLocation() {
        return (getLocation() + 1) % (getMaxLocation() + 1);
    }

    public int getBackwardLocation() {
        if (getLocation() > 0) return getLocation() - 1;
        else return getMaxLocation();
    }
}
