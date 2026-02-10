
public class NoviceState implements CharacterState {
    private final GameCharacter character;

    public NoviceState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void train() {
        int gain = 10;
        character.addExperience(gain);
        System.out.println("You train hard. +" + gain + " EXP");
        character.checkForLevelUp();
    }

    @Override
    public void meditate() {
        System.out.println("You don't know how to meditate yet. (Unlocks at Intermediate)");
    }

    @Override
    public void fight() {
        System.out.println("You are not ready to fight. (Unlocks at Expert)");
    }

    @Override
    public String availableActions() {
        return "[1] Train";
    }

    @Override
    public boolean isTerminal() {
        return false;
    }
}