package pacman.game.instance;

public final class PowerUp extends Collectible {

    // FIELDS ------------------------------- //

    private boolean PowerUpMode = false;

    // CONSTRUCTORS ------------------------- //

    public PowerUp(String name, int x_position, int y_position, int points) {
        super(name, x_position, y_position, points);
    }

    // METHODS ------------------------------ //

    @Override
    public void beCollected() {
        super.beCollected();
        this.PowerUpMode = true;
    }

    // SETTERS AND GETTERS ----------------- //

    public boolean isPowerUpMode() {
        return this.PowerUpMode;
    }

    public void setPowerUpMode(boolean powerUpMode) {
        PowerUpMode = powerUpMode;
    }
}
