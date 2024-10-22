package java102;
import java102.Main.Shape;

public class RTriangle implements Shape{
    public final Point a;
    public final Point rightPoint;
    public final Point c;

    public RTriangle(Point rightPoint, Point a, Point c){
        this.rightPoint = rightPoint;
        this.a = a;
        this.c = c;
    }

    public double[] distances(){
        double distAB = Point.distance(a, rightPoint); //a
        double distAC = Point.distance(a, c); //hypotenuse
        double distBC = Point.distance(rightPoint, c); //c
        double[] arr = {distAB, distAC, distBC};
        return arr;
    }

    public double perimeter(){
        double distAB = distances()[0];
        double distAC = distances()[1];
        double distBC = distances()[2];
        return distAB + distAC + distBC;
    }

    public double area(){
        double distAB = distances()[0];
        double distBC = distances()[2];
        return distAB * distBC;
    }

    public RTriangle translate(double h, double k){
        RTriangle RT1 = new RTriangle(rightPoint.translateX(h).translateY(k), a.translateX(h).translateY(k), c.translateX(h).translateY(k));
        return RT1;
    }

    public boolean isInside(Point input){
        return input.y < (a.y-c.y)/(a.x-c.x)*input.x + a.y;
    }

    public boolean isOn(Point input){
        boolean onHyp = input.y < (a.y-c.y)/(a.x-c.x)*input.x + a.y;
        boolean onAB;
        boolean onBC;
        if (input.y == rightPoint.y){
            onAB = true;
        }else onAB = false;
        if (input.x == rightPoint.x){
            onBC = true;
        }else onBC = false;
        return onHyp || onAB || onBC;
    }

    public RTriangle scale(double k){
        Point aPrime = new Point(a.x * k, a.y * k);
        Point cPrime = new Point(c.x * k, c.y * k);
        return new RTriangle(aPrime, rightPoint, cPrime);
    }
}
