package pacman.game.instance;

import pacman.Vector2;
import pacman.game.GAME_STATE;

public final class Blinky extends Ghost {

    // CONSTRUCTORS -------------------- //

    public Blinky(String name, int x_position, int y_position, int speed, Player player) {
        super(name, x_position, y_position, speed, player);
    }

    // METHODS ------------------------- //

    // Blinky follows the player and implements a simple obstacle tracing algorithm. //

    @Override
    public void move(GAME_STATE game_state) {

        switch (game_state) {
            case NORMAL:
                this.switchDirection();
                break;
            case POWERUP:
                this.runAway();
                break;
            default:
                this.switchDirection();
                break;
        }

        super.move(game_state);
    }

    private void switchDirection() {
        //this.nextDirection = player.getDirection();
        // Determine the direction that leads to the player //

        Vector2 dif = (new Vector2(this.player.x_position, this.player.y_position)).subtract(new Vector2(this.x_position, this.y_position));

        if (Math.abs(dif.getX()) > Math.abs(dif.getY())) {
            if (dif.getX() > 0) {
                this.nextDirection = MOVEMENT_INPUT.RIGHT;
            } else {
                this.nextDirection = MOVEMENT_INPUT.LEFT;
            }
        } else {
            if (dif.getY() > 0) {
                this.nextDirection = MOVEMENT_INPUT.DOWN;
            } else {
                this.nextDirection = MOVEMENT_INPUT.UP;
            }
        }

        // If there is an obstacle in the way //

        Vector2 playerVector = new Vector2(this.x_position, this.y_position);

        switch (this.nextDirection) {
            case UP:
                if (this.gridMap.alignedToTileVertical(playerVector) && !this.gridMap.getTile(playerVector).isUp()) {
                    if (dif.getX() > 0) {
                        this.nextDirection = MOVEMENT_INPUT.RIGHT;
                    } else {
                        this.nextDirection = MOVEMENT_INPUT.LEFT;
                    }
                }
                break;
            case DOWN:
                if (this.gridMap.alignedToTileVertical(playerVector) && !this.gridMap.getTile(playerVector).isDown()) {
                    if (dif.getX() > 0) {
                        this.nextDirection = MOVEMENT_INPUT.RIGHT;
                    } else {
                        this.nextDirection = MOVEMENT_INPUT.LEFT;
                    }
                }
                break;
            case RIGHT:
                if (this.gridMap.alignedToTileHorizontal(playerVector) && !this.gridMap.getTile(playerVector).isRight()) {
                    if (dif.getY() > 0) {
                        this.nextDirection = MOVEMENT_INPUT.UP;
                    } else {
                        this.nextDirection = MOVEMENT_INPUT.DOWN;
                    }
                }
                break;
            case LEFT:
                if (this.gridMap.alignedToTileHorizontal(playerVector) && !this.gridMap.getTile(playerVector).isLeft()) {
                    if (dif.getY() > 0) {
                        this.nextDirection = MOVEMENT_INPUT.UP;
                    } else {
                        this.nextDirection = MOVEMENT_INPUT.DOWN;
                    }
                }
                break;
        }

    }

}
