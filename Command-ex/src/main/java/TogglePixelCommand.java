
public class TogglePixelCommand implements Command {

    private final PixelArtModel model;

    public TogglePixelCommand(PixelArtModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.togglePixel();
    }
}