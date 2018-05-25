package pacman.render.graphics;

import pacman.manager.file.FileManager;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

// Map HAS to contain the following:
// -idle

public class SpriteGraphic {

    // FIELD ------------------------------- //

    protected Animation animation;
    protected FileManager fileManager;
    protected String name;

    // TODO: make a Vector class?
    protected int x_position;
    protected int y_position;

    // CONSTANTS --------------------------- //


    // CONSTRUCTORS ------------------------ //

    public SpriteGraphic(String name, int x_position, int y_position) {

        this.name = name;

        this.x_position = x_position;

        this.y_position = y_position;

        this.fileManager = new FileManager();

        initAnimation();
    }

    public SpriteGraphic(String name) {
        this(name, 0, 0);
    }

    protected void initAnimation() {
        // INITIALIZE ANIMATION //
        this.animation = new Animation();

        for (String state : animation.STATES) {
            // TODO: dodac wyjatki
            this.animation.AddAnimationState(state, this.fileManager.readImage(name, state), 1);
        }
    }

    // METHODS ----------------------------- //

    public void setPosition(int x_position, int y_position) {
        this.x_position = x_position;
        this.y_position = y_position;
    }

    public void render(Graphics g) {
        g.drawImage(this.animation.getCurrentImage(), x_position, y_position, null);
    }

}
