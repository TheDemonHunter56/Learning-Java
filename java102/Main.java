package java102;

public class Main {
    public static void main(String[] args) {
        
    }
    public class A {
        protected final double field1;
        protected final double field2;
    
        public A(double field1, double field2) {
            System.out.println("the constructor of A has been called");
            this.field1 = field1;
            this.field2 = field2;
        }
    
        public void method1() {
            System.out.println("method 1 of A has been called");
        }
        
        public void method2() {
            System.out.println("method 2 of A has been called");
        }
    }
    
    public class B extends A {
        public final String bField;
        
        public B(double field1and2, String bField) {
            super(field1and2, field1and2);
            this.bField = bField;
            System.out.println("the constructor of B has been called");
        }
    
        @Override 
        public void method2() {
            System.out.println("method 2 of B has been called");
        }
    
        public double field() {
            return super.field1;
        }
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