package pacman.game;

import pacman.render.RenderFrame;
import pacman.render.RenderManager;

import java.awt.*;

public class GameManager {
    // there should be shit like current level, state, points n shit

    // FIELDS --------------------------------------- //

    private final InstanceManager instanceManager;
    private final RenderManager renderManager;

    // CONSTRUCTORS --------------------------------- //

    public GameManager(InstanceManager instanceManager, RenderManager renderManager) {
        this.instanceManager = instanceManager;
        this.renderManager = renderManager;
    }

    // GAME LOOP ------------------------------------ //

    public void loop() {
    }

}
