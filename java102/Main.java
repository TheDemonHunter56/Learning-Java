package java102;

import java.util.ArrayList;

public class Main {
    public static double lawOfCosine(double a, double b, double c){
        double result = Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/2*a*b);
        return result;
    }
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        arr.set(0, "Goodbye");
        
        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));
    }
    
}
