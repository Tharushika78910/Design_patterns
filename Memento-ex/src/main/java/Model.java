
import java.time.LocalDateTime;

public class Model {

    private final int[] colors = {0, 2, 1}; // red, yellow, blue to match the example image
    private boolean checked = true;

    public int getColor(int index) {
        return colors[index];
    }

    public void setColor(int index, int color) {
        colors[index] = color;
    }

    public void cycleColor(int index) {
        colors[index] = (colors[index] + 1) % 3;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Memento createMemento(String actionDescription) {
        return new Memento(colors, checked, LocalDateTime.now(), actionDescription);
    }

    public void restoreState(IMemento iMemento) {
        Memento memento = (Memento) iMemento;
        int[] restoredColors = memento.getColors();

        for (int i = 0; i < colors.length; i++) {
            colors[i] = restoredColors[i];
        }
        checked = memento.isChecked();
    }
}