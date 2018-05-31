package pacman.game.instance.GridMap;

public class PossibleMovement {

    // FIELDS ------------------------- //

    private final boolean Up, Down, Left, Right;

    // CONSTRUCTORS ------------------- //

    public PossibleMovement(boolean open) {

        // IF THE TILE IS OPEN, ALL MOVES ARE POSSIBLE BY DEFAULT //

        if (open) {
            this.Up = this.Down = this.Left = this.Right = true;
        } else {
            this.Up = this.Down = this.Left = this.Right = false;
        }
    }

    public PossibleMovement(boolean Up, boolean Down, boolean Left, boolean Right) {
        this.Up = Up;
        this.Down = Down;
        this.Left = Left;
        this.Right = Right;
    }

    // GETTERS AND SETTERS ------------ //


    public boolean isUp() {
        return Up;
    }

    public boolean isDown() {
        return Down;
    }

    public boolean isLeft() {
        return Left;
    }

    public boolean isRight() {
        return Right;
    }
}
