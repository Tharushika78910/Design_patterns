import java.time.LocalDateTime;

public interface Document {
    String getId();
    LocalDateTime getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}