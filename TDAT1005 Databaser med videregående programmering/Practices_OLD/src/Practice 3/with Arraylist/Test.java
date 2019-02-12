import java.util.ArrayList;

class Test {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("hello");
		arr.add("hasad");

		for (String obj : arr) {
			System.out.println(obj);
		}
	}
}