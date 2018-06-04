package pacman.game.instance.interfaces;

import pacman.game.GAME_STATE;
import pacman.game.instance.MOVEMENT_INPUT;

public interface Movable extends SolidObject {
    // change the object position
    public void move(GAME_STATE game_state);
    public void switchDirection(MOVEMENT_INPUT direction);
}
