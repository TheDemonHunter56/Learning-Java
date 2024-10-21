package java102;
import java102.PointFile.Point;

public class TriangleFile{
    public static class Triangle{
        public final Point a;
        public final Point b;
        public final Point c;
        /*
        public final double distAB = distance(a, b); //a
        public final double distAC = distance(a, c); //b
        public final double distBC = distance(b, c); //c
        public final double angleA = lawOfCosineAngle(distAB, distAC, distBC);
        public final double angleB = lawOfCosineAngle(distAB, distBC, distAC);
        public final double angleC = lawOfCosineAngle(distAC, distBC, distAB);
        */
        public Triangle(Point a, Point b, Point c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        //public Point circumcenter(){
        //    
        //}
        
    }
}