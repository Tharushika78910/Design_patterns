import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame extends Game {

    private int numberOfPlayers;
    private int secretNumber;
    private boolean gameEnded;
    private int winnerPlayerIndex; // 0..(numberOfPlayers-1)

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers <= 0) {
            throw new IllegalArgumentException("numberOfPlayers must be >= 1");
        }

        this.numberOfPlayers = numberOfPlayers;
        this.secretNumber = new Random().nextInt(100) + 1; // 1..100
        this.gameEnded = false;
        this.winnerPlayerIndex = -1;

        System.out.println("==================================");
        System.out.println("     Number Guessing Game");
        System.out.println("==================================");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("Guess the secret number (1..100).");
        System.out.println("Take turns. First correct guess wins!");
        System.out.println("----------------------------------");
    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.print("Player " + (player + 1) + ", enter your guess: ");

        int guess = readIntSafely();

        if (guess == secretNumber) {
            gameEnded = true;
            winnerPlayerIndex = player;
            System.out.println("Correct! 🎉");
        } else if (guess < secretNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }

        System.out.println();
    }

    @Override
    public void displayWinner() {
        System.out.println("==================================");
        if (winnerPlayerIndex >= 0) {
            System.out.println("Winner: Player " + (winnerPlayerIndex + 1));
        } else {
            System.out.println("No winner.");
        }
        System.out.println("Secret number was: " + secretNumber);
        System.out.println("==================================");
    }

    // Helper method: makes input safer (still simple)
    private int readIntSafely() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // discard invalid token
        }
        return scanner.nextInt();
    }
}