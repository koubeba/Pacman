package pacman;

import pacman.game.GameManager;
import pacman.render.RenderManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pacman {

    //private RenderManager renderFrame;

    private final GameManager gameManager;

    public Pacman() {

        //renderFrame = new RenderManager();

        this.gameManager = new GameManager();
    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        //pacman.renderFrame.initRun();

        // ADDING LISTENERS //

        //pacman.renderFrame.addKeyListener(pacman.gameManager.getKeyListener());

        /*
        pacman.renderFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                pacman.renderFrame.onWindowClosing();
            }
        });
        */

        // RUN //

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pacman.gameManager.create();
            }
        });
    }
}