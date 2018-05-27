package pacman.game;

import pacman.game.interfaces.Collectible;
import pacman.game.interfaces.SolidObject;

public class Collector extends Movable implements pacman.game.interfaces.Collector {

    // FIELDS ----------------------- //

    protected int points = 0;

    // CONSTRUCTORS ----------------- //

    public Collector(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position, speed);
    }

    // METHODS ---------------------- //

    @Override
    public void collect(Collectible collectible, int points) {
        this.points += points;
    }

    // GETTERS AND SETTERS ---------- //

    public int getPoints() {
        return this.points;
    }

    @Override
    public void checkCollision(pacman.game.SolidObject collider) {

        // Interact only with collectibles
        if (collider.getClass().equals(pacman.game.Collectible.class)) {
            if (intersects(collider)) {
                ((pacman.game.Collectible)collider).beCollected();
            }
        }

    }
}
