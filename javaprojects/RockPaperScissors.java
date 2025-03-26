import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Display the game rules
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice: rock, paper, or scissors.");
        System.out.println("To exit the game, type 'exit'.");

        while (true) {
            // Get the player's choice
            System.out.print("Your choice: ");
            String playerChoice = scanner.nextLine().toLowerCase();

            // Exit condition
            if (playerChoice.equals("exit")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            // Validate the player's input
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid input. Please choose rock, paper, or scissors.");
                continue;
            }

            // Computer's choice (randomly selected)
            int computerChoiceInt = random.nextInt(3);  // 0 = rock, 1 = paper, 2 = scissors
            String computerChoice = "";
            switch (computerChoiceInt) {
                case 0:
                    computerChoice = "rock";
                    break;
                case 1:
                    computerChoice = "paper";
                    break;
                case 2:
                    computerChoice = "scissors";
                    break;
            }

            // Display the choices
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                       (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                       (playerChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
