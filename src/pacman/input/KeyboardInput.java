package pacman.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    private boolean[] keys;

    public KeyboardInput() {
        keys = new boolean[256];
    }

    public synchronized boolean keyDown(int keyCode) {
        return keys[ keyCode ];
    }

    public synchronized void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if( keyCode >= 0 && keyCode < keys.length ) {
            keys[ keyCode ] = true;
        }
    }

    public synchronized void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if( keyCode >= 0 && keyCode < keys.length ) {
            keys[ keyCode ] = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}

