package pacman.render;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import pacman.game.GameManager;
import pacman.game.instance.InstanceManager;
import pacman.utils.*;

import static java.lang.Thread.sleep;

/**
 *  The actual rendering will take place in the render manager.
 */

public final class RenderManager extends JFrame implements Runnable {

    // FIELDS ------------------------ //

        // THREAD //
        private volatile boolean running;
        private Thread gameThread;

        // RENDER BUFFERING //
        private BufferStrategy bufferStrategy;

        // REFERENCES TO OTHER MANAGERS //
        private InstanceManager instanceManager;

        private GameManager gameManager;

    // CONSTS ------------------------ //

        private static int WIDTH = 400;
        private static int HEIGHT = 400;
        private static String TITLE = "Render Thread";
        private static Color BG_COLOR = Color.BLACK;
        private static boolean IGNORE_REPAINT = true;
        private static int BUFFER_INT = 2;

    // CONSTRUCTORS ------------------ //

    // METHODS ----------------------- //

    public void create(GameManager gameManager) {

        // MANAGER INITIALIZATION //

        this.gameManager = gameManager;

        this.instanceManager = this.gameManager.getInstanceManager();

        // CANVAS INITIALIZATION //

            Canvas canvas = new Canvas();
            canvas.setSize(WIDTH, HEIGHT);
            canvas.setBackground(BG_COLOR);
            getContentPane().add(canvas);

            setTitle(TITLE);

            // The actual painting won't happen in this frame, therefore we can ignore repaint.

            setIgnoreRepaint(IGNORE_REPAINT);

            // Assure the frame is big enough to contain all graphic objects

            pack();

            setVisible(true);

            // DOUBLE BUFFER INITIALIZATION //

            canvas.createBufferStrategy(BUFFER_INT);
            bufferStrategy = canvas.getBufferStrategy();

            // Request focus so that the keyboard input can be caught and processed

            canvas.setFocusable(true);
            canvas.requestFocus();

            // Start the game thread

            gameThread = new Thread(this);
            gameThread.start();
    }

    public void run() {

        running = true;

        while (running) {

            // Request focus so that the keyboard input can be caught and processed

            this.requestFocus();

            gameLoop();
        }
    }

    private void gameLoop() {
        do {
            do {

                // Initialize graphics as null (assure that there are no "traces" of past iterations)

                Graphics g = null;

                try {

                    // Get a new buffered context

                    g = bufferStrategy.getDrawGraphics();

                    // Clear the frame

                    g.clearRect(0, 0, WIDTH, HEIGHT);

                    gameManager.loop();

                    try {
                        Thread.sleep( 10 );
                    } catch( InterruptedException ex ) { }

                    // Render all graphics on the buffer

                    render(g);

                } finally {
                    if (g != null) {
                        // If nothing is buffered, dispose (free the memory)
                        g.dispose();
                    }
                }

            } while (bufferStrategy.contentsRestored());

            // show the buffered rendered graphics

            bufferStrategy.show();

        } while (bufferStrategy.contentsLost());
    }

    private void render(Graphics graphics) {

        // draw all instances
        switch (this.gameManager.getGameState()) {
            case NORMAL:
            case POWERUP:
                renderInstances(instanceManager, graphics);
                break;
            case END:
                gameManager.renderEndScreen(graphics);
                break;
        }

    }

    public void onWindowClosing() {
        try {

            System.err.println("Stopping Rendering Thread...");
            running = false;

            gameThread.join();

            System.err.println("Stopped");

        } catch (InterruptedException ex) {

            ex.printStackTrace();
            // handle the exception
        }

        System.exit(0);
    }

    //todo: is that necessary?

    public void initRun() {

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
            }
        });
    }

    public void renderInstances(InstanceManager instanceManager, Graphics graphics) {

        instanceManager.renderAll(graphics);

    }

    // HELPER METHODS ----------------------------------- //

    private void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            // do something
        }
    }
}

/*
    In order to prevent application freeze,
    a double buffer strategy is used.
 */