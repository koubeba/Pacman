package pacman.input;

import pacman.game.instance.InstanceManager;
import pacman.game.instance.MOVEMENT_INPUT;

import java.awt.event.KeyEvent;

/**
 * @author Maja Jabłońska
 */

public class InputManager implements Runnable {

    // FIELDS ------------------------------------------- //

    public volatile boolean running;
    private Thread thread;
    public KeyboardInput keyboardInput;

    private InstanceManager instanceManager;

    private long curTime = System.nanoTime();
    private long lastTime = curTime;
    private double nsPerSeconds;

    // CONSTRUCTORS ------------------------------------- //

    public InputManager(InstanceManager instanceManager) {
        this.keyboardInput = new KeyboardInput();

        this.instanceManager = instanceManager;
    }

    // METHODS ------------------------------------------- //

    public void create() {
        // INIT THREAD //
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        this.running = true;
        while (running) {
            curTime = System.nanoTime();
            nsPerSeconds = curTime - lastTime;
            this.loop(nsPerSeconds / 1.0E9);
            lastTime = curTime;
        }
    }

    private void loop(double delta) {

        keyboardInput.poll();

        instanceManager.moveAll(delta);

        if (keyboardInput.keyDown(KeyEvent.VK_D)) {
            instanceManager.receiveInput(MOVEMENT_INPUT.RIGHT);
        }
        if (keyboardInput.keyDown(KeyEvent.VK_A)) {
            instanceManager.receiveInput(MOVEMENT_INPUT.LEFT);
        }
        if (keyboardInput.keyDown(KeyEvent.VK_W)) {
            instanceManager.receiveInput(MOVEMENT_INPUT.UP);
        }
        if (keyboardInput.keyDown(KeyEvent.VK_S)) {
            instanceManager.receiveInput(MOVEMENT_INPUT.DOWN);
        }
        try {
            Thread.sleep( 10 );
        } catch( InterruptedException ex ) { }
    }
}
