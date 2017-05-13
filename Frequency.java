import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Frequency {
	public static void main(String[] args) {
		int k=3;
		Map<String, Integer> map = new HashMap<String, Integer>(k);
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		String strippedInput = input.replaceAll("\\W", "");

		String[] input_array = strippedInput.split("");

		for (int i=0; i<input_array.length; i++) {
			if (map.containsKey(input_array[i])) {
				int value = map.get(input_array[i]);
				map.put(input_array[i],++value);
			} else map.put(input_array[i], 1);
		}

		for (Map.Entry<String, Integer> itr : map.entrySet()) {
			System.out.println(itr.getKey() + " is called " + itr.getValue() + " number of times");
		}
	}
}







