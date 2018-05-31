package pacman;

public class Vector2 {

    // FIELDS ---------------------- //

    private int x, y;

    // CONSTRUCTORS ---------------- //

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(int value) {
        this.x = this.y = value;
    }

    public Vector2() {
        this(0);
    }

    // METHODS ---------------------- //

    public Vector2 add (Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 multiply (Vector2 other) {
        return new Vector2(this.x * other.x, this.y * other.y);
    }

    public Vector2 divide (Vector2 other) {
        return new Vector2(this.x / other.x, this.y / other.y);
    }

    // GETTERS AND SETTERS --------- //


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
