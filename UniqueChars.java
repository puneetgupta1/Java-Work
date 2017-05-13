public class UniqueChars {
	/* Assumes only letters a through z. */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println(val);
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	} 

	/*public static boolean isUniqueChars(String str) {
		if (str.length() > 128) 
			return false;

		boolean[] val = new boolean[128];

		for (int i=0; i<str.length(); i++) {
			int c = (int)str.charAt(i);
			if (val[c]) 
				return false;

			val[c] = true;
		}

		return true;
	}*/

	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}
}
