package java102;

public class ShapeInter {
    public static interface Shape {
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

        static Shape[] scaleAll(Shape[] shapes, double k) {
            Shape[] scaled = new Shape[shapes.length];
            for (int i = 0; i < shapes.length; i++) {
                scaled[i] = ((Shape) shapes[i]).scale(k);
            }
            return scaled;
        }

        static double sumArea(ShapeInter[] shapes) {
            double sum = 0;
            for (ShapeInter shape : shapes) {
                sum += ((Shape) shape).area();
            }
            return sum;
        }
    }
}

