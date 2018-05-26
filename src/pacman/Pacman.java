package pacman;

import pacman.game.GameManager;
import pacman.game.InstanceManager;
import pacman.input.InputManager;
import pacman.render.RenderFrame;
import pacman.render.RenderManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pacman {

    private RenderFrame renderFrame;

    private final InstanceManager instanceManager;
    private final RenderManager renderManager;
    private final InputManager inputManager;

    private final GameManager gameManager;

    public Pacman() {

        renderFrame = new RenderFrame();

        instanceManager = new InstanceManager();
        renderManager = new RenderManager();
        inputManager = new InputManager(instanceManager);

        gameManager = new GameManager(instanceManager, renderManager);
    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        pacman.renderFrame.initRun();

        // ADDING LISTENERS //

        pacman.renderFrame.addKeyListener(pacman.inputManager.keyboardInput);

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
                pacman.inputManager.create();
                pacman.renderFrame.create(pacman.instanceManager, pacman.renderManager);

            }
        });
    }
}