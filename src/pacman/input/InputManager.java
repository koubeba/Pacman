package pacman.input;

import pacman.game.InstanceManager;
import pacman.game.MOVEMENT_INPUT;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.*;
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
        if (keyboardInput.keyDown(KeyEvent.VK_D)) {
            instanceManager.receiveInput(MOVEMENT_INPUT.RIGHT, delta);
        }
        try {
            Thread.sleep( 10 );
        } catch( InterruptedException ex ) { }
    }
}
