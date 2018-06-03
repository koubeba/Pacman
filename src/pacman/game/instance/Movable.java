package pacman.game.instance;

import pacman.Pacman;
import pacman.Vector2;
import pacman.game.instance.GridMap.GridMap;
import pacman.render.graphics.MovableSpriteGraphic;

public class Movable extends SolidObject implements pacman.game.instance.interfaces.Movable {

    // FIELDS -------------- //

    protected int speed;
    protected MOVEMENT_INPUT direction = MOVEMENT_INPUT.RIGHT;
    protected MOVEMENT_INPUT nextDirection = MOVEMENT_INPUT.RIGHT;

    protected GridMap gridMap;

    // CONSTRUCTORS -------- //

    public Movable(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position);
        this.spriteGraphic = new MovableSpriteGraphic(name, x_position, y_position);
        this.speed = speed;
    }

    // METHODS ------------- //

    public void checkWallCollision(GridMap gridMap) {

    }

    public void move(double delta) {

        Vector2 playerVector = new Vector2(this.x_position, this.y_position);

        // SWITCH TO NEXT DIRECTION //
        switch (this.nextDirection) {
            case RIGHT:
                if (this.gridMap.alignedToTile(playerVector) && this.gridMap.getTile(playerVector).isRight()) {
                    this.direction = this.nextDirection;
                }
                break;
            case LEFT:
                if (this.gridMap.alignedToTile(playerVector) && this.gridMap.getTile(playerVector).isLeft()) {
                    this.direction = this.nextDirection;
                }
                break;
            case UP:
                if (this.gridMap.alignedToTile(playerVector) && this.gridMap.getTile(playerVector).isUp()) {
                    this.direction = this.nextDirection;
                }
                break;
            case DOWN:
                if (this.gridMap.alignedToTile(playerVector) && this.gridMap.getTile(playerVector).isDown()) {
                    this.direction = this.nextDirection;
                }
                break;
        }

            switch (direction) {
                case UP:
                    if (this.gridMap.alignedToTileVertical(playerVector) && this.gridMap.edgeUp(playerVector)) return;

                    if (this.gridMap.alignedToTileVertical(playerVector) && !this.gridMap.getTile(playerVector).isUp()) {
                        return;
                    } else {
                        this.y_position -= 1;
                    }
                    break;
                case DOWN:
                    if (this.gridMap.alignedToTileVertical(playerVector) && this.gridMap.edgeDown(this.gridMap.SnapToGrid(playerVector))) return;

                    if (this.gridMap.alignedToTileVertical(playerVector) && !this.gridMap.getTile(playerVector).isDown()){
                        return;
                    } else {
                        this.y_position +=  1;
                    }
                    break;
                case LEFT:
                    if (this.gridMap.alignedToTileHorizontal(playerVector) && this.gridMap.edgeLeft(playerVector)) return;

                    if (this.gridMap.alignedToTileHorizontal(playerVector) && !this.gridMap.getTile(playerVector).isLeft()) {
                        return;
                    } else {
                        this.x_position -= 1;
                    }
                    break;
                case RIGHT:
                    if (this.gridMap.alignedToTileHorizontal(playerVector) && this.gridMap.edgeRight(this.gridMap.SnapToGrid(playerVector))) return;

                    if (this.gridMap.alignedToTileHorizontal(playerVector) && !this.gridMap.getTile(playerVector).isRight()) {
                        return;
                    } else {
                        this.x_position += 1;
                    }
                    break;
            }
    }

    public void switchDirection (MOVEMENT_INPUT direction) {

        Vector2 vecPos = new Vector2(this.x_position, this.y_position);

        switch (direction) {
            case UP:
                if (this.gridMap.edgeUp(vecPos)) {
                    return;
                }
                break;
            case DOWN:
                if (this.gridMap.edgeDown(vecPos)) {
                    return;
                }
                break;
            case LEFT:
                if (this.gridMap.edgeLeft(vecPos)) {
                    return;
                }
                break;
            case RIGHT:
                if (this.gridMap.edgeRight(vecPos)) {
                    return;
                }
        }
            this.nextDirection = direction;
    }


    // GETTERS AND SETTERS -- //

    public void setGridMap(GridMap gridMap) {
        this.gridMap = gridMap;
    }

    public MOVEMENT_INPUT getDirection() {
        return this.direction;
    }

}
