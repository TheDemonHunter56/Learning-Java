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
    }
}


/*
 * 2d array of int, -1, 0, 1 done
 * toString to print board done
 * get space method done
 * move method - error if space is full, game is over, if not given valid place, if not valid player
 * getWinner method done
 */