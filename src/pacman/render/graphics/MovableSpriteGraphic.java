package pacman.render.graphics;

import pacman.manager.file.FileManager;

import java.awt.*;

public class MovableSpriteGraphic extends SpriteGraphic {

    // FIELDS ------------------------------ //

    protected MovableAnimation animation;

    // CONSTRUCTORS ------------------------ //

    public MovableSpriteGraphic(String name, int x_position, int y_position) {
        super(name, x_position, y_position);
    }

    @Override
    protected void initAnimation() {
        // INITIALIZE ANIMATION //
        this.animation = new MovableAnimation();

        for (String state : animation.STATES) {
            // TODO: dodac wyjatki
            for (Integer animationState: animation.ANIMATION_STATES) {
                this.animation.AddAnimationState(state, fileManager.readImage(name, state, animationState), animationState);
            }

        }

        this.imgHeight = animation.getCurrentImage().getHeight(null);
        this.imgWidth = animation.getCurrentImage().getWidth(null);
    }

    public void render(Graphics g) {
        g.drawImage(this.animation.getCurrentImage(), x_position, y_position, null);
    }

}
