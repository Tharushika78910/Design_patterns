
public class WildernessMap extends Map {

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        int pick = random.nextInt(3);

        if (pick == 0) {
            return new SwampTile();
        } else if (pick == 1) {
            return new WaterTile();
        } else {
            return new ForestTile();
        }
    }
}