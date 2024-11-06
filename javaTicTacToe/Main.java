package javaTicTacToe;

public class Main {
    public static void main(String args[]){
        int counter = 0;
        Board board = new Board();
        boolean i = true;
        while(board.getWinner() == 0){
            System.out.println(board);
            board.move(i);
            i = !i;
            counter ++;
            if(counter == 9 && board.getWinner() == 0){
                System.out.println("It's a tie!");
                break;
            }
        }
    }
}