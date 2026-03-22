
public class File implements FileSystemElement {
    private final String name;
    private final double sizeInMb;

    public File(String name, double sizeInMb) {
        this.name = name;
        this.sizeInMb = sizeInMb;
    }

    public String getName() {
        return name;
    }

    public double getSizeInMb() {
        return sizeInMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "File{name='" + name + "', sizeInMb=" + sizeInMb + "}";
    }
}