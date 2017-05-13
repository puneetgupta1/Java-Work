import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumConsecutiveCharacter {
	Map<String,Integer> map = new HashMap<String,Integer>();

	public void run(String input) {
		String[] arr = explode(input);
		/*for (int i=0; i<arr.length; i++) {
			if (map.get(arr[i]) != null) {
				if (arr[i].equals(arr[i-1])) {
					LinkedList<AtomicInteger> l1 = new LinkedList<AtomicInteger>();
					l1.add(new AtomicInteger(map.get(arr[i]).getLast().incrementAndGet()));
					System.out.println("=====> for: " + arr[i] + " : " + l1);
					map.put(arr[i], l1);
				}
				else {
					LinkedList<AtomicInteger> l2 = new LinkedList<AtomicInteger>();
					l2 = map.get(arr[i]);
					l2.add(new AtomicInteger(1));
					map.put(arr[i], l2);
				}
			} else {
				LinkedList<AtomicInteger> l = new LinkedList<AtomicInteger>();
				l.add(new AtomicInteger(1));
				map.put(arr[i],l);
			}
		} */

		/*for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (map.get(arr[i]) != null) {
					if (arr[i].equals(arr[j])) {
						int val = map.get(arr[i]);
						val++;
						map.put(arr[i], val);
					} else {
						int val1 = map.get(arr[i]);
						val1++;
						map.put(arr[i],val1);
						i=j;
						break;
					}
				} else {
					map.put(arr[i],1);
				}
			}
		}*/

		for (Map.Entry<String,Integer> m : map.entrySet())
			System.out.println(m.getKey() + " : " + m.getValue());
	}

	//Convert String to String[]
	public String[] explode(String input) {
		String[] arr = new String[input.length()];
		for (int i=0; i<input.length(); i++) {
			arr[i] = String.valueOf(input.charAt(i));
		}
		return arr;
	}

	public static void main(String[] args) {
		MaximumConsecutiveCharacter m = new MaximumConsecutiveCharacter();
		m.run("fffffffggggtvshjbsdhjfffhvjbbbbbbbjggchaffffru");
	}
}
