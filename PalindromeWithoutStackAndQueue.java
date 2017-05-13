import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
	
public class PalindromeWithoutStackAndQueue {
	public boolean isPalindrome(String input) {
		String[] input_array = input.split(""); //remember the way to convert a string to string[]

		for (int i = 0; i<input_array.length; i++) {
			System.out.println("Comparing: " + input_array[i] + " and " + input_array[input_array.length -i -1]);
			if (!input_array[i].equals(input_array[input_array.length -i -1])) 
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

		PalindromeWithoutStackAndQueue p = new PalindromeWithoutStackAndQueue();
		System.out.println("Is Palindrome? " + p.isPalindrome(strippedInput.toLowerCase()));
	}
}
