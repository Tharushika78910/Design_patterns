
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Memento implements IMemento {

    private final int[] colors;
    private final boolean checked;
    private final LocalDateTime savedAt;
    private final String actionDescription;

    public Memento(int[] colors, boolean checked, LocalDateTime savedAt, String actionDescription) {
        this.colors = colors.clone();
        this.checked = checked;
        this.savedAt = savedAt;
        this.actionDescription = actionDescription;
    }

    public int[] getColors() {
        return colors.clone();
    }

    public boolean isChecked() {
        return checked;
    }

    @Override
    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    @Override
    public String getDisplayName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatter.format(savedAt) + " - " + actionDescription
                + " | colors=" + Arrays.toString(colors)
                + " | checked=" + checked;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}