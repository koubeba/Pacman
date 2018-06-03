package pacman.game.levels;

import pacman.Vector2;
import pacman.game.GameManager;
import pacman.game.instance.*;
import pacman.game.instance.GridMap.GridMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {

    // FIELDS -------------------- //

    // MAP //

    private final GridMap gridMap;

    // PLAYER //

    private Player player;

    // GHOSTS //

    private Blinky blinky;
    private Inky inky;
    private Pinky pinky;
    private Clyde clyde;

    // COLLECTABLES //

    private List<Collectible> dots;

    private PowerUp powerUp;
    //TODO: add cherries

    private int activeDots;

    // REFERENCES //

    private GameManager gameManager;

    // CONSTRUCTOR -----------------//

    //TODO: add some sort of prefabs
    public Level(GameManager gameManager) {

        // SAVE REFERENCE //

        this.gameManager = gameManager;

        // INITIALIZE LISTS //

        List<SolidObject> walls = new ArrayList<SolidObject>();
        dots = new ArrayList<Collectible>();

        // INITIALIZE PLAYER //

        this.player = new Player("Pacman", 0, 0, 100);

        // INITIALIZE GHOSTS //

        this.blinky = new Blinky("Blinky", 175, 175, 100, this.player);
        this.inky = new Inky("Inky", 200, 175, 100, this.player);
        this.pinky = new Pinky("Pinky", 175, 200, 100, this.player);
        this.clyde = new Clyde("Clyde", 200, 200, 100, this.player);

        // ADD WALLS //

        walls.add(new SolidObject("Wall", 25, 25));
        walls.add(new SolidObject("Wall", 50, 25));
        walls.add(new SolidObject("Wall", 75, 25));
        walls.add(new SolidObject("Wall", 100, 25));
        walls.add(new SolidObject("Wall", 100, 50));
        walls.add(new SolidObject("Wall", 100, 75));

        dots.add(new Collectible("Dot", 25, 0, 1));
        dots.add(new Collectible("Dot", 50, 0, 1));
        dots.add(new Collectible("Dot", 75, 0, 1));
        dots.add(new Collectible("Dot", 100, 0, 1));
        dots.add(new Collectible("Dot", 125, 0, 1));
        dots.add(new Collectible("Dot", 150, 0, 1));

        dots.add(new Collectible("Dot", 125, 25, 1));
        dots.add(new Collectible("Dot", 125, 50, 1));
        dots.add(new Collectible("Dot", 125, 75, 1));

        walls.add(new SolidObject("Wall", 25, 75));
        walls.add(new SolidObject("Wall", 50, 75));
        walls.add(new SolidObject("Wall", 25, 100));
        walls.add(new SolidObject("Wall", 50, 100));

        dots.add(new Collectible("Dot", 25, 50, 1));
        dots.add(new Collectible("Dot", 50, 50, 1));
        dots.add(new Collectible("Dot", 25, 125, 1));
        dots.add(new Collectible("Dot", 50, 125, 1));

        walls.add(new SolidObject("Wall", 25, 150));
        walls.add(new SolidObject("Wall", 50, 150));
        walls.add(new SolidObject("Wall", 75, 150));
        walls.add(new SolidObject("Wall", 100, 150));
        walls.add(new SolidObject("Wall", 100, 125));

        walls.add(new SolidObject("Wall", 150, 25));
        walls.add(new SolidObject("Wall", 175, 25));
        walls.add(new SolidObject("Wall", 200, 25));
        walls.add(new SolidObject("Wall", 225, 25));

        walls.add(new SolidObject("Wall", 150, 50));
        walls.add(new SolidObject("Wall", 150, 75));
        walls.add(new SolidObject("Wall", 150, 100));

        walls.add(new SolidObject("Wall", 200, 75));
        walls.add(new SolidObject("Wall", 200, 100));
        walls.add(new SolidObject("Wall", 225, 75));
        walls.add(new SolidObject("Wall", 225, 100));

        walls.add(new SolidObject("Wall", 275, 25));
        walls.add(new SolidObject("Wall", 275, 50));
        walls.add(new SolidObject("Wall", 300, 25));
        walls.add(new SolidObject("Wall", 325, 25));
        walls.add(new SolidObject("Wall", 350, 25));

        walls.add(new SolidObject("Wall", 325, 75));
        walls.add(new SolidObject("Wall", 350, 75));
        walls.add(new SolidObject("Wall", 325, 100));
        walls.add(new SolidObject("Wall", 350, 100));

        walls.add(new SolidObject("Wall", 275, 100));
        walls.add(new SolidObject("Wall", 275, 125));
        walls.add(new SolidObject("Wall", 275, 150));
        walls.add(new SolidObject("Wall", 300, 150));
        walls.add(new SolidObject("Wall", 325, 150));
        walls.add(new SolidObject("Wall", 350, 150));

        walls.add(new SolidObject("Wall", 150, 150));
        walls.add(new SolidObject("Wall", 150, 175));
        walls.add(new SolidObject("Wall", 150, 200));
        walls.add(new SolidObject("Wall", 150, 225));
        walls.add(new SolidObject("Wall", 175, 225));

        walls.add(new SolidObject("Wall", 200, 150));
        walls.add(new SolidObject("Wall", 225, 150));
        walls.add(new SolidObject("Wall", 225, 175));
        walls.add(new SolidObject("Wall", 225, 200));
        walls.add(new SolidObject("Wall", 225, 225));

        walls.add(new SolidObject("Wall", 25, 200));
        walls.add(new SolidObject("Wall", 50, 200));
        walls.add(new SolidObject("Wall", 75, 200));
        walls.add(new SolidObject("Wall", 100, 200));
        walls.add(new SolidObject("Wall", 25, 225));
        walls.add(new SolidObject("Wall", 50, 225));
        walls.add(new SolidObject("Wall", 75, 225));
        walls.add(new SolidObject("Wall", 100, 225));

        walls.add(new SolidObject("Wall", 275, 200));
        walls.add(new SolidObject("Wall", 300, 200));
        walls.add(new SolidObject("Wall", 325, 200));
        walls.add(new SolidObject("Wall", 350, 200));
        walls.add(new SolidObject("Wall", 275, 225));
        walls.add(new SolidObject("Wall", 300, 225));
        walls.add(new SolidObject("Wall", 325, 225));
        walls.add(new SolidObject("Wall", 350, 225));

        walls.add(new SolidObject("Wall", 25, 275));
        walls.add(new SolidObject("Wall", 50, 275));
        walls.add(new SolidObject("Wall", 75, 275));
        walls.add(new SolidObject("Wall", 25, 300));
        walls.add(new SolidObject("Wall", 50, 300));
        walls.add(new SolidObject("Wall", 75, 300));

        walls.add(new SolidObject("Wall", 125, 275));
        walls.add(new SolidObject("Wall", 150, 275));
        walls.add(new SolidObject("Wall", 175, 275));
        walls.add(new SolidObject("Wall", 200, 275));
        walls.add(new SolidObject("Wall", 225, 275));
        walls.add(new SolidObject("Wall", 250, 275));
        walls.add(new SolidObject("Wall", 125, 300));
        walls.add(new SolidObject("Wall", 150, 300));
        walls.add(new SolidObject("Wall", 175, 300));
        walls.add(new SolidObject("Wall", 200, 300));
        walls.add(new SolidObject("Wall", 225, 300));
        walls.add(new SolidObject("Wall", 250, 300));

        walls.add(new SolidObject("Wall", 300, 275));
        walls.add(new SolidObject("Wall", 325, 275));
        walls.add(new SolidObject("Wall", 350, 275));
        walls.add(new SolidObject("Wall", 300, 300));
        walls.add(new SolidObject("Wall", 325, 300));
        walls.add(new SolidObject("Wall", 350, 300));

        walls.add(new SolidObject("Wall", 25, 350));
        walls.add(new SolidObject("Wall", 50, 350));
        walls.add(new SolidObject("Wall", 75, 350));
        walls.add(new SolidObject("Wall", 100, 350));

        walls.add(new SolidObject("Wall", 150, 350));
        walls.add(new SolidObject("Wall", 175, 350));
        walls.add(new SolidObject("Wall", 200, 350));
        walls.add(new SolidObject("Wall", 225, 350));

        walls.add(new SolidObject("Wall", 275, 350));
        walls.add(new SolidObject("Wall", 300, 350));
        walls.add(new SolidObject("Wall", 325, 350));
        walls.add(new SolidObject("Wall", 350, 350));

        // INITIALIZE GRIDMAP //

        this.gridMap = new GridMap(walls);

        this.player.setGridMap(this.gridMap);

        this.blinky.setGridMap(this.gridMap);
        this.inky.setGridMap(this.gridMap);
        this.pinky.setGridMap(this.gridMap);
        this.clyde.setGridMap(this.gridMap);

        // ADD DOTS //

        for (Collectible dot : dots) {
            dot.addCollector(this.player);
        }

        this.activeDots = dots.size();

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

        if (this.powerUp != null && this.powerUp.isActive()) {
            this.player.checkCollectibleCollision(powerUp);
        }

        // CHECK COLLISIONS WITH GHOSTS //

        this.player.checkGhostCollision(this.blinky, this.gameManager.getGameState());
        this.player.checkGhostCollision(this.inky, this.gameManager.getGameState());
        this.player.checkGhostCollision(this.pinky, this.gameManager.getGameState());
        this.player.checkGhostCollision(this.clyde, this.gameManager.getGameState());

        // CHECK COLLISIONS WITH WALLS //

        this.player.resetCollisionFlags();

            /*
            for (SolidObject wall: walls) {
                this.player.checkWallCollision(wall);
            }
            */
    }

    public void renderAll(Graphics g) {

        // RENDER SCORE //

        g.drawString(String.valueOf(this.player.getPoints()), 10, 10);


        // RENDER WALLS //


        for (SolidObject wall : this.gridMap.getWalls()) {
            wall.render(g);
        }

        // RENDER PLAYER //

        this.player.render(g);
        // RENDER GHOSTS //

        if (this.blinky.isActive()) this.blinky.render(g);
        if (this.inky.isActive()) this.inky.render(g);
        if (this.pinky.isActive()) this.pinky.render(g);
        if (this.clyde.isActive()) this.clyde.render(g);

        // RENDER COLLECTIBLES //

        for (Collectible dot : dots) {
            if (dot.isActive()) dot.render(g);
        }

        if (this.powerUp != null && this.powerUp.isActive()) {
            this.powerUp.render(g);
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

    // GETTERS AND SETTERS -------------------- //

    public boolean getPlayerRestart() {
        return this.player.isRestart();
    }

    public boolean isPowerUp() {
        if (this.powerUp != null) {
            return this.powerUp.isPowerUpMode();
        } else {
            return false;
        }
    }

    public void deactivatePowerUp() {
        if (this.powerUp != null) {
            this.powerUp.setPowerUpMode(false);
        }
    }

    public void activatePowerUp() {

        //TODO: Randomize position
        this.powerUp = new PowerUp("Cherry", 0, 25, 20);
        this.powerUp.addCollector(this.player);
    }
}
