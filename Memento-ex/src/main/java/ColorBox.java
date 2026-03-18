
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox extends StackPane {

    private final Rectangle rectangle;
    private int colorIndex = 0; // 0 = red, 1 = blue, 2 = yellow

    public ColorBox() {
        rectangle = new Rectangle(180, 180);
        setAlignment(Pos.CENTER);
        getChildren().add(rectangle);
        setColorIndex(0);
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
        rectangle.setFill(toColor(colorIndex));
    }

    public int getColorIndex() {
        return colorIndex;
    }

    private Color toColor(int index) {
        return switch (index) {
            case 0 -> Color.RED;
            case 1 -> Color.BLUE;
            case 2 -> Color.YELLOW;
            default -> Color.RED;
        };
    }
}