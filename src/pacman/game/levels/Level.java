package pacman.game.levels;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import pacman.game.GameManager;
import pacman.game.instance.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {

    // FIELDS -------------------- //

        // WALLS //

        private List<SolidObject> walls;

        // PLAYER //

        private Player player;

        // GHOSTS //

        private Blinky blinky;
        private Inky inky;
        private Pinky pinky;
        private Clyde clyde;

        // COLLECTABLES //

        private List<Collectible> dots;
        //TODO: add cherries

        // REFERENCES //

        private GameManager gameManager;

    // CONSTRUCTOR -----------------//

    //TODO: add some sort of prefabs
    public Level(GameManager gameManager) {

        // SAVE REFERENCE //

        this.gameManager = gameManager;

        // INITIALIZE LISTS //

        walls = new ArrayList<SolidObject>();
        dots = new ArrayList<Collectible>();

        // INITIALIZE PLAYER //

        this.player = new Player("Pacman", 0, 0, 100, gameManager);

        // INITIALIZE GHOSTS //

        this.blinky = new Blinky("Blinky", 100, 100, 100, this.player);
        this.inky = new Inky("Inky", 100, 100, 100, this.player);
        this.pinky = new Pinky("Pinky", 100, 100, 100, this.player);
        this.clyde = new Clyde("Clyde", 100, 100, 100, this.player);

        // ADD WALLS //

        this.walls.add(new SolidObject("Wall", 0, 25));
        this.walls.add(new SolidObject("Wall", 25, 25));
        this.walls.add(new SolidObject("Wall", 50,  25));
        this.walls.add(new SolidObject("Wall", 75,  25));
        this.walls.add(new SolidObject("Wall", 100,  25));
        this.walls.add(new SolidObject("Wall", 100, 50));
        this.walls.add(new SolidObject("Wall", 100, 100));
        this.walls.add(new SolidObject("Wall", 100, 125));
        this.walls.add(new SolidObject("Wall", 100, 150));
        this.walls.add(new SolidObject("Wall", 100, 175));
        this.walls.add(new SolidObject("Wall", 100, 200));
        this.walls.add(new SolidObject("Wall", 100, 225));
        this.walls.add(new SolidObject("Wall", 100, 250));
        this.walls.add(new SolidObject("Wall", 100, 275));
        this.walls.add(new SolidObject("Wall", 100, 300));

        // ADD DOTS //

        Collectible dot = new Collectible("Dot", 10, 20, 1);
        dot.addCollector(this.player);
        this.dots.add(dot);

    }

    // METHODS --------------------- //

    public void checkAllCollisions() {
        // Check collisions between players and stuff.

        // CHECK PLAYER COLLISION //

        //TODO: add wall collision checking

            // CHECK COLLISIONS WITH COLLECTIBLES //

            for (Collectible dot : dots) {
                this.player.checkCollectibleCollision(dot);
            }

            // CHECK COLLISIONS WITH GHOSTS //

            this.player.checkGhostCollision(this.blinky, this.gameManager.getGameState());
            this.player.checkGhostCollision(this.inky, this.gameManager.getGameState());
            this.player.checkGhostCollision(this.pinky, this.gameManager.getGameState());
            this.player.checkGhostCollision(this.clyde, this.gameManager.getGameState());

            // CHECK COLLISIONS WITH WALLS //

            this.player.resetCollisionFlags();

            for (SolidObject wall: walls) {
                this.player.checkWallCollision(wall);
            }
    }

    public void renderAll(Graphics g) {

        // RENDER WALLS //

        for (SolidObject wall: walls) {
            wall.render(g);
        }

        // RENDER PLAYER //

        this.player.render(g);

        // RENDER GHOSTS //

        this.blinky.render(g);
        this.inky.render(g);
        this.pinky.render(g);
        this.clyde.render(g);

        // RENDER COLLECTIBLES //

        for (Collectible dot: dots) {
            if (dot.isActive()) dot.render(g);
        }

    }

    public void moveAll(double delta) {

        // MOVE THE PLAYER //

        this.player.move(delta);

        // MOVE THE GHOSTS //

        this.blinky.move(delta);
        this.inky.move(delta);
        this.pinky.move(delta);
        this.clyde.move(delta);
    }

    public void receiveInput(MOVEMENT_INPUT input) {
        this.player.switchDirection(input);
    }

    public void removeAllInactive() {

        // TODO: fix

        /*
        // REMOVE THE INACTIVE DOTS //
        for (Collectible dot : dots) {
            if (!dot.isActive()) {
                dots.remove(dot);
            }
        }
        */
    }

}
