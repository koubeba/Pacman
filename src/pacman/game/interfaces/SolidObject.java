package pacman.game.interfaces;

import java.awt.*;

public interface SolidObject {
    // Render the SpriteGraphic component
    public void render(Graphics g);
    public void checkCollision(pacman.game.SolidObject collider);
    public void die();
}
