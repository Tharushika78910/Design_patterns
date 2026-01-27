package ASCII_art_UI.view;

public abstract class Checkbox extends UIElement {

    protected boolean checked;

    public Checkbox(String text) {
        super(text);
        this.checked = false;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
