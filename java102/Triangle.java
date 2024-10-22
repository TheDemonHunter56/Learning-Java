package java102;

public class Triangle{
    public final Point a;
    public final Point b;
    public final Point c;

    public double[] distances(){
        double distAB = Point.distance(a, b); //a
        double distAC = Point.distance(a, c); //b
        double distBC = Point.distance(b, c); //c
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
        double [] arr = {distAB, distAC, distBC, angleA, angleB, angleC};
        return arr;
    }
    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point circumcenter(){
        double angleA = angles()[0];
        double angleB = angles()[1];
        double angleC = angles()[2];
        double xPrime = a.x*Math.sin(angleA*Math.PI/90) + b.x*Math.sin(angleB*Math.PI/90) + c.x*Math.sin(angleC*Math.PI/90)/Math.sin(angleA*Math.PI/90) + Math.sin(angleB*Math.PI/90) + Math.sin(angleC*Math.PI/90);
        double yPrime = a.y*Math.sin(angleA*Math.PI/90) + b.y*Math.sin(angleB*Math.PI/90) + c.y*Math.sin(angleC*Math.PI/90)/Math.sin(angleA*Math.PI/90) + Math.sin(angleB*Math.PI/90) + Math.sin(angleC*Math.PI/90);
        Point circumcenter = new Point(xPrime, yPrime);
        return circumcenter;
    }
    
}