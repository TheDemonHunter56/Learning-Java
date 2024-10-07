package java102;
public class Main {
    public static void main(String[] args) {
        Point point = new Point(4, 3);
        Point a = new Point(1, 5);
        Point b = new Point(4, 2);
        System.out.println(Point.distance(a, b));
    }
}
