import java.time.LocalDateTime;

class RealDocument implements Document {
    private final String id;
    private final LocalDateTime creationDate;
    private final String content;

    RealDocument(String id, LocalDateTime creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}