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
    Collector testSolidObject;
    Collectible dot;

    // TODO: add player

    // CONSTRUCTORS ----------------- //

    public InstanceManager() {
        this.testSolidObject = new Collector("test", 0, 0, 100);
        this.dot = new Collectible("dot", 100, 100, 1);
        this.dot.addCollector(this.testSolidObject);
    }

    public void checkAllCollisions() {
        if (this.dot != null) this.testSolidObject.checkCollision(this.dot);
    }

    public void renderAll(Graphics g) {
        removeAllInactive();
        if (testSolidObject != null) this.testSolidObject.render(g);
        if (this.dot != null) this.dot.render(g);
    }

    public void receiveInput(MOVEMENT_INPUT input, double delta) {
        testSolidObject.move(input, delta);
    }

    public void removeAllInactive() {
        testSolidObject = testSolidObject.isActive() ? testSolidObject : null;
        if (this.dot != null) dot = dot.isActive() ? dot : null;
    }

}
