import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
	
	public Queue run(Queue input, int eliminate, int numberOfPeople) {
		for (int i=1; i<=numberOfPeople; i++) {
			if (i == eliminate) {
				System.out.println("Inside eliminate: " + i);
				input.remove(i);
			}
		}

		return input;
	}

	public static void main(String[] args) {
		Josephus jose = new Josephus();
		Queue<Integer> input = new LinkedList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
		}};


		for (int i=0; i<6; i++) {
			Queue output = jose.run(input, 1, input.size());
			output.stream().forEach(System.out::println);
		}
	}
}
