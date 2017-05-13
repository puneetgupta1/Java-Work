import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;

public class MapGetKeyByValue {
	public static <T, V> T getKeyByValue(Map<T, V> map, V value) {
		for (Map.Entry<T, V> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		//map.put("Puneet", "Gupta");
		map.put("Bhavna", "Singh");
		map.put("Ria", "Risha");
		map.put("Kaku", "Gupta");
		//map.put(null, "att");

		MapGetKeyByValue m = new MapGetKeyByValue();
		System.out.println(m.getKeyByValue(map, "Gupta"));
		System.out.println(m.getKeyByValue(map, "att"));
	}
}
