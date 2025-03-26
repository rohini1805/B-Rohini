import java.util.Scanner;

public class ConnectFour {
    static char[][] board = new char[6][7]; // 6 rows and 7 columns
    static char currentPlayer = 'R'; // Start with Red player (R)
    static boolean gameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the board with empty spaces
        initializeBoard();

        while (!gameOver) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn:");
            System.out.print("Enter column (0-6): ");
            int column = scanner.nextInt();

            if (column >= 0 && column < 7) {
                if (dropDisc(column)) {
                    // Check for a winner
                    if (checkWinner()) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    } else if (isBoardFull()) {
                        // Check for a tie
                        printBoard();
                        System.out.println("It's a tie!");
                        gameOver = true;
                    } else {
                        // Switch player
                        currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
                    }
                } else {
                    System.out.println("Column is full! Try another column.");
                }
            } else {
                System.out.println("Invalid column! Please enter a number between 0 and 6.");
            }
        }

        scanner.close();
    }

    // Initialize the board with empty spaces
    public static void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current state of the board
    public static void printBoard() {
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }

    // Drop a disc into the chosen column
    public static boolean dropDisc(int column) {
        // Start from the bottom of the column and look for an empty space
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = currentPlayer;
                return true;
            }
        }
        return false; // Column is full
    }

    // Check if there is a winner
    public static boolean checkWinner() {
        // Check horizontal, vertical, and diagonal directions for a win
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == currentPlayer) {
                    if (checkDirection(row, col, 1, 0) || // Horizontal
                        checkDirection(row, col, 0, 1) || // Vertical
                        checkDirection(row, col, 1, 1) || // Diagonal /
                        checkDirection(row, col, 1, -1)) { // Diagonal \
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Check for four discs in a given direction
    public static boolean checkDirection(int row, int col, int dRow, int dCol) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (r >= 0 && r < 6 && c >= 0 && c < 7 && board[r][c] == currentPlayer) {
                count++;
            } else {
                break;
            }
        }
        return count == 4;
    }

    // Check if the board is full (tie condition)
    public static boolean isBoardFull() {
        for (int i = 0; i < 7; i++) {
            if (board[0][i] == ' ') {
                return false;
            }
        }
        return true;
    }
}
