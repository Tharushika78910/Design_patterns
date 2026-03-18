
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Model model;
    private final Gui gui;

    private final List<IMemento> history = new ArrayList<>();
    private int currentIndex = -1;

    public Controller(Stage primaryStage) {
        this.model = new Model();
        this.gui = new Gui(primaryStage);
        this.gui.setController(this);

        saveNewCurrentState("Initial state");
        refreshView();
    }

    public void handleColorBoxClick(int boxIndex) {
        model.cycleColor(boxIndex);
        saveNewCurrentState("Changed box " + (boxIndex + 1));
        refreshView();
    }

    public void handleCheckBoxChange(boolean checked) {
        model.setChecked(checked);
        saveNewCurrentState("Changed checkbox");
        refreshView();
    }

    public void undo() {
        if (currentIndex <= 0) {
            return;
        }

        currentIndex--;
        model.restoreState(history.get(currentIndex));
        refreshView();
    }

    public void redo() {
        if (currentIndex >= history.size() - 1) {
            return;
        }

        currentIndex++;
        model.restoreState(history.get(currentIndex));
        refreshView();
    }

    public void restoreFromHistory(int index) {
        if (index < 0 || index >= history.size()) {
            return;
        }

        currentIndex = index;
        model.restoreState(history.get(currentIndex));
        refreshView();
    }

    private void saveNewCurrentState(String description) {
        // If user made undo(s) and then changes something new,
        // delete all "future" states so redo history is cleared.
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }

        history.add(model.createMemento(description));
        currentIndex = history.size() - 1;
    }

    private void refreshView() {
        gui.updateFromModel(model);
        gui.updateHistory(history, currentIndex);
    }
}