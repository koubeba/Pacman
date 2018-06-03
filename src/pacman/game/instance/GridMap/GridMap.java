package pacman.game.instance.GridMap;

import pacman.Vector2;
import pacman.game.instance.MOVEMENT_INPUT;
import pacman.game.instance.SolidObject;

import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class GridMap {

    // FIELDS -------------------------- //

    private final Vector2 tileSize;
    private final Vector2 tileCount;

    // WALLS //

        private List<SolidObject> walls;

    // TILES //

        private Map<Vector2, Tile> tiles;


    // CONSTANTS ----------------------- //

    private final static int defaultValue = 25;
    private final static int defaultTileCount = 16;

    // CONSTRUCTORS -------------------- //

    public GridMap(Vector2 tileSize, Vector2 tileCount, List<SolidObject> walls) {
        this.tileSize = tileSize;
        this.tileCount = tileCount;
        this.walls = walls;

        this.tiles = new HashMap<Vector2, Tile>();

        this.initializeTiles();
    }

    public GridMap(Vector2 tileSize, List<SolidObject> walls) {
        this(tileSize, new Vector2(defaultTileCount), walls);
    }

    public GridMap(List<SolidObject> walls) {
        this.tileSize = new Vector2(defaultValue);
        this.tileCount = new Vector2(defaultTileCount);
        this.walls = walls;

        this.tiles = new HashMap<Vector2, Tile>();

        this.initializeTiles();
    }

    // METHODS ------------------------- //

    public Vector2 SnapToGrid(Vector2 vector2) {
            return vector2.subtract(vector2.divideModulo(this.tileSize));
        // The coordinates are integers, so they will be rounded down

    }

    public boolean smallDeltaHorizontal(Vector2 vector2) {
        return (vector2.getX() % this.tileSize.getX() <= 1) ;
    }

    public boolean smallDeltaVertical(Vector2 vector2) {
        return (vector2.getY() % this.tileSize.getY() <= 1);
    }

    public boolean alignedToTileHorizontal(Vector2 vector2) {
        return (vector2.getX() % this.tileSize.getX() == 0);
    }

    public boolean alignedToTileVertical(Vector2 vector2) {
        return (vector2.getY() % this.tileSize.getY() == 0);
    }

    public boolean alignedToTile(Vector2 vector2) {
        return this.alignedToTileVertical(vector2) && this.alignedToTileHorizontal(vector2);
    }

    public boolean edgeUp(Vector2 vector2) {
        return vector2.getY() == 0;
    }

    public boolean edgeDown(Vector2 vector2) {
        return vector2.getY() == (this.tileCount.getY()-1) * (this.tileSize.getY());
    }

    public boolean edgeLeft(Vector2 vector2) {
        return vector2.getX() == 0;
    }

    public boolean edgeRight(Vector2 vector2) {
        return vector2.getX() == (this.tileCount.getX()- 1)* (this.tileSize.getX());
    }
    public Tile getTile(Vector2 vector2) {
        return tiles.get(SnapToGrid(vector2));
    }

    // HELPER METHODS ----------------- //

    private void initializeTiles() {

        // INITIALIZE THE WALLS //

        for (SolidObject wall : walls) {
            tiles.put(new Vector2(wall.getX_position(), wall.getY_position()), new Tile());
        }

        // ADD WALLS SURROUNDING THE MAP //

        int rowCount = 0;
        int columnCount = 0;

        // UPPER WALL //
        rowCount = -tileSize.getY();

        for (columnCount = -1; columnCount < (tileCount.getX() + 1) * tileSize.getX(); columnCount += tileSize.getX()) {
            tiles.put(new Vector2(columnCount, rowCount), new Tile());
        }

        // DOWN WALL //

        rowCount = tileCount.getY();

        for (columnCount = -tileSize.getX(); columnCount < (tileCount.getX() + 1) * tileSize.getX(); columnCount+= tileSize.getX()) {
            tiles.put(new Vector2(columnCount, rowCount), new Tile());
        }

        // LEFT WALL //

        columnCount = -tileSize.getX();

        for (rowCount = 0; rowCount < tileCount.getY() * tileSize.getY(); rowCount+= tileSize.getY()) {
            tiles.put(new Vector2(columnCount, rowCount), new Tile());
        }

        // RIGHT WALL //

        columnCount = tileCount.getX();

        for (rowCount = 0; rowCount < tileCount.getY() * tileSize.getY(); rowCount+= tileSize.getY()) {
            tiles.put(new Vector2(columnCount, rowCount), new Tile());
        }
        // INITIALIZE ALL OTHER //

        for (rowCount = 0; rowCount < tileCount.getY() * tileSize.getY(); rowCount+= tileSize.getY()) {
            for (columnCount = 0; columnCount < tileCount.getX() * tileSize.getX(); columnCount+= tileSize.getX()) {

                Tile tile = null;

                tile = tiles.get(new Vector2(columnCount, rowCount));

                boolean Up = true;
                boolean Down = true;
                boolean Left = true;
                boolean Right = true;

                // WALL //
                if (tile != null && !tile.isOpen()) {
                    continue;
                }

                // ONE TILE UP IS A WALL //

                if (checkIfNearWall(MOVEMENT_INPUT.UP, columnCount, rowCount)) {
                    Up = false;
                }

                // ONE TILE DOWN IS A WALL //

                if (checkIfNearWall(MOVEMENT_INPUT.DOWN, columnCount, rowCount)) {
                    Down = false;
                }

                // ONE TILE LEFT IS A WALL //

                if (checkIfNearWall(MOVEMENT_INPUT.LEFT, columnCount, rowCount)) {
                    Left = false;
                }

                // ONE TILE RIGHT IS A WALL //

                if (checkIfNearWall(MOVEMENT_INPUT.RIGHT, columnCount, rowCount)) {
                    Right = false;
                }

                // CONSTRUCT A TILE //

                tiles.put(new Vector2(columnCount, rowCount), new Tile(true, Up, Down, Left, Right));

            }
        }
    }

    // DEBUG //

    /*
    public void render(Graphics g) {
        for (Map.Entry<Vector2, Tile> pair : tiles.entrySet()) {
            g.drawString(pair.getValue().toStringNonVerbose(), pair.getKey().getX(), pair.getKey().getY() + tileSize.getY());
        }
    }
    */

    // DEBUG //

    public boolean checkIfNearWall(MOVEMENT_INPUT direction, int x, int y) {

        Vector2 vecToCheck = null;

        switch(direction) {
            case UP:
                vecToCheck = new Vector2(x, y - tileSize.getY());
                break;
            case DOWN:
                vecToCheck = new Vector2(x, y + tileSize.getY());
                break;
            case LEFT:
                vecToCheck = new Vector2(x - tileSize.getX(), y);
                break;
            case RIGHT:
                vecToCheck = new Vector2(x + tileSize.getX(), y);
                break;
        }

        if (vecToCheck == null) {
            return false;
        }

        Tile tile = tiles.get(vecToCheck);
        if (tile != null) {
            return (!tile.isOpen());
        }

        return false;
    }

    // GETTERS AND SETTERS ------------ //


    public List<SolidObject> getWalls() {
        return walls;
    }
}
