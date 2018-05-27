package pacman.game.interfaces;

public interface Collectible extends SolidObject {
    public void addCollector(Collector collector);
    public void beCollected();
}
