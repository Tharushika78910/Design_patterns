
public class CityMap extends Map {

    public CityMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        int pick = random.nextInt(3);

        if (pick == 0) {
            return new RoadTile();
        } else if (pick == 1) {
            return new ForestTile();
        } else {
            return new BuildingTile();
        }
    }
}