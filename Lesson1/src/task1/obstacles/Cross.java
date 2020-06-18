package task1.obstacles;

import task1.competitors.Capabilities;

public class Cross extends Obstacle {
    private int dist;

    public Cross(int dist) {
        this.dist = dist;
    }

    public void doIt(Capabilities c) {
        c.run(dist);
    }
}