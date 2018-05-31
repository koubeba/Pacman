package pacman.game.instance;

import pacman.render.graphics.MovableSpriteGraphic;

public class Movable extends SolidObject implements pacman.game.instance.interfaces.Movable {

    // FIELDS -------------- //

    protected int speed;
    protected MOVEMENT_INPUT direction = MOVEMENT_INPUT.RIGHT;

    // CONSTRUCTORS -------- //

    public Movable(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position);
        this.spriteGraphic = new MovableSpriteGraphic(name, x_position, y_position);
        this.speed = speed;
    }

    // METHODS ------------- //

    public void move(double delta) {
        switch (direction) {
            case UP:
                this.y_position -= speed * delta;
                break;
            case DOWN:
                this.y_position += speed * delta;
                break;
            case LEFT:
                this.x_position -= speed * delta;
                break;
            case RIGHT:
                this.x_position += speed * delta;
                break;
        }
    }

    public void switchDirection(MOVEMENT_INPUT direction) {
        this.direction = direction;
    }

}
