package java102;
import java102.Point;
import java102.Main.Shape;


public class Square implements Shape{
    public final Point corner;
    public final double sideLength;
    
    /**
     * @param boolean
     * @param boolean
     * @return The exclusive or value of the 2 booleans
     */
    public static boolean logicalXOR(boolean x, boolean y) {
        return ( ( x || y ) && ! ( x && y ) );
    }

    /**
    * @param corner The bottom left corner of the square
    * @param sideLength
    */
    public Square(Point corner, double sideLength) {
        this.corner = corner;
        this.sideLength = sideLength;
    }

    public double area() {
        return sideLength * sideLength;
    }
    
    public double perimeter() {
        return sideLength*4;
    }
    
    /** 
    * @return Whether point p is inside of the square.
    */
    public boolean isInside(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return 0 < xDist && xDist < sideLength &&
                0 < yDist && yDist < sideLength;
    }

    /** 
    * @return Whether point p part of/on the border of the square.
    */
    public boolean isOn(Point p) {
        if(logicalXOR(p.x == corner.x, p.y == corner.y) == true){
            return true;
        }else return false;
    }
    
    /** 
    * @param x How much to translate the sqaure by in the + x direction.
    * @param y How much to translate the squarer by in the + y direction.
    * @return The sqaure that results from the translation.
    */
    public Square translate(double x, double y) {
        return new Square(corner.translateX(x).translateY(y), sideLength); //write this
    }

    /** 
    * @return The sqaure that results from scaling the side length and maintaining the bottom left corner
    */
    public Square scale(double k) {
        return new Square(corner, sideLength * k);
    }

    public Point[] corners() {
        Point bottomRight = new Point(corner.x + sideLength, corner.y);
        Point topRight = new Point(corner.x + sideLength, corner.y + sideLength);
        Point topLeft = new Point(corner.x, corner.y + sideLength);
        Point[] arr = {corner, bottomRight, topRight, topLeft};
        return arr;
    }

    @Override
    public String toString() {
        return "(corner: " + corner + "; side length: " + sideLength + ")";
    }
}
