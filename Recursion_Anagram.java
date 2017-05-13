public class Recursion_Anagram {
	public void run() {
		String s = "straw";
		printAnagrams("",s);
	}

	public void printAnagrams(String prefix, String word) {
		System.out.println(word);
		if (word.length() <=1)
			System.out.println("====> " + prefix + word);
		else {
			for (int i=0;i<word.length();i++) {
				String current = word.substring(i,i+1);
				String before = word.substring(0,i);
				String after = word.substring(i+1);
				printAnagrams(prefix+current, before+after);
			}
		}
	}

	public static void main(String[] args) {
		Recursion_Anagram anagram = new Recursion_Anagram();
		anagram.run();
	}
}
