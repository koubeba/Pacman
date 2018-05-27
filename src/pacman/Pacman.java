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

        // RUN //

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pacman.gameManager.getInputManager().create();
                pacman.gameManager.getRenderManager().create(pacman.gameManager.getInstanceManager(), pacman.gameManager);
            }
        });
    }
}