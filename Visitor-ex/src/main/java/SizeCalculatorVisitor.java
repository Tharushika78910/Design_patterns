
public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSizeInMb;

    public SizeCalculatorVisitor() {
        this.totalSizeInMb = 0.0;
    }

    @Override
    public void visit(File file) {
        totalSizeInMb += file.getSizeInMb();
    }

    @Override
    public void visit(Directory directory) {
        // No size is added here because directories themselves
        // do not contribute file size in this model.
    }

    public double getTotalSizeInMb() {
        return totalSizeInMb;
    }
}