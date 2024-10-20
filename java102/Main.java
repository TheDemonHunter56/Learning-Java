package java102;
//import java.util.ArrayList;
import java102.GridClassFile.Grid;
import java102.CircleFile.Circle;
import java102.SquareFile.Square;

public class Main {
    public static void main(String[] args) {
        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(2, 2, 4);
        System.out.println(grid);
        
        Point p1 = new Point(0, 0);
        Circle c1 = new Circle(p1, 5);
        Square s1 = new Square(p1, 5);
        
        System.out.println(c1);
        System.out.println(s1);

    }
    static <T> String arrayToString(T[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        return str + arr[arr.length - 1] + "]";
    }
}
