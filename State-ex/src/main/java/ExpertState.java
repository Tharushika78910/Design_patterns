
import java.util.Random;

public class ExpertState implements CharacterState {
    private final GameCharacter character;
    private final Random rnd = new Random();

    public ExpertState(GameCharacter character) {
        this.character = character;
        System.out.println("=== Level Up! You are now Expert. Fight unlocked. ===");
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void train() {
        int gain = 15;
        character.addExperience(gain);
        System.out.println("You refine advanced skills. +" + gain + " EXP");
        character.checkForLevelUp();
    }

    @Override
    public void meditate() {
        int heal = 12;
        character.addHealth(heal);
        System.out.println("You meditate like a pro. +" + heal + " HP");
    }

    @Override
    public void fight() {
        if (character.getHealth() <= 0) {
            System.out.println("You are too weak to fight. Meditate first!");
            return;
        }

        // Fighting: lose HP, gain EXP
        int hpLoss = 8 + rnd.nextInt(8);     // 8..15
        int expGain = 18 + rnd.nextInt(10);  // 18..27

        character.addHealth(-hpLoss);
        character.addExperience(expGain);

        System.out.println("You fight fiercely! -" + hpLoss + " HP, +" + expGain + " EXP");

        if (character.getHealth() == 0) {
            System.out.println("You collapsed from exhaustion (HP = 0). You can still train/meditate.");
        }

        character.checkForLevelUp();
    }

    @Override
    public String availableActions() {
        return "[1] Train  [2] Meditate  [3] Fight";
    }

    @Override
    public boolean isTerminal() {
        return false;
    }
}