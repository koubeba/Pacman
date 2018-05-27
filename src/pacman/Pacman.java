package pacman;

import pacman.game.GameManager;
import pacman.render.RenderFrame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pacman {

    private RenderFrame renderFrame;

    private final GameManager gameManager;

    public Pacman() {

        renderFrame = new RenderFrame();

        this.gameManager = new GameManager();
    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        pacman.renderFrame.initRun();

        // ADDING LISTENERS //

        pacman.renderFrame.addKeyListener(pacman.gameManager.getKeyListener());

        pacman.renderFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                pacman.renderFrame.onWindowClosing();
            }
        });

        // RUN THREADS //

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pacman.gameManager.getInputManager().create();
                pacman.renderFrame.create(pacman.gameManager.getInstanceManager(), pacman.gameManager.getRenderManager(), pacman.gameManager);
            }
        });
    }
}