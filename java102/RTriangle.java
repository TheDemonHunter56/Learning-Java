package java102;
import java102.Main.Shape;
import java.util.Arrays;

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

    public double[] angles(){
        double distAB = distances()[0];
        double distAC = distances()[1];
        double distBC = distances()[2];
        double angleA = Point.lawOfCosineAngle(distAB, distAC, distBC);
        double angleB = Point.lawOfCosineAngle(distAB, distBC, distAC);
        double angleC = Point.lawOfCosineAngle(distAC, distBC, distAB);
        double [] arr = {angleA, angleB, angleC};
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

    public static boolean similar(RTriangle rt1, RTriangle rt2){
        double[] rt1Sides = rt1.distances();
        java.util.Arrays.sort(rt1Sides);
        double[] rt1Angles = rt1.angles();

        double[] rt2Sides = rt2.distances();
        java.util.Arrays.sort(rt2Sides);
        double[] rt2Angles = rt2.angles();
        int counter = 0;
        
        //AA similarity
        outerloop: for (double i : rt1Angles){
            for (double g : rt2Angles){
                if (i == g){
                    counter ++;
                }
                if(counter == 2){
                    return true;
                }else continue outerloop;
            }
        }
        //SSS similarity
        double a = rt1Sides[0]/rt2Sides[0];
        double b = rt1Sides[1]/rt2Sides[1];
        double c = rt1Sides[2]/rt2Sides[2];
        if (a == b && b == c){
            return true;
        }
        //SAS, ASS, SSA similarity - ratios are the same and both triangles have a right angle
        if((Math.abs(a-b) < 1e-6) || (Math.abs(a-c) < 1e-6) || (Math.abs(b-c) < 1e-6)){
            return true;
        }
        return false;
    }
}
