
public interface CharacterState {
    String getLevelName();

    void train();
    void meditate();
    void fight();

    String availableActions();
    boolean isTerminal(); // true when Master
}