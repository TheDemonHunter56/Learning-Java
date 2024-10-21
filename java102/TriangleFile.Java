import java102.PointFile.Point;
package java102;


public class TriangleFile{
    public static class Triangle{
        public final Point a;
        public final Point b;
        public final Point c;

        public Triangle(Point a, Point b, Point c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double[] angles(){
            double distAB = distance(a, b); //a
            double distAC = distance(a, c); //b
            double distBC = distance(b, c); //c
            double[] arr = {lawOfCosineAngle(distAB, distAC, distBC),
                            lawOfCosineAngle(distAB, distBC, distAC),
                            lawOfCosineAngle(distAC, distBC, distAB)}
            return arr;
        }
    }
}