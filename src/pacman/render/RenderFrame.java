package pacman.render;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import pacman.game.InstanceManager;
import pacman.utils.*;

import static java.lang.Thread.sleep;

public class RenderFrame extends JFrame implements Runnable {

    // FIELDS ------------------------ //
    private volatile boolean running;
    private Thread gameThread;
    private FrameRate frameRate;
    private BufferStrategy bufferStrategy;

    private InstanceManager instanceManager;
    private RenderManager renderManager;

    // CONSTS ------------------------ //
    public static int WIDTH = 320;
    public static int HEIGHT = 240;
    public static String TITLE = "Render Thread";
    public static Color BG_COLOR = Color.BLACK;
    public static boolean IGNORE_REPAINT = true;
    public static int BUFFER_INT = 2;

    // CONSTRUCTORS ------------------ //
    public RenderFrame() {
        frameRate = new FrameRate();
    }

    // METHODS ----------------------- //
    public void create(InstanceManager instanceManager, RenderManager renderManager) {

        // MANAGER INITIALIZATION //
        this.instanceManager = instanceManager;
        this.renderManager = renderManager;

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

        // Start the game thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        running = true;
        frameRate.initialize();
        while (running) {
            // render things
            gameLoop();
        }
    }

    private void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            // do something
        }
    }

    public void gameLoop() {
        do {
            do {
                // Initialize graphics as null (assure that there are no "traces" of past iterations)
                Graphics g = null;
                try {
                    // Get a new buffered context
                    g = bufferStrategy.getDrawGraphics();
                    // TODO: replace by WIDTH/HEIGHT?

                    // Clear the frame
                    g.clearRect(0, 0, getWidth(), getHeight());

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
        frameRate.calculate();
        // draw graphics
        renderManager.renderInstances(instanceManager, graphics);
    }

    public void onWindowClosing() {
        try {
            System.err.println("Stopping Thread...");
            running = false;
            gameThread.join();
            System.err.println("Stopped");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            // handle the exception
        }
        System.exit(0);
    }

    public void initRun() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
            }
        });
    }
}

/*
    In order to prevent application freeze,
    a double buffer strategy is used.
 */