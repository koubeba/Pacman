package pacman.render.graphics;

import pacman.file.FileManager;

import java.awt.*;

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

    protected int imgWidth = 0;
    protected int imgHeight = 0;

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
            for (Integer animationState : animation.ANIMATION_STATES) {
                this.animation.AddAnimationState(state, this.fileManager.readImage(name, state, animationState), animationState);
            }
        }

        this.imgHeight = animation.getCurrentImage().getHeight(null);
        this.imgWidth = animation.getCurrentImage().getWidth(null);

    }

    // METHODS ----------------------------- //

    public void setPosition(int x_position, int y_position) {
        this.x_position = x_position;
        this.y_position = y_position;
    }

    public void render(Graphics g) {
        g.drawImage(this.animation.getCurrentImage(), x_position, y_position, null);
    }

    public double getImgWidth() {
        //return this.animation.getCurrentImage().getWidth(null);
        return this.imgWidth;
    }

    public double getImgHeight() {
        //return this.animation.getCurrentImage().getHeight(null);
        return this.imgHeight;
    }

}
