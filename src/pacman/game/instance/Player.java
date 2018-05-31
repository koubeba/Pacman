package pacman.game.instance;

import pacman.game.GAME_STATE;
import pacman.game.GameManager;
import pacman.game.instance.interfaces.Damageable;

public class Player extends Collector implements Damageable {

    // FIELDS ----------------------------------------- //

    private final GameManager gameManager;

    private boolean upCollision, downCollision, rightCollision, leftCollision;

    // CONSTS ----------------------------------------- //

    private final static int collisionEpsilon = 1;

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
    public void checkWallCollision(SolidObject collider) {

        // CASE 1: DOWN COLLISION //
        if (this.y_position < collider.y_position && collider.y_position - this.y_position <= (int)this.spriteGraphic.getImgHeight()) {
            if (!downCollision) downCollision = Math.abs(this.x_position  - collider.x_position) < collider.spriteGraphic.getImgWidth() - collisionEpsilon;
        }

        // CASE 2: UP COLLISION //

        if (this.y_position > collider.y_position && this.y_position - collider.y_position <= (int)this.spriteGraphic.getImgHeight()) {
            if (!upCollision) upCollision = Math.abs(this.x_position - collider.x_position) < collider.spriteGraphic.getImgWidth() - collisionEpsilon;
        }

        // CASE 3: RIGHT COLLISION //

        if (this.x_position < collider.x_position && collider.x_position - this.x_position <= (int)this.spriteGraphic.getImgWidth()) {
            if (!rightCollision) rightCollision = Math.abs(collider.y_position - this.y_position) < collider.spriteGraphic.getImgHeight() - collisionEpsilon;
        }

        // CASE 4: LEFT COLLISION //

        if (this.x_position > collider.x_position && this.x_position - collider.x_position <= (int)collider.spriteGraphic.getImgWidth()) {
            if (!leftCollision) leftCollision = Math.abs(collider.y_position - this.y_position) < collider.spriteGraphic.getImgHeight() - collisionEpsilon;
        }


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
    public void move(double delta) {
        switch (direction) {
            case UP:
                if (!upCollision) this.y_position -= speed * delta;
                break;
            case DOWN:
                if (!downCollision) this.y_position += speed * delta;
                break;
            case LEFT:
                if (!leftCollision) this.x_position -= speed * delta;
                break;
            case RIGHT:
                if (!rightCollision) this.x_position += speed * delta;
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
        switch (direction) {
            case UP:
                if (upCollision) {
                    return;
                }
                break;
            case DOWN:
                if (downCollision) {
                    return;
                }
                break;
            case LEFT:
                if (leftCollision) {
                    return;
                }
                break;
            case RIGHT:
                if (rightCollision) {
                    return;
                }
                break;
        }
        this.direction = direction;
    }

    // GETTERS AND SETTERS ------------------------- //

    public void resetCollisionFlags() {
        this.upCollision = false;
        this.downCollision = false;
        this.leftCollision = false;
        this.rightCollision = false;
    }
}
