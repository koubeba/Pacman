package pacman.game.instance;

import pacman.game.instance.interfaces.Collectible;

public class Collector extends Movable implements pacman.game.instance.interfaces.Collector {

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

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void checkCollision(SolidObject collider) {

        // Interact only with collectibles
        if (collider.getClass().equals(pacman.game.instance.Collectible.class)) {
            if (intersects(collider)) {
                ((pacman.game.instance.Collectible)collider).beCollected();
            }
        }

    }
}
