package pacman.game.instance.interfaces;

public interface Damageable extends Movable {
    // make this object damaged
    public void beDamaged();
    // make other object damaged
    public void damageObject(Damageable damageable);
}
