
public class MoveCursorLeftCommand implements Command {

    private final PixelArtModel model;

    public MoveCursorLeftCommand(PixelArtModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveCursorLeft();
    }
}