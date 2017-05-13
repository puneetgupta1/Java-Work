import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class checkNotNull {
	public static <T> T checkNotNullOrEmpty(T reference, Object errorMessage) {
		//if (collection == null || collection.isEmpty()) {
		if (reference instanceof String) {
			if (reference == null) {
				System.out.println("AccessoryInstallmentAdapter:: " + String.valueOf(errorMessage));
			}
		}

		if (reference == null) {
			System.out.println("AccessoryInstallmentAdapter:: " + String.valueOf(errorMessage));
		}

		if (reference instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) reference;
			if (collection == null || collection.isEmpty())
				System.out.println("AccessoryInstallmentAdapter:: " + String.valueOf(errorMessage));
		}

		if (reference instanceof Map<?,?>) {
			Map<?,?> map = (Map<?,?>) reference;
			if (map == null || map.isEmpty()) {
				System.out.println("AccessoryInstallmentAdapter:: " + String.valueOf(errorMessage));
			}
		}

		return reference;
	}

	public static void main(String[] args) {
		checkNotNull c = new checkNotNull();
		List<String> l = new ArrayList<String> ();
		Map<String, String> m = new HashMap<String, String> ();
		//Map<String, PrepareRequest> m2 = new HashMap<String, PrepareRequest> ();
		String name = null;
		PrepareRequest p = null;
		String key = "key";

		try {
			c.checkNotNullOrEmpty(m, "Map cannot be null");
			checkNotNullOrEmpty(key , "Key is empty");
			l.add("Puneet");
			m.put("Puneet","Gupta");
			checkNotNullOrEmpty(name, "Name cannot be null");
			c.checkNotNullOrEmpty(l, "List cannot be null");
			c.checkNotNullOrEmpty(m, "Map cannot be null");
			//c.checkNotNullOrEmpty(m2, "Hey! Map cannot be null");
			checkNotNullOrEmpty(p, "PrepareRequest cannot be null");
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("after e");
			System.out.println(e.getMessage());
		}
	}
	}

