package pacman.game.instance;

import pacman.Vector2;
import pacman.game.instance.Damageable;

public class Ghost extends Damageable {

    // FIELDS --------------------------- //

    protected Player player;

    // CONSTRUCTORS --------------------- //

    public Ghost(String name, int x_position, int y_position, int speed, Player player) {
        super(name, x_position, y_position, speed);
        this.player = player;
    }

    // METHODS -------------------------- //

    public void runAway() {
        Vector2 dif = (new Vector2(this.player.x_position, this.player.y_position)).subtract(new Vector2(this.x_position, this.y_position));

        if (Math.abs(dif.getX()) > Math.abs(dif.getY())) {
            if (dif.getX() < 0) {
                this.nextDirection = MOVEMENT_INPUT.RIGHT;
            } else {
                this.nextDirection = MOVEMENT_INPUT.LEFT;
            }
        } else {
            if (dif.getY() < 0) {
                this.nextDirection = MOVEMENT_INPUT.DOWN;
            } else {
                this.nextDirection = MOVEMENT_INPUT.UP;
            }
        }
    }

}
