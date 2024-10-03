package java101;
public class PracticeProblems {
    public static void main(String[] args){

    }
    static double f(double x) {
        return 2 * x;
    }

    static void printIntArray(int[] arr) {
        String str = "(";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i != arr.length - 1) {
                str += ", ";
            }
        }
        str += ")";
        System.out.println(str);
    }

    static String intArrToString(int[] arr) {
        String str = "(";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i != arr.length - 1) {
                str += ", ";
            }
        }
        return str + ")";
    }

    static int countOccurrences(int[] arr, int n){
        int counter = 0;
        for (int x : arr){
            if (x == n){
                counter ++;
            }
        }
        return counter;
    }
    static int[] reverseArray(int[] arr){
        int[] newArr = new int[arr.length];
        int i = 0;
        for (int e : arr){
            newArr[arr.length -1 - i] = e;
            i ++;
        }
        return newArr;
    }
    static int sumGrid(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++ ){
            for(int g = 0; g < arr[i].length; g++){
                sum += arr[i][g];
            }
        }
        return sum;
    }
    static int fib(int n){
        int a = 0;
        int b = 1;
        int c = a + b;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        for (int i = 0; i < n -1; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    
}

