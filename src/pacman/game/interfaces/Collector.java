package pacman.game.interfaces;

public interface Collector extends Movable {
    public void collect(Collectible collectible, int points);
}
