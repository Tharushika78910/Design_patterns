
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");
        Directory projects = new Directory("projects");

        root.addElement(new File("readme.txt", 1.2));
        root.addElement(new File("notes.pdf", 2.5));

        documents.addElement(new File("essay.docx", 3.0));
        documents.addElement(new File("report.pdf", 4.1));

        images.addElement(new File("photo.jpg", 5.6));
        images.addElement(new File("diagram.png", 2.8));

        projects.addElement(new File("Main.java", 0.9));
        projects.addElement(new File("VisitorPattern.java", 1.4));
        projects.addElement(new File("config.json", 0.3));

        root.addElement(documents);
        root.addElement(images);
        root.addElement(projects);

        // Visitor 1: calculate total size
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        root.accept(sizeCalculatorVisitor);

        System.out.println("Total file system size: "
                + sizeCalculatorVisitor.getTotalSizeInMb() + " MB");

        // Visitor 2: search for all .java files
        SearchVisitor searchVisitor = new SearchVisitor(".java");
        root.accept(searchVisitor);

        System.out.println("\nFiles with .java extension:");
        List<File> foundFiles = searchVisitor.getMatchingFiles();
        for (File file : foundFiles) {
            System.out.println("- " + file.getName() + " (" + file.getSizeInMb() + " MB)");
        }
    }
}