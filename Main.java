public class Main {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(intArrToString(arr));
	}
	static String intArrToString(int[]arr) {
		String str = "(";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i];
			if (i != arr.length - 1) {
				str += ", ";
			}
		}
		return str + ")";
	}
}
