import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CheckDuplicates {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		boolean found = false;

		while (scanner.hasNext()) {
			String input = scanner.next();

			if ("q".equalsIgnoreCase(input)) {
				System.out.println("Exit!");
				break;
			}

			list.add(input);
		}
		
		String[] arr = list.toArray(new String[0]);

		for (int i=0; i<arr.length && !found; i++) { // note the !found in the loop condition, this is to break out of the outer loop
			for (int j=i+1; j<arr.length; j++) {
				System.out.println("Comparing " + arr[i] + " with " + arr[j]);
				if (arr[i].equals(arr[j])) {
					found=true;
					break;
				}
			}
		}

		if (found) System.out.println("Duplicates: YES!");
		else
			System.out.println("Duplicates: NO!");
	}
}




