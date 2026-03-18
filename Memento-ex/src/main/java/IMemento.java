
import java.time.LocalDateTime;

public interface IMemento {
    LocalDateTime getSavedAt();
    String getDisplayName();
}