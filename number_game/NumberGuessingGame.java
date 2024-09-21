package projects.number_game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private int targetNumber;
    private int maxAttempts;
    private int score;
    private int roundsPlayed;
    private Scanner scanner;

    public NumberGuessingGame(int min, int max, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.score = 0;
        this.roundsPlayed = 0;
        this.scanner = new Scanner(System.in);
        generateNumber(min, max);
    }

    private void generateNumber(int min, int max) {
        Random random = new Random();
        this.targetNumber = random.nextInt(max - min + 1) + min;
    }

    // Play a single round of guessing
    public boolean playRound(int min, int max) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.printf("Attempt %d/%d: Enter your guess between %d and %d: ", attempts + 1, maxAttempts, min, max);
            int guess = scanner.nextInt();

            if (guess < targetNumber) {
                System.out.println("Too low!");
            } else if (guess > targetNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed the number.");
                score++;
                return true;
            }
            attempts++;
        }
        System.out.println("Out of attempts! The correct number was " + targetNumber);
        return false;
    }

    public void playGame(int min, int max) {
        boolean playAgain = true;
        while (playAgain) {
            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed);
            generateNumber(min, max);
            playRound(min, max);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame over! Rounds played: " + roundsPlayed + ", Score: " + score);
        scanner.close();
    }

    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        NumberGuessingGame game = new NumberGuessingGame(min, max, maxAttempts);
        game.playGame(min, max);
    }
}

