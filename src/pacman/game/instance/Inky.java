package pacman.game.instance;

import pacman.Vector2;

public final class Inky extends Ghost {

    // CONSTRUCTORS -------------------- //

    public Inky(String name, int x_position, int y_position, int speed, Player player) {
        super(name, x_position, y_position, speed, player);
    }

    // METHODS ------------------------- //

    @Override
    public void move(double delta) {
        this.switchDirection();
        super.move(delta);
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
