import java.util.Map;
import java.util.HashMap;

public class AllNull {
	public static class nestedClass {
		public String name;
	}

	public static boolean areAllNullOrEmpty(Object errorMessage, Object... objects) {
		for (Object o : objects) {
			if (o == null || o.isEmpty()) {
				System.out.println(String.valueOf(errorMessage));
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		AllNull an = new AllNull();

		String type = null;
		String desc = "brown";
		nestedClass nc = new nestedClass();
		nc.name = null;
		Map<String, String> map = new HashMap<String, String> ();

		an.areAllNullOrEmpty("Map is null", map);
		an.areAllNullOrEmpty(" is null", type, desc, nc.name);
	}
}


