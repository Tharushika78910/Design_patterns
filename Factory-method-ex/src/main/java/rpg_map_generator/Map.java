package rpg_map_generator;

public abstract class Map {
    private final int width;
    private final int height;

    protected Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Factory Method (implemented in subclasses)
    public abstract Tile createTile();

    // Algorithm that does NOT know concrete tile types
    public void display() {
        Tile[][] tiles = new Tile[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = createTile();
            }
        }

        // Print as matrix of characters
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[y][x].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

