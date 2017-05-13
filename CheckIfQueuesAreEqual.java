import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CheckIfQueuesAreEqual {
	public static void main(String[] args) {
		Queue<String> q1 = new LinkedList<String>();	
		Queue<String> q2 = new LinkedList<String>();
		Scanner scanner = new Scanner(System.in);
		boolean found = false;

		System.out.println("Enter text for the 1st queue:");
		while (scanner.hasNext()) {
			String input = scanner.next();

			if ("q".equalsIgnoreCase(input))
				break;

			q1.add(input);
		}

		System.out.println("Enter text for the 2nd queue:");
		while (scanner.hasNext()) {
			String input = scanner.next();

			if ("q".equalsIgnoreCase(input))
				break;

			q2.add(input);
		}

		if (q1.size() != q2.size()) {
			found=true;
			System.out.println("Queues are not of the same length. Exit.");
		}
		else {
			while (!q1.isEmpty() && !found) {
				if (!q1.remove().equals(q2.remove())) {
					System.out.println("Queues have different elements. Exit.");
					found = true;
				}
			}
		}

		if (!found)
			System.out.println("Queues are identical/equal.");
	}
}
