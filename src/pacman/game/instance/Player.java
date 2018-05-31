package pacman.game.instance;

import pacman.game.GAME_STATE;
import pacman.game.GameManager;
import pacman.game.instance.interfaces.Damageable;

public class Player extends Collector implements Damageable {

    // FIELDS ----------------------------------------- //

    private final GameManager gameManager;

    private boolean upCollision, downCollision, rightCollision, leftCollision;

    // CONSTRUCTORS ----------------------------------- //

    public Player(String name, int x_position, int y_position, int speed, GameManager gameManager) {
        super(name, x_position, y_position, speed);

        this.gameManager = gameManager;

        this.upCollision = false;
        this.downCollision = false;
        this.rightCollision = false;
        this.leftCollision = false;
    }

    // METHODS ---------------------------------------- //

    // TODO: write better wall collision... check all sides etc
    public boolean checkWallCollision(SolidObject collider) {

        // TODO: differentiate 4 cases
        return (intersects(collider));

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

    @Override
    public void switchDirection(MOVEMENT_INPUT direction) {
        if (!upCollision) super.switchDirection(direction);
    }

    // GETTERS AND SETTERS ------------------------- //

    public void setUpCollision(boolean upCollision) {
        this.upCollision = upCollision;
    }
}
