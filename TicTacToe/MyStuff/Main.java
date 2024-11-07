package TicTacToe.MyStuff;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int counter = 0;
        int player = 0;
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        boolean i = false;
        while(board.getWinner() == 0){
            System.out.println(board);
            i = !i;
            player = i ? 1 : -1;
            System.out.println("Player playing " + player + " is up. What row do you want your move to be in?\n");
            int row = scan.nextInt();
           
            System.out.println("What column do you want your move to be in?\n");
            int col = scan.nextInt();

            board.move(row, col, i);
            counter ++;
            if(counter == 9 && board.getWinner() == 0){
                System.out.println("It's a tie!");
                break;
            }
        }
        scan.close();
    }
}