package pacman;

import pacman.render.RenderFrame;

import javax.swing.*;

public class Pacman {

    private RenderFrame renderFrame;

    public Pacman() {
        renderFrame = new RenderFrame();
    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        pacman.renderFrame.initRun();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                pacman.renderFrame.create();
            }
        });
    }
}