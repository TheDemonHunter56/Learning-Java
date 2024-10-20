package java102;
import java.util.ArrayList;

import java102.GridClass.Grid;

public class Main {
    public static void main(String[] args) {
        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(2, 2, 4);
        System.out.println(grid);
    }
}
