package pacman.game.instance;

/*
    All the levels contain:
    - Pacman
 */

/*
    TEST: only one solid object
 */


import pacman.game.GameManager;

import java.awt.*;

public class InstanceManager {

    // FIELDS ----------------------- //

    private Player testSolidObject;
    //private Ghost Clyde;

    private final GameManager gameManager;

    // TODO: add player

    // TODO: zrobić tu porządek!!!

    // CONSTRUCTORS ----------------- //

    public InstanceManager(GameManager gameManager) {
        this.testSolidObject = new Player("test", 0, 0, 100, gameManager);

        this.gameManager = gameManager;
    }

    public void checkAllCollisions() {
    }

    public void renderAll(Graphics g) {
        if (testSolidObject != null) this.testSolidObject.render(g);
    }

    public void moveAll(double delta) {
        testSolidObject.move(delta);

    }

    public void receiveInput(MOVEMENT_INPUT input) {
        testSolidObject.switchDirection(input);
    }

    public void removeAllInactive() {
        testSolidObject = testSolidObject.isActive() ? testSolidObject : null;
    }
}
