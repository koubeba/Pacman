package pacman.game.instance.GridMap;

import javax.swing.*;
import java.awt.*;

public class Tile {

    // FIELDS ------------------------- //

    public final boolean open;
    public final PossibleMovement possibleMovement;

    // CONSTRUCTORS ------------------- //

    public Tile(boolean open, boolean Up, boolean Down, boolean Left, boolean Right) {
        this.open = open;

        // IF THE TILE IS CLOSED (WALL) ALL DIRECTIONS ARE CLOSED //
        if (!this.open) {
            this.possibleMovement = new PossibleMovement(false);
        } else {
            this.possibleMovement = new PossibleMovement(Up, Down, Left, Right);
        }
    }

    // DEFAULT CONSTRUCTOR FOR A WALL //

    public Tile() {
        this.open = false;
        this.possibleMovement = new PossibleMovement(false);
    }

    // METHODS --------------------- //

    public String toString() {
        return "UP: " + this.isUp() + " DOWN " + this.isDown() + " LEFT: " + this.isLeft() + " RIGHT: " + this.isRight();
    }

    public String toStringNonVerbose() {
        String Up = this.isUp() ? "1" : "0";
        String Down = this.isDown() ? "1" : "0";
        String Left = this.isLeft() ? "1" : "0";
        String Right = this.isRight() ? "1" : "0";

        String Open = this.isOpen() ? "1" : "0";

        return Left;

    }

    // GETTERS AND SETTERS --------- //

    public boolean isOpen() {
        return open;
    }

    public boolean isUp() {
        return this.possibleMovement.isUp();
    }

    public boolean isDown() {
        return this.possibleMovement.isDown();
    }

    public boolean isLeft() {
        return this.possibleMovement.isLeft();
    }

    public boolean isRight() {
        return this.possibleMovement.isRight();
    }
}
