package pacman;

import java.awt.geom.Arc2D;

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

    public Vector2 subtract(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 multiply (Vector2 other) {
        return new Vector2(this.x * other.x, this.y * other.y);
    }

    public Vector2 divide (Vector2 other) {
        return new Vector2(this.x / other.x, this.y / other.y);
    }

    public Vector2 divideModulo (Vector2 other) {
        return new Vector2(this.x % other.x, this.y % other.y);
    }

    @Override
    public int hashCode() {
        return 31 + 256*x + y;
    }

    @Override
    public boolean equals(Object o) {
        return (((Vector2) o).getX() == this.x) && (((Vector2) o).getY() == this.y);
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
