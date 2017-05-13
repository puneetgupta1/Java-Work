import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StoreNumber {
	public static void main(String[] args) {
		String storeNumber = "pvt_D111";
		String result = null;
		String pvtString = null;
		//Pattern PATTERN = Pattern.compile("[a-zA-Z]+_");
		//Matcher m = PATTERN.matcher(storeNumber);

		//if (m.find()) {
			//pvtString = m.group(0);
		try {
			pvtString = storeNumber.substring(0, storeNumber.indexOf("_"));
			System.out.println(pvtString);
			if (pvtString.equalsIgnoreCase("PVT")) {
				result = storeNumber.substring(storeNumber.indexOf("_") + 1,storeNumber.length());
			} else {
				System.out.println("Pattern PVT_ not found. Make sure for PVT testing the format is: PVT_D111");
			}
		} catch(Exception ex) {
			System.out.println("Exception caught: " + ex);
		}
		//}
		System.out.println(result);
	}
}


		
