
public class GameCharacter {
    private final String name;
    private int experience;
    private int health;

    private CharacterState state;

    public static final int NOVICE_TO_INTERMEDIATE_EXP = 30;
    public static final int INTERMEDIATE_TO_EXPERT_EXP = 80;
    public static final int EXPERT_TO_MASTER_EXP = 150;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 50; // starting HP
        this.state = new NoviceState(this);
    }

    // Delegation to state
    public void train() { state.train(); }
    public void meditate() { state.meditate(); }
    public void fight() { state.fight(); }

    public void setState(CharacterState newState) {
        this.state = newState;
    }

    public CharacterState getState() {
        return state;
    }

    // helpers used by states
    public void addExperience(int amount) {
        experience += Math.max(0, amount);
    }

    public void addHealth(int amount) {
        health += amount;
        if (health < 0) health = 0;
        if (health > 100) health = 100; // cap HP
    }

    public int getExperience() { return experience; }
    public int getHealth() { return health; }
    public String getName() { return name; }

    public String statusLine() {
        return String.format(
                "Name: %s | Level: %s | EXP: %d | HP: %d",
                name, state.getLevelName(), experience, health
        );
    }

    public void checkForLevelUp() {
        if (state instanceof MasterState) return;

        if (experience >= EXPERT_TO_MASTER_EXP && !(state instanceof MasterState)) {
            setState(new MasterState(this));
            return;
        }
        if (experience >= INTERMEDIATE_TO_EXPERT_EXP && !(state instanceof ExpertState)) {
            setState(new ExpertState(this));
            return;
        }
        if (experience >= NOVICE_TO_INTERMEDIATE_EXP && !(state instanceof IntermediateState)) {
            setState(new IntermediateState(this));
        }
    }
}
