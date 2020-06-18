package task1;

import task1.competitors.Capabilities;
import task1.competitors.Cat;
import task1.competitors.Human;
import task1.competitors.Robot;
import task1.obstacles.Cross;
import task1.obstacles.Obstacle;
import task1.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Capabilities[] capabilities = {
                new Human("Tom", 1000, 1),
                new Cat("Murzik",300, 3),
                new Robot("WALL-E",5000, 0),
        };

        Obstacle[] obstacles ={
                new Cross(100),
                new Wall(2),
                new Cross(200)
        };

        for (Capabilities c : capabilities ) {
            for (Obstacle o : obstacles ) {
                o.doIt(c);
                if(!c.isOnDistance()){
                    break;
                }
            }
        }

        for (Capabilities competitor : capabilities) {
            competitor.info();
        }
    }
}