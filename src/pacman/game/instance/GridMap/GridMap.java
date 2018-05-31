package pacman.game.instance.GridMap;

import pacman.Vector2;
import pacman.game.instance.MOVEMENT_INPUT;
import pacman.game.instance.SolidObject;

import javax.xml.bind.annotation.XmlType;
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
    }

    public GridMap(Vector2 tileSize, List<SolidObject> walls) {
        this(tileSize, new Vector2(defaultTileCount), walls);
    }

    public GridMap(List<SolidObject> walls) {
        this.tileSize = new Vector2(defaultValue);
        this.tileCount = new Vector2(defaultTileCount);
        this.walls = walls;
    }

    // METHODS ------------------------- //

    public Vector2 SnapToGrid(Vector2 vector2) {

        // The coordinates are integers, so they will be rounded down
        return vector2.divide(this.tileSize);

    }

    public Tile getTile(Vector2 vector2) {
        return tiles.get(SnapToGrid(vector2));
    }

    // HELPER METHODS ----------------- //

    private void initializeTiles() {

        // INITIALIZE THE WALLS //

        for (SolidObject wall : walls) {
            tiles.put(SnapToGrid(new Vector2(wall.getX_position(), wall.getY_position())), new Tile());
        }

        // INITIALIZE ALL OTHER //

        for (int rowCount = 0; rowCount < tileCount.getY(); rowCount+= tileSize.getY()) {
            for (int columnCount = 0; columnCount < tileCount.getX(); columnCount+= tileSize.getX()) {

                Tile tile = tiles.get(new Vector2(columnCount, rowCount));

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

    public boolean checkIfNearWall(MOVEMENT_INPUT direction, int x, int y) {

        Vector2 vecToCheck;

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
            default:
                vecToCheck = new Vector2(-tileSize.getX(), -tileSize.getY());
                break;
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
