package ASCII_art_UI.view;

public class ButtonA extends Button {

    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = " " + text + " ";
        System.out.println("+" + "-".repeat(content.length()) + "+");
        System.out.println("|" + content + "|");
        System.out.println("+" + "-".repeat(content.length()) + "+");
    }
}
