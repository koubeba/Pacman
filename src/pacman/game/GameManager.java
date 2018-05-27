package pacman.game;

import pacman.input.InputManager;
import pacman.render.RenderFrame;
import pacman.render.RenderManager;

import java.awt.*;
import java.awt.event.KeyListener;

public class GameManager {
    // there should be shit like current level, state, points

    // FIELDS --------------------------------------- //

    private final InstanceManager instanceManager;
    private final RenderManager renderManager;
    private final InputManager inputManager;

    private GAME_STATE gameState;

    // CONSTRUCTORS --------------------------------- //

    public GameManager() {
        this.instanceManager = new InstanceManager(this);
        this.renderManager = new RenderManager();
        this.inputManager = new InputManager(this.instanceManager);
    }

    // GAME LOOP ------------------------------------ //

    public void loop() {
    }

    // GETTERS AND SETTERS -------------------------- //


    public InstanceManager getInstanceManager() {
        return instanceManager;
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public KeyListener getKeyListener() {
        return this.inputManager.keyboardInput;
    }

    public GAME_STATE getGameState() {
        return gameState;
    }

    public void setGameState(GAME_STATE gameState) {
        this.gameState = gameState;
    }
}
