import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumConsecutiveCharacter_1 {
	Map<String,LinkedList<Integer>> map = new HashMap<String,LinkedList<Integer>>();
	Map<String,Integer> maxCount = new HashMap<String,Integer>();

	public void run(String input) {
		String[] arr = explode(input);
		//m.run("fffffffggggtvshjbsdhjfffhvjbbbbbbbjggchaffffru");
		for (int i=0; i<arr.length; i++) {
			if (map.get(arr[i]) != null) {
				if (arr[i].equals(arr[i-1])) {
					LinkedList<Integer> l1 = new LinkedList<Integer>();
					l1 = updateLastEntry(map.get(arr[i]));
					map.put(arr[i], l1);
				}
				else {
					LinkedList<Integer> l2 = new LinkedList<Integer>();
					l2 = map.get(arr[i]);
					l2.add(1);
					map.put(arr[i], l2);
				}
			} else {
				LinkedList<Integer> l3 = new LinkedList<Integer>();
				l3.add(1);
				map.put(arr[i],l3);
			}
		} 

		for (Map.Entry<String,LinkedList<Integer>> m : map.entrySet()) {
			maxCount.put(m.getKey(), Collections.max(m.getValue()));
		}

		for (Map.Entry<String,Integer> m : maxCount.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}

	public LinkedList<Integer> updateLastEntry(LinkedList<Integer> list) {
		Integer lastEntry = list.removeLast();
		lastEntry++;
		list.addLast(lastEntry);
		return list;
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
		MaximumConsecutiveCharacter_1 m = new MaximumConsecutiveCharacter_1();
		m.run("ffffffffffffffggggtvshjbsdhjfffhvjbbbbbbbjgggggggggggggggggggggchaffffru");
	}
}
