import data.Obstacle;
import enums.Direction;
import data.Point;
import data.Position;
import data.Rover;
import org.apache.commons.lang3.StringUtils;
import services.RoverMove;

import java.util.Arrays;
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
            RoverMove roverMove = RoverMove.init();
            roverMove.setObstacles(Arrays.asList(new Obstacle(0,1)));
            Rover rover = roverMove.sendOrder(command,actualPosition);
            Position newPosition = rover.getPosition();
            System.out.println(String.format("Rover is at x:%d y:%d facing:%s and status:%s", newPosition.getX().getLocation(), newPosition.getY().getLocation(), newPosition.getDirection(),rover.getStatus()));
        } while (true);
    }
}
