import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents;
    private final AccessControlService accessControlService;

    public Library() {
        this.documents = new HashMap<>();
        this.accessControlService = AccessControlService.getInstance();
    }

    public void addPublicDocument(String id, LocalDateTime creationDate, String content) {
        Document document = new RealDocument(id, creationDate, content);
        documents.put(id, document);
    }

    public void addProtectedDocument(String id, LocalDateTime creationDate, String content, String... allowedUsernames) {
        RealDocument realDocument = new RealDocument(id, creationDate, content);
        Document proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);

        if (allowedUsernames != null) {
            for (String username : allowedUsernames) {
                accessControlService.grantAccess(id, username);
            }
        }
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }

    public void printDocumentList() {
        System.out.println("Documents in library:");
        for (Map.Entry<String, Document> entry : documents.entrySet()) {
            System.out.println("- " + entry.getKey() + " | created: " + entry.getValue().getCreationDate());
        }
    }
}