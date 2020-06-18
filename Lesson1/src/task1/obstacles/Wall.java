package task1.obstacles;

import task1.competitors.Capabilities;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Capabilities c) {
        c.jump(height);
    }
}
