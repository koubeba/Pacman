package pacman.game.instance;

import pacman.game.instance.interfaces.Collector;

public class Collectible extends SolidObject implements pacman.game.instance.interfaces.Collectible {

    // FIELDS ------------------------------- //

    private Collector collector;
    private int points;

    // CONSTRUCTORS ------------------------- //

    public Collectible(String name, int x_position, int y_position, int points) {
        super(name, x_position, y_position);
        this.points = points;
    }

    // METHODS ------------------------------ //

    @Override
    public void addCollector(Collector collector) {
        this.collector = collector;
    }

    @Override
    public void beCollected() {
        collector.collect(this, this.points);
        this.die();
    }
}
