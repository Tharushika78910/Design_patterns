
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String extension;
    private final List<File> matchingFiles;

    public SearchVisitor(String extension) {
        if (extension == null || extension.isBlank()) {
            throw new IllegalArgumentException("Extension must not be null or blank.");
        }

        this.extension = extension.startsWith(".") ? extension.toLowerCase() : "." + extension.toLowerCase();
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().toLowerCase().endsWith(extension)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Nothing to store for directories in this visitor.
    }

    public List<File> getMatchingFiles() {
        return Collections.unmodifiableList(matchingFiles);
    }
}