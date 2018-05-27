package pacman.game.instance;

import pacman.game.instance.Damageable;

public class Ghost extends Damageable {

    // FIELDS --------------------------- //

    protected Player player;

    // CONSTRUCTORS --------------------- //

    public Ghost(String name, int x_position, int y_position, int speed, Player player) {
        super(name, x_position, y_position, speed);
        this.player = player;
    }

}
