public class CheckAnagramWithoutSort {
	public static void main(String[] args) {
		String[][] strings = {{"apple","paple"},
				      {"baboon","oobnab"},
				      {"hello","llloh"}};
		
		for (String[] pair : strings) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean isAnagram = checkAnagram(word1,word2);
			System.out.println(word1 + ", " + word2 + ": " + isAnagram);
		}
	}

	public static boolean checkAnagram(String s, String t) {
		if (s.length() != t.length()) return false;

		int[] letters = new int[128];
		for (int i=0; i<s.length(); i++)
			letters[(int)s.charAt(i)]++;

		for (int j=0; j<t.length(); j++) {
			letters[(int)t.charAt(j)]--;

			if (letters[(int)t.charAt(j)] < 0)
				return false;
		}

		return true;
	}
}
