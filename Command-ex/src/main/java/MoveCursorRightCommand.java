
public class MoveCursorRightCommand implements Command {

    private final PixelArtModel model;

    public MoveCursorRightCommand(PixelArtModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveCursorRight();
    }
}