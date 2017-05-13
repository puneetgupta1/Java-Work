import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;

public class Palindrome {

	public boolean isPalindrome(String input) {
		Stack<String> stack = new Stack<String>();
		Queue<String> ll = new LinkedList<String>();
		String[] input_array = input.split(""); //remember the way to convert a string to string[]

		for (int i=0;i<input_array.length;i++) {
			stack.push(input_array[i]); //stack will have - t,e,e,n,u,p
			ll.add(input_array[i]); //queue will have - t,e,e,n,u,p
		}

		while (!ll.isEmpty()) {
			if (!ll.remove().equals(stack.pop())) //ll.remove() gives 'p' and stack.pop() gives 't'
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Type in something: ");
		String input = scanner.nextLine();
		String strippedInput = input.replaceAll("\\W", ""); //ignores punctuation, white spaces, and other non-word/non-number characters
		System.out.println("The stripped input is: " + strippedInput);

		Palindrome p = new Palindrome();
		System.out.println("Is Palindrome? " + p.isPalindrome(strippedInput.toLowerCase()));
	}
}

