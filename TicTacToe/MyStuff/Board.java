package TicTacToe.MyStuff;


public class Board {
    public int[][] arr = new int[3][3];

    public int getSpace(int row, int column){
        return arr[row-1][column-1];
    }

    @Override
    public String toString(){
        return arr[0][0] + " | " + arr[0][1] + " | " + arr[0][2] + "\n" + "----------\n" + arr[1][0] + " | " + arr[1][1] + " | " + arr[1][2] + "\n" + "----------\n" + arr[2][0] + " | " + arr[2][1] + " | " + arr[2][2] + "\n";
    }

    public void move(int row, int col, boolean i) {
        while (true) {
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Out of bounds! Enter values between 1 and 3.");
            } else if (arr[row - 1][col - 1] != 0) {
                System.out.println("Space already taken! Choose another.");
            } else {
                break; // Valid move, exit the loop
            }
        }
        arr[row - 1][col - 1] = i ? 1 : -1; // Set move on board
    }

    public int getWinner() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] != 0) {
                System.out.println("Player playing " + arr[i][0] + " wins by winning a row!");
                return arr[i][0];
            }
            // Check columns
            if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[0][i] != 0) {
                System.out.println("Player playing " + arr[0][i] + " wins by winning a column!");
                return arr[0][i];
            }
        }

        // Check diagonals
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] != 0) {
            System.out.println("Player playing " + arr[0][0] + " wins by winning the diagonal from top left to bottom right!");
            return arr[0][0];
        }
        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] != 0) {
            System.out.println("Player playing " + arr[0][2] + " wins by winning the diagonal from the top right to bottom left!");
            return arr[0][2];
        }

        return 0;
    }
}
