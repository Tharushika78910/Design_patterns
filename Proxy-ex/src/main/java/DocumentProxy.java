
import java.time.LocalDateTime;

public class DocumentProxy implements Document {
    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDateTime getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (user == null) {
            throw new AccessDeniedException("Access denied: user is null.");
        }

        boolean allowed = accessControlService.isAllowed(realDocument.getId(), user.getUsername());

        if (!allowed) {
            throw new AccessDeniedException(
                    "Access denied: user '" + user.getUsername() +
                            "' is not allowed to access document '" + realDocument.getId() + "'."
            );
        }

        return realDocument.getContent(user);
    }
}