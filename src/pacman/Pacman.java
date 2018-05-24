package pacman;

import pacman.game.GameManager;
import pacman.game.InstanceManager;
import pacman.render.RenderFrame;
import pacman.render.RenderManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pacman {

    private RenderFrame renderFrame;

    private final InstanceManager instanceManager;
    private final RenderManager renderManager;

    private final GameManager gameManager;

    public Pacman() {

        renderFrame = new RenderFrame();

        instanceManager = new InstanceManager();
        renderManager = new RenderManager();

        gameManager = new GameManager(instanceManager, renderManager);
    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        pacman.renderFrame.initRun();



        pacman.renderFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                pacman.renderFrame.onWindowClosing();
            }
        });

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pacman.renderFrame.create(pacman.instanceManager, pacman.renderManager);
            }
        });
    }
}