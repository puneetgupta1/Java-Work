import java.io.Console;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class UniqueWordsSet {
	Map<String,String> wordlist = new HashMap<String,String>();

	public void run(String input) {
		String words[] = input.split("\\s+");

		findWords(words);
	}

	public void findWords(String[] words) {
		for(int i=0;i<words.length;i++) {
			for (int j=i+1;j<words.length;j++) {
				checkWords(words[i],words[j]);
			}
		}

		for (Map.Entry<String,String> map : wordlist.entrySet()) {
			System.out.println(map.getKey() + " : " + map.getValue());
		}
	}

	public void checkWords(String word1, String word2) {
		char[] cWord1 = word1.toLowerCase().toCharArray();
		char[] cWord2 = word2.toLowerCase().toCharArray();
		Arrays.sort(cWord1);
		Arrays.sort(cWord2);
		String sWord1 = new String(cWord1);
		String sWord2 = new String(cWord2);

		if (sWord1.equalsIgnoreCase(sWord2)) {
			wordlist.put(word1,word2);
		} else {
			if (word2.length() > word1.length()) {
				if (checkMergedWords(word1,word2))
					wordlist.put(word1,word2);
			} else {
				if (checkMergedWords(word2,word1))
					wordlist.put(word2,word1);
			}	
		} 
	}

	public boolean checkMergedWords(String word1, String word2) {
		for (int k=0;k<word2.length()-word1.length();k++) {
			String str = (word2.substring(k,word2.length())).substring(0,word1.length());
			if (word1.equalsIgnoreCase(str)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String input = "May student students dog studentssess got Cat act tab bat flow wolf lambs Amy Yam balms looped poodle john alice";

		UniqueWordsSet us = new UniqueWordsSet();
		us.run(input);
	}
}

