
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) name = "Hero";

        GameCharacter c = new GameCharacter(name);

        while (!c.getState().isTerminal()) {
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println(c.statusLine());
            System.out.println("Available actions: " + c.getState().availableActions());
            System.out.println("[0] Quit");
            System.out.print("Choose: ");

            String input = sc.nextLine().trim();

            switch (input) {
                case "1" -> c.train();
                case "2" -> c.meditate();
                case "3" -> c.fight();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println();
        System.out.println("Final Status: " + c.statusLine());
        sc.close();
    }
}