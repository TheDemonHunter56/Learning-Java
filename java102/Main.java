package java102;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        arr.set(0, "Goodbye");
        
        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));

        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            intArr.add(0);
        }
        System.out.println(intArr.size());
        System.out.println(intArr.get(32));
    }
    
}
