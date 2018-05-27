package pacman.game.instance.interfaces;

public interface Collector extends Movable {
    public void collect(Collectible collectible, int points);
}
