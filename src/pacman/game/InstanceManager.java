package pacman.game;

/*
    All the levels contain:
    - Pacman
 */

/*
    TEST: only one solid object
 */


import java.awt.*;

public class InstanceManager {

    // FIELDS ----------------------- //
    Movable testSolidObject;

    // TODO: add player

    // CONSTRUCTORS ----------------- //

    public InstanceManager() {
        this.testSolidObject = new Movable("test", 0, 0, 100);
    }

    public void renderAll(Graphics g) {
        this.testSolidObject.render(g);
    }

    public void receiveInput(MOVEMENT_INPUT input, double delta) {
        testSolidObject.move(input, delta);
    }

}
