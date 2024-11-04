package javaTicTacToe;

public class Board {
    private int[][] arr = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public Board(){
    }
    public int getSpace(int row, int column){
        return arr[row-1][column-1];
    }
    @Override
    String toString(int[][] arr){
        
        return toString();
    }
}
