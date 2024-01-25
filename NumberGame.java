package codsoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        playNumberGame();
    }

    public static void playNumberGame() {
        Scanner scanner = new Scanner(System.in);
       
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        int attemptsLimit = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        do {
            System.out.printf("Guess the number between %d and %d: ", lowerLimit, upperLimit);
            int userGuess = scanner.nextInt();

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number " + secretNumber + "!");
                totalAttempts += (10 - attemptsLimit) + 1;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low. Try again!");
            } else {
                System.out.println("Too high. Try again!");
            }

            attemptsLimit--;

            if (attemptsLimit == 0) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
                break;
            }

        } while (true);

        roundsPlayed++;

        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();

        if (playAgain.equals("yes")) {
            playNumberGame();
        } else {
            System.out.println("Game over! Rounds played: " + roundsPlayed + ". Total attempts: " + totalAttempts + ".");
        }

        scanner.close();
    }
}

