package pacman.game;

import pacman.game.instance.InstanceManager;
import pacman.input.InputManager;
import pacman.render.RenderManager;

import java.awt.*;
import java.awt.event.KeyListener;

public final class GameManager {

    // FIELDS --------------------------------------- //

    private final InstanceManager instanceManager;
    private final InputManager inputManager;
    private final RenderManager renderManager;

    private int lives = 3;

    private GAME_STATE gameState;

    // TIME //
    private long currentTime;
    private long previousTime;

    // CONSTRUCTORS --------------------------------- //

    public GameManager() {
        this.instanceManager = new InstanceManager(this);
        this.inputManager = new InputManager(this.instanceManager);
        this.renderManager = new RenderManager();
        this.gameState = GAME_STATE.NORMAL;

        this.renderManager.initRun();
        this.renderManager.addKeyListener(getKeyListener());

        this.currentTime = System.currentTimeMillis();
        this.previousTime = System.currentTimeMillis();
    }

    // GAME LOOP ------------------------------------ //

    public void loop() {
        switch(gameState) {
            case NORMAL:
                //check all collisions
                this.instanceManager.checkAllCollisions();

                this.instanceManager.restartLevel();

                if (this.lives == 0) {
                    this.gameState = GAME_STATE.END;
                }

                if (this.instanceManager.isPowerUp()) {
                    currentTime = System.currentTimeMillis();
                    previousTime = System.currentTimeMillis();
                    this.gameState = GAME_STATE.POWERUP;
                    this.instanceManager.deactivatePowerUp();
                }

                currentTime = System.currentTimeMillis();
                if (currentTime - previousTime > 10000) {
                    currentTime = System.currentTimeMillis();
                    previousTime = System.currentTimeMillis();

                    this.instanceManager.activatePowerUp();
                }
                break;
            case POWERUP:
                this.instanceManager.checkAllCollisions();

                this.instanceManager.restartLevel();

                currentTime = System.currentTimeMillis();
                if (currentTime - previousTime > 5000) {
                    currentTime = System.currentTimeMillis();
                    previousTime = System.currentTimeMillis();

                    this.gameState = GAME_STATE.NORMAL;
                }
                break;
            case END:
                currentTime = System.currentTimeMillis();
                if (currentTime - previousTime > 3000) {
                    currentTime = System.currentTimeMillis();
                    previousTime = System.currentTimeMillis();

                    this.gameState = GAME_STATE.NORMAL;
                    this.reinitialize();
                }
                break;
        }
    }

    public void renderEndScreen(Graphics g) {
        g.setColor(Color.RED);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        g.drawString("YOU LOSE", 100, 100);
    }

    // HELPER METHODS ------------------------------- //

    public void reinitialize() {
        this.lives = 3;
        this.instanceManager.reinitialize();
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
