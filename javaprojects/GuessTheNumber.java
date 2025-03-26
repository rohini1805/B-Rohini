import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Random number between 1 and 100
        int numberToGuess = (int) (Math.random() * 100) + 1;
        int numberOfTries = 0;
        int userGuess = 0;

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Game introduction
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");

        // Loop until the user guesses the number
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfTries++;

            // Check if the guess is too low, too high, or correct
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
                System.out.println("It took you " + numberOfTries + " tries.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}