package pacman.game.instance;

/*
    All the levels contain:
    - Pacman
 */

/*
    TEST: only one solid object
 */


import pacman.game.GAME_STATE;
import pacman.game.GameManager;
import pacman.game.levels.Level;

import java.awt.*;

public final class InstanceManager {

    // FIELDS ----------------------- //

    private Level level;

    private final GameManager gameManager;

    // CONSTRUCTORS ----------------- //

    public InstanceManager(GameManager gameManager) {

        this.gameManager = gameManager;

        this.level = new Level(this.gameManager);
    }

    public void checkAllCollisions() {
        level.checkAllCollisions();
    }

    public void renderAll(Graphics g) {
        level.renderAll(g);
    }

    public void moveAll() {
        level.moveAll();
    }

    public void receiveInput(MOVEMENT_INPUT input) {
        level.receiveInput(input);
    }

    public void restartLevel() {
        if (this.level.getPlayerRestart()) {
            this.gameManager.decLives();
            this.level = new Level(this.gameManager);
        }
    }

    public void reinitialize() {
        this.level = new Level(this.gameManager);
    }

    public boolean isPowerUp() {
        return this.level.isPowerUp();
    }

    public void deactivatePowerUp() {
        this.level.deactivatePowerUp();
    }

    public void activatePowerUp() {
        this.level.activatePowerUp();
    }
}
