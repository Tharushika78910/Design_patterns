
import java.util.HashMap;
import java.util.Map;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class TileGraphicFactory {

    private static final Map<String, Image> graphicCache = new HashMap<>();

    private TileGraphicFactory() {
    }

    public static Image getTileGraphic(String tileType, int tileSize) {
        String key = tileType + "_" + tileSize;

        if (!graphicCache.containsKey(key)) {
            graphicCache.put(key, createTileGraphic(tileType, tileSize));
        }

        return graphicCache.get(key);
    }

    private static Image createTileGraphic(String tileType, int tileSize) {
        Canvas canvas = new Canvas(tileSize, tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        switch (tileType.toLowerCase()) {
            case "forest":
                drawForest(gc, tileSize);
                break;
            case "water":
                drawWater(gc, tileSize);
                break;
            case "swamp":
                drawSwamp(gc, tileSize);
                break;
            case "road":
                drawRoad(gc, tileSize);
                break;
            case "building":
                drawBuilding(gc, tileSize);
                break;
            default:
                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(0, 0, tileSize, tileSize);
                gc.setStroke(Color.BLACK);
                gc.strokeRect(0, 0, tileSize, tileSize);
                break;
        }

        WritableImage image = new WritableImage(tileSize, tileSize);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        return canvas.snapshot(params, image);
    }

    private static void drawForest(GraphicsContext gc, int s) {
        gc.setFill(Color.DARKSEAGREEN);
        gc.fillRect(0, 0, s, s);

        gc.setFill(Color.DARKGREEN);
        gc.fillOval(s * 0.10, s * 0.15, s * 0.30, s * 0.30);
        gc.fillOval(s * 0.35, s * 0.08, s * 0.30, s * 0.30);
        gc.fillOval(s * 0.55, s * 0.18, s * 0.25, s * 0.25);

        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, s, s);
    }

    private static void drawWater(GraphicsContext gc, int s) {
        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillRect(0, 0, s, s);

        gc.setStroke(Color.ALICEBLUE);
        gc.setLineWidth(2);
        gc.strokeLine(s * 0.10, s * 0.30, s * 0.40, s * 0.25);
        gc.strokeLine(s * 0.45, s * 0.55, s * 0.80, s * 0.50);
        gc.strokeLine(s * 0.15, s * 0.75, s * 0.55, s * 0.70);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(0, 0, s, s);
    }

    private static void drawSwamp(GraphicsContext gc, int s) {
        gc.setFill(Color.OLIVEDRAB);
        gc.fillRect(0, 0, s, s);

        gc.setFill(Color.DARKOLIVEGREEN);
        gc.fillOval(s * 0.15, s * 0.20, s * 0.25, s * 0.18);
        gc.fillOval(s * 0.45, s * 0.50, s * 0.30, s * 0.20);
        gc.fillOval(s * 0.30, s * 0.70, s * 0.22, s * 0.12);

        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, s, s);
    }

    private static void drawRoad(GraphicsContext gc, int s) {
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, s, s);

        gc.setFill(Color.DIMGRAY);
        gc.fillRect(0, s * 0.35, s, s * 0.30);

        gc.setStroke(Color.KHAKI);
        gc.setLineWidth(2);
        gc.strokeLine(0, s * 0.50, s, s * 0.50);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(0, 0, s, s);
    }

    private static void drawBuilding(GraphicsContext gc, int s) {
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, s, s);

        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(s * 0.18, s * 0.25, s * 0.64, s * 0.52);

        gc.setFill(Color.FIREBRICK);
        double[] xPoints = { s * 0.12, s * 0.50, s * 0.88 };
        double[] yPoints = { s * 0.25, s * 0.05, s * 0.25 };
        gc.fillPolygon(xPoints, yPoints, 3);

        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(s * 0.28, s * 0.38, s * 0.14, s * 0.14);
        gc.fillRect(s * 0.58, s * 0.38, s * 0.14, s * 0.14);

        gc.setFill(Color.BLACK);
        gc.fillRect(s * 0.46, s * 0.55, s * 0.10, s * 0.22);

        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, s, s);
    }

    public static int getNumberOfCachedGraphics() {
        return graphicCache.size();
    }
}