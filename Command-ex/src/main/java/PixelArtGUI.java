
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PixelArtGUI extends Application {

    private PixelArtModel model;
    private PixelGridView pixelGridView;

    private Command moveUpCommand;
    private Command moveDownCommand;
    private Command moveLeftCommand;
    private Command moveRightCommand;
    private Command togglePixelCommand;
    private Command generateCodeCommand;

    @Override
    public void start(Stage stage) {
        model = new PixelArtModel();

        moveUpCommand = new MoveCursorUpCommand(model);
        moveDownCommand = new MoveCursorDownCommand(model);
        moveLeftCommand = new MoveCursorLeftCommand(model);
        moveRightCommand = new MoveCursorRightCommand(model);
        togglePixelCommand = new TogglePixelCommand(model);
        generateCodeCommand = new GenerateCodeCommand(model);

        pixelGridView = new PixelGridView(model);

        Button createCodeButton = new Button("Create Code");
        createCodeButton.setOnAction(event -> {
            generateCodeCommand.execute();
            pixelGridView.requestFocus();
        });

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pixelGridView, createCodeButton);

        Scene scene = new Scene(root, 500, 500);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                moveUpCommand.execute();
            } else if (event.getCode() == KeyCode.DOWN) {
                moveDownCommand.execute();
            } else if (event.getCode() == KeyCode.LEFT) {
                moveLeftCommand.execute();
            } else if (event.getCode() == KeyCode.RIGHT) {
                moveRightCommand.execute();
            } else if (event.getCode() == KeyCode.SPACE) {
                togglePixelCommand.execute();
            }

            pixelGridView.update();
        });

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        root.requestFocus();
    }
}