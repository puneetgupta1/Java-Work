import java.util.Scanner;

public class Recursion_ReverseString {
	StringBuilder sb = new StringBuilder();

	public void run(String input) {
		reverse(input);
	}

	public void reverse(String input) {
		if (input.length() == 0) 
			System.out.println(sb.toString());

		if (input.length() != 0) {
			sb.append(input.substring(input.length()-1));
			reverse(input.substring(0,input.length()-1));
		}
	}

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		String input = null;

		while (scanner.hasNext()) {
			input = scanner.next();

			if ("q".equalsIgnoreCase(input)) {
				System.out.println("Exit!");
				break;
			}
		}*/

		Recursion_ReverseString rs = new Recursion_ReverseString();
		rs.run("puneet");
	}
}

