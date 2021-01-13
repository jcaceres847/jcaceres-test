import data.Position;
import service.RoverMove;
import service.RoverMoveImpl;

import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();
        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();
        Position actualPosition = new Position();
        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();
        actualPosition.setX(roverx);
        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();
        actualPosition.setY(rovery);
        System.out.println("Insert initial rover direction:");
        String roverz = reader.next(); //n = north, e = east, w = west, s = south
        actualPosition.setZ(roverz);
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            RoverMove roverMove = new RoverMoveImpl();
            Position newPosition = roverMove.sendOrder(command,actualPosition);
            System.out.println(String.format("Rover is at x:%d y:%d facing:%s", newPosition.getX(), newPosition.getY(), newPosition.getZ()));
        } while (true);
    }
}
