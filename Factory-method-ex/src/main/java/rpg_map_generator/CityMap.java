package rpg_map_generator;

import java.util.concurrent.ThreadLocalRandom;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    public Tile createTile() {
        int r = ThreadLocalRandom.current().nextInt(3);
        return switch (r) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}

