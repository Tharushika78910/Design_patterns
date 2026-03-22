import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        library.addPublicDocument(
                "DOC-001",
                LocalDateTime.of(2025, 5, 1, 10, 30),
                "This is a public document. Anyone can read this."
        );

        library.addProtectedDocument(
                "DOC-002",
                LocalDateTime.of(2025, 5, 2, 9, 0),
                "Secret project plan: release scheduled for next month.",
                "alice", "bob"
        );

        library.addProtectedDocument(
                "DOC-003",
                LocalDateTime.of(2025, 5, 3, 14, 15),
                "HR salary report: strictly confidential.",
                "alice"
        );

        library.printDocumentList();
        System.out.println();

        testAccess(library, "DOC-001", alice);
        testAccess(library, "DOC-001", bob);
        testAccess(library, "DOC-002", alice);
        testAccess(library, "DOC-002", charlie);
        testAccess(library, "DOC-003", bob);
        testAccess(library, "DOC-003", alice);
    }

    private static void testAccess(Library library, String documentId, User user) {
        System.out.println("User '" + user.getUsername() + "' tries to access " + documentId);

        Document document = library.getDocument(documentId);

        if (document == null) {
            System.out.println("Document not found.");
            System.out.println();
            return;
        }

        System.out.println("Creation date: " + document.getCreationDate());

        try {
            String content = document.getContent(user);
            System.out.println("Content: " + content);
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}