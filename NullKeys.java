import java.util.Map;
import java.util.HashMap;

public class NullKeys {
	public static void main(String[] args) {
		Map<String, String> m = new HashMap<>();
		m.put(null, "puneet");

		System.out.println(m.get(null));
		System.out.println(m.get("att"));
		System.out.println(m.containsKey("att"));
	}
}
