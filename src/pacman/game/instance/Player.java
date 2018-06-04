package pacman.game.instance;

import pacman.game.GAME_STATE;
import pacman.game.GameManager;
import pacman.game.instance.interfaces.Damageable;

public final class Player extends Collector implements Damageable {

    // FIELDS ----------------------------------------- //

    private boolean restart = false;

    private MOVEMENT_INPUT nextDirection;

    // CONSTS ----------------------------------------- //

    private final static int collisionEpsilon = 1;

    // CONSTRUCTORS ----------------------------------- //

    public Player(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position, speed);
    }

    // METHODS ---------------------------------------- //

    public void checkCollectibleCollision(Collectible collectible) {
        if (intersects(collectible)) {
            if (collectible.isActive()) collectible.beCollected();
        }
    }

    public void checkGhostCollision(Ghost ghost, GAME_STATE game_state) {
        switch (game_state) {
            case NORMAL:
                if (intersects(ghost) && ghost.isActive()) {
                    this.beDamaged();
                }
                break;
            case POWERUP:
                if (intersects(ghost) && ghost.isActive()) {
                    this.points += 200;
                    damageObject(ghost);
                }
                break;
        }
    }

    @Override
    public void beDamaged() {
        this.die();
    }

    @Override
    public void damageObject(Damageable damageable) {
        damageable.die();
    }

    @Override
    public void die() {
        super.die();
        this.restart = true;
    }

    // GETTERS AND SETTERS ------------------------- //

    public boolean isRestart() {
        return restart;
    }

    public MOVEMENT_INPUT getNextDirection() {
        return nextDirection;
    }
}
