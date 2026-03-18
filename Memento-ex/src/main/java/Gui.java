
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Gui {

    private final Stage primaryStage;
    private final Stage historyStage;

    private final ColorBox[] colorBoxes = new ColorBox[3];
    private final CheckBox checkBox = new CheckBox("Click me!");
    private final ListView<IMemento> historyListView = new ListView<>();

    public Gui(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.historyStage = new Stage();

        createMainWindow();
        createHistoryWindow();
    }

    private void createMainWindow() {
        colorBoxes[0] = new ColorBox();
        colorBoxes[1] = new ColorBox();
        colorBoxes[2] = new ColorBox();

        HBox colorRow = new HBox(55, colorBoxes[0], colorBoxes[1], colorBoxes[2]);

        Label infoLabel = new Label("Press Ctrl-Z to undo the last change.\nPress Ctrl-Y to redo the last undone change.");

        VBox root = new VBox(35, colorRow, checkBox, infoLabel);
        root.setPadding(new Insets(25));

        Scene scene = new Scene(root, 760, 430);

        primaryStage.setTitle("Memento Pattern Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createHistoryWindow() {
        Label historyLabel = new Label("Saved states");
        VBox root = new VBox(10, historyLabel, historyListView);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 700, 400);

        historyStage.setTitle("History");
        historyStage.setScene(scene);
        historyStage.show();
    }

    public void setController(Controller controller) {
        for (int i = 0; i < colorBoxes.length; i++) {
            int index = i;
            colorBoxes[i].setOnMouseClicked(e -> controller.handleColorBoxClick(index));
        }

        checkBox.setOnAction(e -> controller.handleCheckBoxChange(checkBox.isSelected()));

        primaryStage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.isControlDown() && e.getCode() == KeyCode.Z) {
                controller.undo();
                e.consume();
            } else if (e.isControlDown() && e.getCode() == KeyCode.Y) {
                controller.redo();
                e.consume();
            }
        });

        historyListView.setOnMouseClicked(e -> {
            int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                controller.restoreFromHistory(selectedIndex);
            }
        });
    }

    public void updateFromModel(Model model) {
        for (int i = 0; i < colorBoxes.length; i++) {
            colorBoxes[i].setColorIndex(model.getColor(i));
        }
        checkBox.setSelected(model.isChecked());
    }

    public void updateHistory(List<IMemento> history, int selectedIndex) {
        historyListView.setItems(FXCollections.observableArrayList(history));
        if (selectedIndex >= 0 && selectedIndex < history.size()) {
            historyListView.getSelectionModel().select(selectedIndex);
            historyListView.scrollTo(selectedIndex);
        }
    }
}