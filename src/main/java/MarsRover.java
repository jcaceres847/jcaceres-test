import data.Point;
import data.Position;
import enums.Direction;
import org.apache.commons.lang3.StringUtils;
import services.RoverDirectionImpl;
import services.RoverMoveImpl;
import services.RoverPositionImpl;

import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();
        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();
        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();
        Point x = new Point(roverx, sizex);
        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();
        Point y = new Point (rovery,sizey);
        System.out.println("Insert initial rover direction:");
        String roverz = reader.next();
        Direction direction = Direction.valueOfShortName(StringUtils.upperCase(roverz));
        Position actualPosition = new Position(x,y,direction);
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            RoverMoveImpl roverMove = new RoverMoveImpl();
            roverMove.setRoverDirection(new RoverDirectionImpl());
            roverMove.setRoverPosition(new RoverPositionImpl());
            Position newPosition = roverMove.sendOrder(command,actualPosition);
            System.out.println(String.format("Rover is at x:%d y:%d facing:%s ", newPosition.getX().getLocation(), newPosition.getY().getLocation(), newPosition.getDirection()));
        } while (true);
    }
}
