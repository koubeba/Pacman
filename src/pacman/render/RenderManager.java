package pacman.render;

import pacman.game.instance.InstanceManager;

import java.awt.*;

public class RenderManager {

    public void renderInstances(InstanceManager instanceManager, Graphics graphics) {
        instanceManager.renderAll(graphics);
    }

}
