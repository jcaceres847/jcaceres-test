package data;

public class Rover {

    private Position position;
    private String status;

    public Rover(final Position position, final String status) {
        setPosition(position);
        setStatus(status);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
