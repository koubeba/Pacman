package pacman.game.instance.interfaces;

import pacman.game.instance.MOVEMENT_INPUT;

public interface Movable extends SolidObject {
    // change the object position
    public void move(double delta);
    public void switchDirection(MOVEMENT_INPUT direction);
}
