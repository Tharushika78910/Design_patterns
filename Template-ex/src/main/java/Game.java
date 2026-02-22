public abstract class Game {

    // TEMPLATE METHOD (framework algorithm)
    public final void play(int numberOfPlayers) {
        initializeGame(numberOfPlayers);
        int playerInTurn = 0;

        while (!endOfGame()) {
            playSingleTurn(playerInTurn);
            playerInTurn = ++playerInTurn % numberOfPlayers;
        }

        displayWinner();
    }

    // PRIMITIVE OPERATIONS (to be implemented by subclasses)
    public abstract void initializeGame(int numberOfPlayers);
    public abstract boolean endOfGame();
    public abstract void playSingleTurn(int player);
    public abstract void displayWinner();
}