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
    SolidObject testSolidObject;

    // CONSTRUCTORS ----------------- //

    public InstanceManager() {
        this.testSolidObject = new SolidObject("test");
    }

    public void renderAll(Graphics g) {
        this.testSolidObject.render(g);
    }

}
