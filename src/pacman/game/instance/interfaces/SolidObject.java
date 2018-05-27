package pacman.game.instance.interfaces;

import java.awt.*;

public interface SolidObject {
    // Render the SpriteGraphic component
    public void render(Graphics g);
    public void checkCollision(pacman.game.instance.SolidObject collider);
    public void die();
}
