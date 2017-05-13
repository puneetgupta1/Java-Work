import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Streaming {
	public static void main(String[] args) {
		//Given a long sequence of items, design a data structure to store the k items most recently seen.
		FixedSizeStack<String> stack = new FixedSizeStack<String>(3);
		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNext()) {
			String s1 = scanner.next();
			if ("q".equalsIgnoreCase(s1)) {
				System.out.println("Exit!");
				break;
			}

			stack.push(s1);
		}

		while (!stack.isEmpty()) 
			System.out.println("Last most recently seen items: " + stack.pop());
	}
}


