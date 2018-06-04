package pacman.game.instance;

import pacman.Vector2;
import pacman.game.GAME_STATE;

public final class Clyde extends Ghost {

    // CONSTRUCTORS -------------------- //

    public Clyde(String name, int x_position, int y_position, int speed, Player player) {
        super(name, x_position, y_position, speed, player);
    }

    // METHODS ------------------------- //

    @Override
    public void move(GAME_STATE game_state) {
        this.runAway();
        super.move(game_state);
    }

}
