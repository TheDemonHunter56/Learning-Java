package javaTicTacToe;

public class Main {
    public static void main(String args[]){
        Board board = new Board();
        boolean i = true;
        while(board.getWinner() == 0){
            board.move(i);
            i = !i;
            System.out.println(board);
        }
        board.closeScanner();
    }
}