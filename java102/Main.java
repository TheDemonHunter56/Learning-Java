package java102;
import java.util.ArrayList;
import java102.GridClassFile.Grid;
import java102.CircleFile.Circle;
import java102.SquareFile.Square;
import java102.PointFile.Point;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);

        Grid<Integer> grid = new Grid<>(5, 0);
        grid.get(0, 0);

        Shape[] shapes = {new Circle(new Point(1.8, -20), 2), 
            new Square(new Point(100, 2.1), 5.4),
            new Circle(new Point(0, 0), 1),
            new Circle(new Point(4, 9.123), 98.32),
            new Square(new Point(-321, 0), 0.02)};
        System.out.println(sumArea(shapes));

    }
    static <T> String arrayToString(T[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        return str + arr[arr.length - 1] + "]";
    }
    public interface Shape {
        double area();

        public double perimeter();

        /** 
        * @return Whether point p is inside of the shape.
        */
        public boolean isInside(Point p);
       
        /** 
        * @return Whether point p part of/on the border of the shape.
        */
        public boolean isOn(Point p);

        /** 
        * @param x How much to translate the shape by in the + x direction.
        * @param y How much to translate the shape by in the + y direction.
        * @return The shape that results from the translation.
        */
        public Shape translate(double x, double y);
        
        /** 
        * @return The shape that results from scaling by k.
        */
        public Shape scale(double k);
    }
    static Shape[] scaleAll(Shape[] shapes, double k) {
        Shape[] scaled = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            scaled[i] = shapes[i].scale(k);
        }
        return scaled;
    }
    static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }
}