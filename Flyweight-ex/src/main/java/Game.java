
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {

    private static final int ROWS = 8;
    private static final int COLS = 12;
    private static final int TILE_SIZE = 48;

    public static Map createMap(String type, int rows, int cols) {
        if (type == null) {
            type = "";
        }

        type = type.trim().toLowerCase();

        if (type.equals("city")) {
            return new CityMap(rows, cols);
        } else if (type.equals("wilderness") || type.equals("wild")) {
            return new WildernessMap(rows, cols);
        } else {
            return new WildernessMap(rows, cols);
        }
    }

    @Override
    public void start(Stage stage) {
        Parameters params = getParameters();

        String mapType = "wilderness";
        if (!params.getRaw().isEmpty()) {
            mapType = params.getRaw().get(0);
        }

        Map map = createMap(mapType, ROWS, COLS);

        System.out.println("Generated Map:");
        map.display();

        Canvas canvas = new Canvas(COLS * TILE_SIZE, ROWS * TILE_SIZE);
        map.render(canvas, TILE_SIZE);

        Label infoLabel = new Label(
                "Map type: " + mapType
                        + " | Size: " + ROWS + "x" + COLS
                        + " | Shared graphics in cache: " + TileGraphicFactory.getNumberOfCachedGraphics()
        );

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(infoLabel);
        root.setCenter(canvas);

        Scene scene = new Scene(root);
        stage.setTitle("RPG Map Generator - Flyweight Rendering");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}