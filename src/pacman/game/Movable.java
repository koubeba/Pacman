package pacman.game;

import pacman.render.graphics.MovableSpriteGraphic;
import pacman.render.graphics.SpriteGraphic;

import java.awt.*;

public class Movable extends SolidObject implements pacman.game.interfaces.Movable {

    // FIELDS -------------- //

    private int speed;

    // CONSTRUCTORS -------- //

    public Movable(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position);
        this.spriteGraphic = new MovableSpriteGraphic(name, x_position, y_position);
        this.speed = speed;
    }

    // METHODS ------------- //
    public void move(MOVEMENT_INPUT direction, double delta) {
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

}
