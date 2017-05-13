import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PopNthElementFromStack {
	public static void main(String[] args) {
		int n = 3;
		Stack<String> s = new Stack<String>();
		LinkedList<String> q = new LinkedList<String>();

		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNext()) {
			String s1 = scanner.next();
			if ("q".equalsIgnoreCase(s1)) {
				System.out.println("Exit!");
				break;
			}

			s.push(s1);
		}

		while(!s.isEmpty()) {
			while (s.size() > n)
				q.add(s.pop());	

			System.out.println("Popping the element number - " + n + " - from the stack: " + s.pop());

			while(!s.isEmpty())
				q.add(s.pop());

		}

		while (!q.isEmpty()) {
			System.out.println("Filling up the stack again with element: " + q.peek());
			s.push(q.removeFirst());
		}

		while (!s.isEmpty())
			System.out.println(s.pop());
	}
}

		


