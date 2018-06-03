package pacman.game;

import pacman.game.instance.InstanceManager;
import pacman.input.InputManager;
import pacman.render.RenderManager;

import java.awt.*;
import java.awt.event.KeyListener;

public class GameManager {

    // FIELDS --------------------------------------- //

    private final InstanceManager instanceManager;
    private final InputManager inputManager;
    private final RenderManager renderManager;

    private int lives = 3;

    // THREAD //
    private volatile boolean running;
    private Thread gameThread;

    private GAME_STATE gameState;

    // CONSTRUCTORS --------------------------------- //

    public GameManager() {
        this.instanceManager = new InstanceManager(this);
        this.inputManager = new InputManager(this.instanceManager);
        this.renderManager = new RenderManager();
        this.gameState = GAME_STATE.NORMAL;

        this.renderManager.initRun();
        this.renderManager.addKeyListener(getKeyListener());
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

                this.instanceManager.restartLevel();

                if (this.lives == 0) {
                    this.gameState = GAME_STATE.END;
                }
                break;
            case END:
                break;
        }
    }

    public void renderEndScreen(Graphics g) {
        g.drawString("YOU LOSE :(", 100, 100);
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

    public int getLives() {
        return lives;
    }

    public void decLives() {
        this.lives--;
    }


}
