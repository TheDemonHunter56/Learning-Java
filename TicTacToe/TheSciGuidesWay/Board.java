package TicTacToe.TheSciGuidesWay;

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
    /** @return whether a set of three spaces are won by one player */
    private static boolean setWon(int a, int b, int c) {
        return a != 0 && a == b && b == c;
    }

    /** @return Whether the ith row or column has been won */
    private boolean rowOrColWon(int i) {
        return setWon(board[i][0], board[i][1], board[i][2]) ||
            setWon(board[0][i], board[1][i], board[2][i]);
    }

    /** @return Whether either of the diagonals has been won */
    private boolean diagonalWon() {
        return setWon(board[0][0], board[1][1], board[2][2]) || setWon(board[0][2], board[1][1], board[2][0]);
    }

    public int winner() {
        for (int i = 0; i < 3; i++) {
            if (rowOrColWon(i)) {
                return board[i][i];
            }
        }
        if (diagonalWon()) {
            return board[1][1];
        }
        return 0;
    }
    
    public boolean over(){
        if(winner() != 0){
            return true; 
        }
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return false;
    }
}

