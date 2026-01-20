package rpg_map_generator;

public class Game {

    public static Map createMap(String kind, int w, int h) {
        return switch (kind.toLowerCase()) {
            case "city" -> new CityMap(w, h);
            case "wilderness" -> new WildernessMap(w, h);
            default -> throw new IllegalArgumentException("Unknown map type: " + kind);
        };
    }

    public static void main(String[] args) {
        Map map = createMap("wilderness", 10, 6);       // or "wilderness"
        map.display();
    }
}

