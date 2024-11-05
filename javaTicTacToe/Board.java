package javaTicTacToe;
import java.util.Scanner;

public class Board {
    private int[][] arr = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public Board(){
    }

    public int getSpace(int row, int column){
        return arr[row-1][column-1];
    }

    @Override
    public String toString(){
        return arr[0][0] + " | " + arr[0][1] + " | " + arr[0][2] + "\n" + "--|---|--\n" + arr[1][0] + " | " + arr[1][1] + " | " + arr[1][2] + "\n" + "--|---|--\n" + arr[2][0] + " | " + arr[2][1] + " | " + arr[2][2] + "\n";
    }

    public void move(boolean i){
        if(i == true){
            System.out.println("The person playing 1 is up.");
        }else if(i == false){
            System.out.println("The person playing -1 is up.");
        }   
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want your move to be? Please enter the row (1, 2, or 3).\n--> ");
        int row = scan.nextInt();
        while(row > 3 || row < 1){
            System.out.println("That is out of bounds. Please pick a number, 1, 2, or 3.\n--> ");
            row = scan.nextInt();
        }
        System.out.println("And here please put the column.\n--> ");
        int col = scan.nextInt();
        while(col > 3 || col < 1){
            System.out.println("That is out of bounds. Please pick a number, 1, 2, or 3.\n--> ");
            col = scan.nextInt();
        }
        scan.close();
        if(i == true){
            arr[row - 1][col - 1] = 1;
        }else if(i == false){
            arr[row - 1][col - 1] = -1;
        }  

    }

    public int getWinner(){
        int neg1 = 0;
        int pos1 = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(arr[i][j] == -1){
                    neg1 ++;
                }
                if(arr[i][j] == 1){
                    pos1 ++;
                }
            }
        }
        if(neg1 == 3){
            return -1;
        }
        if(pos1 == 3){
            return 1;
        }
        neg1 = 0;
        pos1 = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(arr[j][i] == -1){
                    neg1 ++;
                }
                if(arr[j][i] == 1){
                    pos1 ++;
                }
            }
        }
        if(neg1 == 3){
            return -1;
        }
        if(pos1 == 3){
            return 1;
        }
        neg1 = 0;
        pos1 = 0;
        for(int i = 0; i < 3; i ++){
            if(arr[i][i] == 1){
                pos1 ++;
            }
            if(arr[i][i] == -1){
                neg1 ++;
            }
        }
        if(neg1 == 3){
            return -1;
        }
        if(pos1 == 3){
            return 1;
        }
        neg1 = 0;
        pos1 = 0;
        for(int i = 2; i > -1; i --){
            if(arr[i][i] == 1){
                pos1 ++;
            }
            if(arr[i][i] == -1){
                neg1 ++;
            }
        }
        if(neg1 == 3){
            return -1;
        }
        if(pos1 == 3){
            return 1;
        }
        return 0;
    }
}
