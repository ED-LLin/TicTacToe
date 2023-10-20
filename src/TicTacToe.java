import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        int position;
        char userSign = 'O';
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);

        while (true) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9)");
            position = scan.nextInt();

            if(isValidMove(gameBoard, position)){
                placeSign(gameBoard, position, userSign);
            } else {
                System.out.println("Not valid move, try again.");
                break;
            }

            printGameBoard(gameBoard);

            if (checkWin(gameBoard)) {
                System.out.println("Player " + userSign + " wins!");
                break;
            } else if (checkDraw(gameBoard)) {
                System.out.println("It's a draw.");
                break;
            }

            userSign = takeTurn(userSign); // 要放在 checkWin 之後，不然會換了玩家後才 print Win
        }

    }


    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placeSign(char[][] gameBoard, int position, char userSign) {
        //如果條件沒有進入 if else ，就可以返回這是不合理的位置值
        int row = -1;
        int col = -1;

        // 計算 row 和 col
        if (position == 1 || position == 2 || position == 3) {
            row = 0;
        } else if (position == 4 || position == 5 || position == 6) {
            row = 2;
        } else if (position == 7 || position == 8 || position == 9) {
            row = 4;
        }

        if (position == 1 || position == 4 || position == 7) {
            col = 0;
        } else if (position == 2 || position == 5 || position == 8) {
            col = 2;
        } else if (position == 3 || position == 6 || position == 9) {
            col = 4;
        }

        gameBoard[row][col] = userSign;
    }

    public static char takeTurn(char userSign) {
        if(userSign == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }
    public static boolean checkWin(char[][] gameBoard) {

        for (int i = 0; i < 5; i += 2) {
            // 檢查行獲勝，且元素非空值
            if (
                    gameBoard[i][0] != ' ' && (gameBoard[i][0] == gameBoard[i][2]) && (gameBoard[i][2] == gameBoard[i][4])
            ) {
                return true;
            }
            if (
                    gameBoard[0][i] != ' ' && (gameBoard[0][i] == gameBoard[2][i]) && (gameBoard[2][i] == gameBoard[4][i])
            ) {
                return true;
            }
        }

        if (gameBoard[0][0] != ' ' && (gameBoard[0][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][4])) {
            return true;
        }
        if (gameBoard[4][0] != ' ' && (gameBoard[4][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[0][4])) {
            return true;
        }
        return false;
    }

    public static boolean checkDraw(char[][] gameBoard) {

        for (int i = 0; i <= 4; i += 2) {
            for (int j = 0; j <= 4; j += 2) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(char[][] gameBoard, int position){
        int row = -1;
        int col = -1;

        // 計算 row 和 col
        if (position == 1 || position == 2 || position == 3) {
            row = 0;
        } else if (position == 4 || position == 5 || position == 6) {
            row = 2;
        } else if (position == 7 || position == 8 || position == 9) {
            row = 4;
        }

        if (position == 1 || position == 4 || position == 7) {
            col = 0;
        } else if (position == 2 || position == 5 || position == 8) {
            col = 2;
        } else if (position == 3 || position == 6 || position == 9) {
            col = 4;
        }

        if ((row >= 0 && row <= 4) && (col >= 0 && col <= 4) && gameBoard[row][col] == ' ' ){
            return true;
        } else {
            return false;
        }
    }
}