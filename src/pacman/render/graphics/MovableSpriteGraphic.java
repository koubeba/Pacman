package pacman.render.graphics;

import pacman.manager.file.FileManager;

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
            this.animation.AddAnimationState(state, fileManager.readImage(name, state));
        }
    }

}
