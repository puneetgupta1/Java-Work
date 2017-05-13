import java.util.List;
import java.util.ArrayList;

public class ValidCombinations_Better {
	public List<String> encodings(String number) {
		List<String> out = new ArrayList<>();
		addEncodings("", number, out);
		return out;
	}

	private void addEncodings(String prefix, String number, List<String> out) {
		System.out.println("addEncoding(): prefix: " + prefix);
		System.out.println("addEncoding(): number: " + number);
		System.out.println("addEncoding(): out: " + out);
		if (number.length() == 0) {
			out.add(prefix);
		} else {
			addParsingNDigits(1, prefix, number, out);
			addParsingNDigits(2, prefix, number, out);
		}

	}

	private void addParsingNDigits(int digits, String prefix, String number, List<String> out) {
		System.out.println("Inside addParisingNDigits for digits: " + digits);
		System.out.println("Inside addParisingNDigits - prefix: " + prefix);
		System.out.println("Inside addParisingNDigits - number: " + number);
		System.out.println("Inside addParisingNDigits - out: " + out);
		if (number.length() >= digits) {
			char encodedChar = parseChars(number, digits);
			if (encodedChar >= 'A' && encodedChar <= 'Z') {
				addEncodings(prefix + encodedChar, number.substring(digits), out);
			}
		}
	}

	private char parseChars(String number, int length) {
		int intVal = Integer.parseInt(number.substring(0, length));
		return (char) ('A' + intVal - 1);
	}

	public static void main(String[] args) {
		ValidCombinations_Better v2 = new ValidCombinations_Better();
		System.out.println(v2.encodings("123"));
	}
}
