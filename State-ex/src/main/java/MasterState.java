
public class MasterState implements CharacterState {
    private final GameCharacter character;

    public MasterState(GameCharacter character) {
        this.character = character;
        System.out.println("=== LEGEND! You reached Master level. Game Over. ===");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void train() {
        System.out.println("You have mastered all skills. No more training needed.");
    }

    @Override
    public void meditate() {
        System.out.println("Your mind is perfectly calm already.");
    }

    @Override
    public void fight() {
        System.out.println("No battles remain. You are the Master.");
    }

    @Override
    public String availableActions() {
        return "(No actions - Master reached)";
    }

    @Override
    public boolean isTerminal() {
        return true;
    }
}