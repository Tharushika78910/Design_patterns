
public class GenerateCodeCommand implements Command {

    private final PixelArtModel model;

    public GenerateCodeCommand(PixelArtModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        System.out.println(model.generateJavaCode());
    }
}