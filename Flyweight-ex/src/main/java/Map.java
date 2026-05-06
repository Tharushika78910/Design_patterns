
import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Map {

    protected final int rows;
    protected final int cols;
    protected final Tile[][] tiles;
    protected final Random random;

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[rows][cols];
        this.random = new Random();
        generate();
    }

    protected abstract Tile createTile();

    private void generate() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                tiles[r][c] = createTile();
            }
        }
    }

    public void display() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(tiles[r][c].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public void render(Canvas canvas, int tileSize) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Tile tile = tiles[r][c];

                Image tileGraphic = TileGraphicFactory.getTileGraphic(tile.getType(), tileSize);

                double x = c * tileSize;
                double y = r * tileSize;

                gc.drawImage(tileGraphic, x, y);
            }
        }
    }
}