package ASCII_art_UI.view;

public interface UIFactory {

    Button createButton(String text);

    TextField createTextField(String text);

    Checkbox createCheckbox(String text);
}
