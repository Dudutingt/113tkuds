import java.util.Scanner;

public class TicTacToe5x5 {
    public static void main(String[] args) {
        final int SIZE = 5;
        char[][] board = new char[SIZE][SIZE];
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 5x5 井字遊戲 ===");
        initializeBoard(board);
        printBoard(board);

        char currentPlayer = 'X';
        int moves = 0;
        boolean gameEnded = false;

        while (!gameEnded) {
            int row, col;

            while (true) {
                try {
                    row = sc.nextInt();
                    col = sc.nextInt();
                } catch (Exception e) {
                    sc.nextLine(); // clear buffer
                    System.out.println("請輸入兩個整數！");
                    continue;
                }

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("座標超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("此位置已有棋子，請重新輸入！");
                } else {
                    break;
                }
            }

            board[row][col] = currentPlayer;
            moves++;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard(board);

            if (checkWin(board, currentPlayer)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                gameEnded = true;
            } else if (moves == SIZE * SIZE) {
                System.out.println("平手！");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
    }

    static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int j = 0; j < board.length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean checkWin(char[][] board, char player) {
        int size = board.length;

        
        for (int i = 0; i < size; i++) {
            if (allMatch(board[i][0], board[i][1], board[i][2], board[i][3], board[i][4], player)) return true;
            if (allMatch(board[0][i], board[1][i], board[2][i], board[3][i], board[4][i], player)) return true;
        }

        
        if (allMatch(board[0][0], board[1][1], board[2][2], board[3][3], board[4][4], player)) return true;

        
        if (allMatch(board[0][4], board[1][3], board[2][2], board[3][1], board[4][0], player)) return true;

        return false;
    }

    static boolean allMatch(char a, char b, char c, char d, char e, char target) {
        return a == target && b == target && c == target && d == target && e == target;
    }
}
