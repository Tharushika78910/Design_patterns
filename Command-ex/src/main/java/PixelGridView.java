
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PixelGridView extends GridPane {

    private static final int CELL_SIZE = 50;

    private final PixelArtModel model;
    private final Rectangle[][] cells;

    public PixelGridView(PixelArtModel model) {
        this.model = model;
        this.cells = new Rectangle[model.getSize()][model.getSize()];

        createGrid();
        update();
    }

    private void createGrid() {
        for (int row = 0; row < model.getSize(); row++) {
            for (int col = 0; col < model.getSize(); col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);

                cell.setFill(Color.WHITE);
                cell.setStroke(Color.GRAY);
                cell.setStrokeWidth(1);

                cells[row][col] = cell;
                add(cell, col, row);
            }
        }
    }

    public void update() {
        for (int row = 0; row < model.getSize(); row++) {
            for (int col = 0; col < model.getSize(); col++) {
                Rectangle cell = cells[row][col];

                if (model.isPixelOn(row, col)) {
                    cell.setFill(Color.BLACK);
                } else {
                    cell.setFill(Color.WHITE);
                }

                if (row == model.getCursorRow() && col == model.getCursorCol()) {
                    cell.setStroke(Color.RED);
                    cell.setStrokeWidth(4);
                } else {
                    cell.setStroke(Color.GRAY);
                    cell.setStrokeWidth(1);
                }
            }
        }
    }
}