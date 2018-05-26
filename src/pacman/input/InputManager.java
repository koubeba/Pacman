package pacman.input;

import pacman.game.InstanceManager;
import pacman.game.MOVEMENT_INPUT;

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
        if (keyboardInput.keyDown(KeyEvent.VK_D)) {
            instanceManager.receiveInput(MOVEMENT_INPUT.RIGHT);
        }
        try {
            Thread.sleep( 10 );
        } catch( InterruptedException ex ) { }
    }
}
