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
            OUTERLOOP: for(int k = 0; k < 3; k ++){
                for(int j = 0; j < 3; j ++){
                    if(board.arr[k][j] != 0){
                        counter ++;
                    }else{
                        break OUTERLOOP;
                    }
                }
            }
            if(counter == 9 && board.getWinner() == 0){
                System.out.println("Its a tie!");
            }
        }
        board.closeScanner();
    }
}