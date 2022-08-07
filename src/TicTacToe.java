import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static boolean checkIfWin(String[][] board) {
        if (board[0][0].equals("x") && board[0][1].equals("x") && board[0][2].equals("x") ||
                board[1][0].equals("x") && board[1][1].equals("x") && board[1][2].equals("x") ||
                board[2][0].equals("x") && board[2][1].equals("x") && board[2][2].equals("x") ||
                board[0][0].equals("x") && board[1][0].equals("x") && board[2][0].equals("x") ||
                board[0][1].equals("x") && board[1][1].equals("x") && board[2][1].equals("x") ||
                board[0][2].equals("x") && board[1][2].equals("x") && board[2][2].equals("x") ||
                board[0][0].equals("x") && board[1][1].equals("x") && board[2][2].equals("x") ||
                board[0][2].equals("x") && board[1][1].equals("x") && board[2][0].equals("x")) {
            System.out.println("krzyżyk wygrał");
            return false;
        } else if (board[0][0].equals("o") && board[0][1].equals("o") && board[0][2].equals("o") ||
                board[1][0].equals("o") && board[1][1].equals("o") && board[1][2].equals("o") ||
                board[2][0].equals("o") && board[2][1].equals("o") && board[2][2].equals("o") ||
                board[0][0].equals("o") && board[1][0].equals("o") && board[2][0].equals("o") ||
                board[0][1].equals("o") && board[1][1].equals("o") && board[2][1].equals("o") ||
                board[0][2].equals("o") && board[1][2].equals("o") && board[2][2].equals("o") ||
                board[0][0].equals("o") && board[1][1].equals("o") && board[2][2].equals("o") ||
                board[0][2].equals("o") && board[1][1].equals("o") && board[2][0].equals("o")) {
            System.out.println("Kółko wygrało");
            return false;
        }
        return true;
    }

    public static boolean checkIfDraw(String[][] board) {
        if (Arrays.deepToString(board).contains("1") ||
                Arrays.deepToString(board).contains("2") ||
                Arrays.deepToString(board).contains("3") ||
                Arrays.deepToString(board).contains("4") ||
                Arrays.deepToString(board).contains("5") ||
                Arrays.deepToString(board).contains("6") ||
                Arrays.deepToString(board).contains("7") ||
                Arrays.deepToString(board).contains("8") ||
                Arrays.deepToString(board).contains("9")) {
            return true;
        }
        System.out.println("remis");
        return false;
    }

    public static String[][] generateBoard() {
        String[][] board = new String[3][3];
        int counter = 1;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = String.valueOf(counter++);
            }
        }
        return board;
    }

    public static String choosePlayer() {
        Random random = new Random();
        String currentPlayer;
        int randomInt = random.nextInt(0, 2);
        if (randomInt == 0) {
            currentPlayer = "x";
        } else {
            currentPlayer = "o";
        }
        return currentPlayer;
    }

    public static String changePlayer(String currentPlayer) {
        if (currentPlayer.equals("x")) {
            currentPlayer = "o";
        } else if (currentPlayer.equals("o")) {
            currentPlayer = "x";
        }
        return currentPlayer;
    }
    public static void showCurrentPlayer(String currentPlayer){
        if (currentPlayer.equals("x")) {
            System.out.println("krzyżyk ma ruch");
        } else {
            System.out.println("kółko ma ruch");
        }

    }

    public static void showBoard(String[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public static void tickTackToeGame() {
        System.out.println("plansze gry przedstawia następujący schemat");
        String currentPlayer = choosePlayer();
        String[][] board = generateBoard();
        showBoard(board);
        Scanner scanner = new Scanner(System.in);
        while (checkIfWin(board) && checkIfDraw(board)) {
            showCurrentPlayer(currentPlayer);

            //sprawdzanie czy podano liczbę
            if (scanner.hasNextInt()) {
                int position = scanner.nextInt();

                //sprawdzanie zajętego miejsca
                if(!Arrays.deepToString(board).contains(String.valueOf(position)) && (position <= 9 && position >=1)){
                    System.out.println("pozycja zajęta");
                }
                //sprawdzanie czy podano właściwą liczbę
                if (position > 9 || position < 1) {
                    System.out.println("podaj liczbę od 1 do 9");

                } else {

                    //przypisanie bieżącego użytkownika do podanego przez niego miejsca
                    for(int row = 0; row < board.length; row++) {
                        for(int col = 0; col < board[row].length; col++) {
                            if (board[row][col].equals(String.valueOf(position))) {
                                board[row][col] = currentPlayer;
                                currentPlayer = changePlayer(currentPlayer);
                                showBoard(board);
                            }
                        }
                    }
                }

            }
            //błąd jeśli nie podano lizcby
            else {
                System.out.println("podaj wlasciwa pozycje");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        tickTackToeGame();
    }
}


