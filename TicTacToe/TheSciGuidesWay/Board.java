package TicTacToe.TheSciGuidesWay;

import javax.management.RuntimeErrorException;

public class Board {
    public final int[][] board = new int[3][3];

    public static String playerToString(int player) {
        if (player == -1) {
            return "O";
        } else if (player == 0) {
            return "-";
        } else if (player == 1) {
            return "X";
        } else {
            throw new RuntimeException("not a valid player: " + player);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int[] row : board) {
            for (int square : row) {
                str += playerToString(square) + " ";
            }
            str += "\n";
        }
        return str;
    }

    public int get(int row, int column) {
        return board[row][column];
    }

    public void move(int player, int row, int column){
        if(get(row, column) != 0){
            throw new RuntimeException("Square is full! Please pick another.");
        }
        if(player != 1 && player != -1){
            throw new RuntimeException("That is not a valid player! Please pick -1(O) or 1(X).");
        }
        board[row][column] = player;
    }

    
}
