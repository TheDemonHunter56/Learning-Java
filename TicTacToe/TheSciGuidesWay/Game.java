package TicTacToe.TheSciGuidesWay;
import java.util.Scanner;

public class Game {
    public static final Board board = new Board();
	public static int currentPlayer = 1;
    public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        while(board.over() == false){
            System.out.println(board);
            System.out.println("It is " + Board.playerToString(currentPlayer) + "'s turn.");
            System.out.println("What row (1 - 3) do you want to move in?");
            int row = sc.nextInt() + -1;
            System.out.println("What column (1 - 3) do you want to move it?");
            int col = sc.nextInt() + -1;
            board.move(currentPlayer, row, col);
            currentPlayer *= -1;
        }
        System.out.println(board);
        if(board.tie()){
            System.out.println("It was a tie. Good game!");
        }else{
            System.out.println("The person playing " + Board.playerToString(board.winner()) + " won. Congradulations on your useless achievement.");
        }
	}
}
