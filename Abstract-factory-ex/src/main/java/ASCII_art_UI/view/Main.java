package ASCII_art_UI.view;

public class Main {

    public static void main(String[] args) {

        //UIFactory factory = new AFactory();
        UIFactory factory = new BFactory();

        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Enter name");
        Checkbox checkbox = factory.createCheckbox("I agree");

        System.out.println("=== Initial UI ===");
        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n=== Update text using setText() ===");
        button.setText("Submit");
        textField.setText("Enter email");
        checkbox.setText("Accept terms");

        // show change
        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n=== Toggle checkbox (extra) ===");
        if (checkbox instanceof CheckboxA ca) {
            ca.setChecked(true);
        } else if (checkbox instanceof CheckboxB cb) {
            cb.setChecked(true);
        }
        checkbox.display();
    }
}
