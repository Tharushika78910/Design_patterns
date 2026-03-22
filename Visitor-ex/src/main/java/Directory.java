
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public List<FileSystemElement> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);

        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }

    @Override
    public String toString() {
        return "Directory{name='" + name + "'}";
    }
}