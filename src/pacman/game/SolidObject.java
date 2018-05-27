package pacman.game;

import pacman.render.graphics.SpriteGraphic;

import java.awt.*;

public class SolidObject implements pacman.game.interfaces.SolidObject {

    // FIELDS --------------------- //
    protected SpriteGraphic spriteGraphic;
    public final String name;

    protected boolean active = true;

    // TODO: change it in a vector?
    protected int x_position, y_position;

    // CONSTRUCTORS --------------- //

    public SolidObject(String name, int x_position, int y_position) {
        this.name = name;
        this.x_position = x_position;
        this.y_position = y_position;

        this.spriteGraphic = new SpriteGraphic(name, x_position, y_position);
    }

    public SolidObject(String name) {
        this(name, 0, 0);
    }

    @Override
    public void render(Graphics g) {
        this.spriteGraphic.setPosition(this.x_position, this.y_position);
        this.spriteGraphic.render(g);
    }

    @Override
    public void checkCollision(SolidObject collider) {
        // do nothing
    }

    public boolean intersects(SolidObject object) {
        boolean x, y;

        if (this.x_position < object.x_position) {
            x = object.x_position - this.x_position <= this.spriteGraphic.getImgWidth();
        } else {
            x = this.x_position - object.x_position <= object.spriteGraphic.getImgWidth();
        }
        if (this.y_position < object.y_position) {
            y = object.y_position - this.y_position <= this.spriteGraphic.getImgHeight();
        } else {
            y = this.y_position - object.y_position <= object.spriteGraphic.getImgHeight();
        }

        return x && y;

    }

    public void die() {
        this.active = false;
    }

    // GETTERS AND SETTERS ------------------------------ //


    public boolean isActive() {
        return active;
    }
}
