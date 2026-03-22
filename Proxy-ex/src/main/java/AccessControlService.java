import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static final AccessControlService INSTANCE = new AccessControlService();

    // documentId -> set of usernames allowed to access it
    private final Map<String, Set<String>> permissions;

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public void grantAccess(String documentId, String username) {
        permissions.computeIfAbsent(documentId, key -> new HashSet<>()).add(username);
    }

    public void revokeAccess(String documentId, String username) {
        Set<String> allowedUsers = permissions.get(documentId);
        if (allowedUsers != null) {
            allowedUsers.remove(username);
            if (allowedUsers.isEmpty()) {
                permissions.remove(documentId);
            }
        }
    }

    public boolean isAllowed(String documentId, String username) {
        Set<String> allowedUsers = permissions.get(documentId);
        return allowedUsers != null && allowedUsers.contains(username);
    }
}