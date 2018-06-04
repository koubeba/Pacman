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
            this.loop();
        }
    }

    private void loop() {

        keyboardInput.poll();

        instanceManager.moveAll();

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

    public void stop() {
            System.err.println("Stopping Input Thread...");
            running = false;
            try {
                this.thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.err.println("Stopped");
    }
}
