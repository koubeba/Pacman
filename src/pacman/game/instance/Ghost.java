package pacman.game.instance;

import pacman.game.instance.Damageable;

public class Ghost extends Damageable {

    // CONSTRUCTORS --------------------- //

    public Ghost(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position, speed);
    }

}