import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Print5thToLast {
	public static void main(String[] args) {
		FixedCapacityStack<Integer> fc = new FixedCapacityStack<Integer>(10);
		Scanner scanner = new Scanner(System.in);
		List<Integer> i_list = new ArrayList<Integer> ();

		System.out.println("Enter something: ");
		while(scanner.hasNextInt()) {
			i_list.add(scanner.nextInt());

			/*if ("q".equals(input)) {
				System.out.println("Exit!");
				break;
			} */
		}

		//Using Java 7
		/*int[] input_array = new int[i_list.size()];

		for (int i=0; i<input_array.length; i++) {
			input_array[i] = i_list.get(i);
		}*/

		//Using Java 8
		int[] input_array = i_list.stream().mapToInt(i -> i).toArray();

		Arrays.stream(input_array).forEach(s ->
			{
				System.out.println(s);
				fc.push(s);
			});

		while (fc.size() > 5)
			fc.pop();

		System.out.println("The 5th element should be: " + fc.pop());
	}
}

