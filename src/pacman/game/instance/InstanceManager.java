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

public class InstanceManager {

    // FIELDS ----------------------- //

    private Level level;

    private final GameManager gameManager;

    // TODO: add player

    // TODO: zrobić tu porządek!!!

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

    public void moveAll(double delta) {
        level.moveAll(delta);
    }

    public void receiveInput(MOVEMENT_INPUT input) {
        level.receiveInput(input);
    }

    public void removeAllInactive() {
        level.removeAllInactive();
    }

    public void restartLevel() {
        if (this.level.getPlayerRestart()) {
            this.gameManager.decLives();
            this.level = new Level(this.gameManager);
        }
    }
}
