package rpg_map_generator;

import java.util.concurrent.ThreadLocalRandom;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        int r = ThreadLocalRandom.current().nextInt(3);
        return switch (r) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}
