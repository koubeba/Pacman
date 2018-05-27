package pacman.game;

public class Damageable extends Movable implements pacman.game.interfaces.Damageable {

    // FIELDS ------------------------------------ //

    // CONSTRUCTORS ------------------------------ //

    public Damageable(String name, int x_position, int y_position, int speed) {
        super(name, x_position, y_position, speed);
    }

    // METHODS ----------------------------------- //

    @Override
    public void beDamaged() {
        this.die();
    }

    @Override
    public void damageObject(pacman.game.interfaces.Damageable damageable) {
        damageable.beDamaged();
    }
}
