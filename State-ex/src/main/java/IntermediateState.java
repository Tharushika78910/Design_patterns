
public class IntermediateState implements CharacterState {
    private final GameCharacter character;

    public IntermediateState(GameCharacter character) {
        this.character = character;
        System.out.println("=== Level Up! You are now Intermediate. Meditate unlocked. ===");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void train() {
        int gain = 12;
        character.addExperience(gain);
        System.out.println("You train with better technique. +" + gain + " EXP");
        character.checkForLevelUp();
    }

    @Override
    public void meditate() {
        int heal = 15;
        character.addHealth(heal);
        System.out.println("You meditate calmly. +" + heal + " HP");
    }

    @Override
    public void fight() {
        System.out.println("You are not ready to fight. (Unlocks at Expert)");
    }

    @Override
    public String availableActions() {
        return "[1] Train  [2] Meditate";
    }

    @Override
    public boolean isTerminal() {
        return false;
    }
}