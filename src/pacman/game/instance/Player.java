package pacman.game.instance;

import pacman.game.GAME_STATE;
import pacman.game.GameManager;
import pacman.game.instance.interfaces.Damageable;

public final class Player extends Collector implements Damageable {

    // FIELDS ----------------------------------------- //

    private final GameManager gameManager;

    private boolean upCollision, downCollision, rightCollision, leftCollision;

    private MOVEMENT_INPUT nextDirection;

    // CONSTS ----------------------------------------- //

    private final static int collisionEpsilon = 1;

    // CONSTRUCTORS ----------------------------------- //

    public Player(String name, int x_position, int y_position, int speed, GameManager gameManager) {
        super(name, x_position, y_position, speed);

        this.gameManager = gameManager;

        this.resetCollisionFlags();
    }

    // METHODS ---------------------------------------- //

    // TODO: write better wall collision... check all sides etc
    public void checkWallCollision(SolidObject collider) {

    }

    public void checkCollectibleCollision(Collectible collectible) {
        if (intersects(collectible)) {
            if (collectible.isActive()) collectible.beCollected();
        }
    }

    public void checkGhostCollision(Ghost ghost, GAME_STATE game_state) {
        switch (game_state) {
            case NORMAL:
                if (intersects(ghost)) {
                    this.beDamaged();
                }
                break;
            case POWERUP:
                if (intersects(ghost)) {
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
    }

    @Override
    public void die() {
        super.die();
        gameManager.setGameState(GAME_STATE.END);
    }

    // GETTERS AND SETTERS ------------------------- //

    public void resetCollisionFlags() {
        this.upCollision = false;
        this.downCollision = false;
        this.rightCollision = false;
        this.leftCollision = false;
    }
}
