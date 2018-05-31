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

        this.walls.add(new SolidObject("Wall", 25, 25));
        this.walls.add(new SolidObject("Wall", 50, 25));
        this.walls.add(new SolidObject("Wall", 75, 25));
        this.walls.add(new SolidObject("Wall", 100, 25));
        this.walls.add(new SolidObject("Wall", 100, 50));
        this.walls.add(new SolidObject("Wall", 100, 75));

        this.walls.add(new SolidObject("Wall", 25, 75));
        this.walls.add(new SolidObject("Wall", 50, 75));
        this.walls.add(new SolidObject("Wall", 25, 100));
        this.walls.add(new SolidObject("Wall", 50, 100));

        this.walls.add(new SolidObject("Wall", 25, 150));
        this.walls.add(new SolidObject("Wall", 50, 150));
        this.walls.add(new SolidObject("Wall", 75, 150));
        this.walls.add(new SolidObject("Wall", 100, 150));
        this.walls.add(new SolidObject("Wall", 100, 125));

        this.walls.add(new SolidObject("Wall", 150, 25));
        this.walls.add(new SolidObject("Wall", 175, 25));
        this.walls.add(new SolidObject("Wall", 200, 25));
        this.walls.add(new SolidObject("Wall", 225, 25));

        this.walls.add(new SolidObject("Wall", 150, 50));
        this.walls.add(new SolidObject("Wall", 150, 75));
        this.walls.add(new SolidObject("Wall", 150, 100));

        this.walls.add(new SolidObject("Wall", 200, 75));
        this.walls.add(new SolidObject("Wall", 200, 100));
        this.walls.add(new SolidObject("Wall", 225, 75));
        this.walls.add(new SolidObject("Wall", 225, 100));

        this.walls.add(new SolidObject("Wall", 275, 25));
        this.walls.add(new SolidObject("Wall", 275, 50));
        this.walls.add(new SolidObject("Wall", 300, 25));
        this.walls.add(new SolidObject("Wall", 325, 25));
        this.walls.add(new SolidObject("Wall", 350, 25));

        this.walls.add(new SolidObject("Wall", 325, 75));
        this.walls.add(new SolidObject("Wall", 350, 75));
        this.walls.add(new SolidObject("Wall", 325, 100));
        this.walls.add(new SolidObject("Wall", 350, 100));

        this.walls.add(new SolidObject("Wall", 275, 100));
        this.walls.add(new SolidObject("Wall", 275, 125));
        this.walls.add(new SolidObject("Wall", 275, 150));
        this.walls.add(new SolidObject("Wall", 300, 150));
        this.walls.add(new SolidObject("Wall", 325, 150));
        this.walls.add(new SolidObject("Wall", 350, 150));

        this.walls.add(new SolidObject("Wall", 150, 150));
        this.walls.add(new SolidObject("Wall", 150, 175));
        this.walls.add(new SolidObject("Wall", 150, 200));
        this.walls.add(new SolidObject("Wall", 150, 225));
        this.walls.add(new SolidObject("Wall", 175, 225));

        this.walls.add(new SolidObject("Wall", 200, 150));
        this.walls.add(new SolidObject("Wall", 225, 150));
        this.walls.add(new SolidObject("Wall", 225, 175));
        this.walls.add(new SolidObject("Wall", 225, 200));
        this.walls.add(new SolidObject("Wall", 225, 225));

        this.walls.add(new SolidObject("Wall", 25, 200));
        this.walls.add(new SolidObject("Wall", 50, 200));
        this.walls.add(new SolidObject("Wall", 75, 200));
        this.walls.add(new SolidObject("Wall", 100, 200));
        this.walls.add(new SolidObject("Wall", 25, 225));
        this.walls.add(new SolidObject("Wall", 50, 225));
        this.walls.add(new SolidObject("Wall", 75, 225));
        this.walls.add(new SolidObject("Wall", 100, 225));

        this.walls.add(new SolidObject("Wall", 275, 200));
        this.walls.add(new SolidObject("Wall", 300, 200));
        this.walls.add(new SolidObject("Wall", 325, 200));
        this.walls.add(new SolidObject("Wall", 350, 200));
        this.walls.add(new SolidObject("Wall", 275, 225));
        this.walls.add(new SolidObject("Wall", 300, 225));
        this.walls.add(new SolidObject("Wall", 325, 225));
        this.walls.add(new SolidObject("Wall", 350, 225));

        this.walls.add(new SolidObject("Wall", 25, 275));
        this.walls.add(new SolidObject("Wall", 50, 275));
        this.walls.add(new SolidObject("Wall", 75, 275));
        this.walls.add(new SolidObject("Wall", 25, 300));
        this.walls.add(new SolidObject("Wall", 50, 300));
        this.walls.add(new SolidObject("Wall", 75, 300));

        this.walls.add(new SolidObject("Wall", 125, 275));
        this.walls.add(new SolidObject("Wall", 150, 275));
        this.walls.add(new SolidObject("Wall", 175, 275));
        this.walls.add(new SolidObject("Wall", 200, 275));
        this.walls.add(new SolidObject("Wall", 225, 275));
        this.walls.add(new SolidObject("Wall", 250, 275));
        this.walls.add(new SolidObject("Wall", 125, 300));
        this.walls.add(new SolidObject("Wall", 150, 300));
        this.walls.add(new SolidObject("Wall", 175, 300));
        this.walls.add(new SolidObject("Wall", 200, 300));
        this.walls.add(new SolidObject("Wall", 225, 300));
        this.walls.add(new SolidObject("Wall", 250, 300));

        this.walls.add(new SolidObject("Wall", 300, 275));
        this.walls.add(new SolidObject("Wall", 325, 275));
        this.walls.add(new SolidObject("Wall", 350, 275));
        this.walls.add(new SolidObject("Wall", 300, 300));
        this.walls.add(new SolidObject("Wall", 325, 300));
        this.walls.add(new SolidObject("Wall", 350, 300));

        this.walls.add(new SolidObject("Wall", 25, 350));
        this.walls.add(new SolidObject("Wall", 50, 350));
        this.walls.add(new SolidObject("Wall", 75, 350));
        this.walls.add(new SolidObject("Wall", 100, 350));

        this.walls.add(new SolidObject("Wall", 150, 350));
        this.walls.add(new SolidObject("Wall", 175, 350));
        this.walls.add(new SolidObject("Wall", 200, 350));
        this.walls.add(new SolidObject("Wall", 225, 350));

        this.walls.add(new SolidObject("Wall", 275, 350));
        this.walls.add(new SolidObject("Wall", 300, 350));
        this.walls.add(new SolidObject("Wall", 325, 350));
        this.walls.add(new SolidObject("Wall", 350, 350));



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
