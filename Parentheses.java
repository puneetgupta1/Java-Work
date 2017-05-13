/*
 * Write a stack client Parentheses.java that reads in sequence of left and right parentheses, braces, and brackets from standard input and uses a stack to determine whether the sequence is properly balanced. For example, your program should print true for [()]{}{[()()]()} and false for [(]). 
*/

public class Parentheses {
	public static void main(String[] args) {
		GenericStack<String> input = new GenericStack<String> ();
		//GenericStack<T> output = new GenericStack<T> ();

		String[] s = new String[] {"[","(",")","{","]"};

		for (int i = 0; i<s.length; i++) {
			System.out.println(s[i]);
			if (s[i].equals("["))  
				input.push(s[i]);
			else if (s[i].equals("(")) 
				input.push(s[i]);
			else if (s[i].equals("{")) 
				input.push(s[i]);
			else if (s[i].equals("}")) {
			        if ((input.pop()).equals("}")) {
					System.out.println("OK.");
				} else {
					System.out.println("False.");
					return;
				}
			} else if (s[i].equals(")")) {
			        if ((input.pop()).equals("(")) {
					System.out.println("OK.");
				} else {
					System.out.println("False.");
					return;
				}
			} else if (s[i].equals("]")) {
			        if ((input.pop()).equals("[")) {
					System.out.println("OK.");
				} else {
					System.out.println("False.");
					return;
				}
			} else System.out.println("Invalid input");
		}
	}
}

					


