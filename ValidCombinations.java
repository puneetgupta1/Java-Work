import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ValidCombinations {
	Map<Integer, String> mapping = new HashMap<Integer, String>();

	public void run() {
		String s = "123123123";

		/*Convert String to int[]*/
		char[] cArray = s.toCharArray();
		int[] input = new int[cArray.length];

		for (int i=0; i<cArray.length; i++) {
			input[i] = Character.getNumericValue(cArray[i]);
		}
				
		Set<String> output = new HashSet<String>();

		for (int i='A'; i<='Z'; i++) {
			mapping.put(i - 'A' + 1, String.valueOf((char)i));
		}

		for (int i=0; i<input.length; i++) {
			if (mapping.containsKey(input[i])) {
				output.add(precombine(i, input) + mapping.get(input[i]) + postcombine(i, input));
				if (i+1<input.length) {
					if (mapping.containsKey(input[i]*10 + input[i+1])) {
						output.add(precombine(i, input) + mapping.get(input[i]*10 + input[i+1]) + postcombine(i+1, input));
					}
				}
			}
		}

		System.out.println(output);
	}

	public String precombine(int i, int[] input) {
		String residue="";

		for (int m=0; m<i; m++) {
			residue += mapping.get(input[m]);
		}

		return residue;
	}

	public String postcombine(int i, int[] input) {
		String residue="";

		for (int k=i+1; k<input.length; k++) {
			residue += mapping.get(input[k]);
		}

		return residue;
	}

	public static void main(String[] args) {
		ValidCombinations v = new ValidCombinations();
		v.run();
	}
}

		

			
