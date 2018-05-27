package pacman.game;

import pacman.game.interfaces.Damageable;

public class Player extends Collector implements Damageable {

    // FIELDS ----------------------------------------- //

    private final GameManager gameManager;

    // CONSTRUCTORS ----------------------------------- //

    public Player(String name, int x_position, int y_position, int speed, GameManager gameManager) {
        super(name, x_position, y_position, speed);

        this.gameManager = gameManager;
    }

    // METHODS ---------------------------------------- //

    @Override
    public void checkCollision(SolidObject collider) {
        // check collision with collectibles
        super.checkCollision(collider);

        // check collisions with Ghosts
        if (collider instanceof Ghost) {
            if (intersects(collider)) {
                this.beDamaged();
            }
        }
    }

    @Override
    public void beDamaged() {
        this.die();
    }

    @Override
    public void damageObject(Damageable damageable) {
    }

    @Override
    public void die() {
        super.die();
        gameManager.setGameState(GAME_STATE.END);
    }
}
