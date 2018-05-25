package pacman.game.interfaces;

import pacman.game.MOVEMENT_INPUT;

public interface Movable extends SolidObject {
    // change the object position
    public void move(MOVEMENT_INPUT direction);
}
