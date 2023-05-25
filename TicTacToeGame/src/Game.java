import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for (int row = 0; row <board.length ; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col]=' ';
            }
        }


        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            prinBoard(board);
            System.out.print("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player; // place the element
                gameOver = haswon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won: ");
                } else {
                    // if (player == 'X') {
                    // player = 'O';
                    // } else {
                    // player = 'X';
                    // }
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
        prinBoard(board);
    }

    private static boolean haswon(char[][] board, char player) {

        for (int row = 0; row < board.length; row++) {
            if(board[row][0] ==player && board[row][1]==player && board[row][2]==player) return true;
        }
        for (int Col = 0; Col < board.length; Col++) {
            if(board[0][Col] ==player && board[1][Col]==player && board[2][Col]==player) return true;
        }
        if (board[0][0] == player && board[1][1]== player && board[2][2]==player) return true;
        if (board[1][0] == player && board[1][1]== player && board[2][0]==player) return true;
        return false;
    }

    private static void prinBoard(char[][] board) {
        for (int row = 0; row <board.length ; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]+" "+" |");
            }
            System.out.println();
        }
    }
}
