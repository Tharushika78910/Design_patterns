
public class MoveCursorDownCommand implements Command {

    private final PixelArtModel model;

    public MoveCursorDownCommand(PixelArtModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveCursorDown();
    }
}