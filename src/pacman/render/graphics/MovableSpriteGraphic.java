package pacman.render.graphics;

import pacman.manager.file.FileManager;

public class MovableSpriteGraphics extends SpriteGraphic {

    // CONSTRUCTORS ------------------------ //

    public MovableSpriteGraphics(String name, int x_position, int y_position) {

        this.name = name;

        // INITIALIZE ANIMATION //
        this.animation = new MovableAnimation();

        for (String state : animation.STATES) {
            // TODO: dodac wyjatki
            this.animation.AddAnimationState(state, fileManager.readImage(name, state));
        }

        this.x_position = x_position;

        this.y_position = y_position;

    }

}
