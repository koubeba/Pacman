package pacman.game;

import pacman.game.instance.InstanceManager;
import pacman.input.InputManager;
import pacman.render.RenderManager;

import java.awt.event.KeyListener;

public class GameManager implements Runnable {
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
        this.gameState = GAME_STATE.NORMAL;
    }

    // GAME LOOP ------------------------------------ //

    public void loop() {

        switch(gameState) {
            case NORMAL:
            case POWERUP:
                //check all collisions
                this.instanceManager.checkAllCollisions();

                // remove all inactive instances
                this.instanceManager.removeAllInactive();
                break;
            case END:
                break;
        }


    }

    // RUNNABLE ------------------------------------- //

    @Override
    public void run() {

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
