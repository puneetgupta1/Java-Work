import java.util.stream.Stream;
import java.util.Arrays;

public class ReverseQueue {
	private QueueUsing2Stacks<String> q2s = new QueueUsing2Stacks<String> ();
	private GenericStack<String> stack = new GenericStack<String> ();

	public void run() {
		String[] arr = new String[] {"P","U","N","E","E","T"};

		Arrays.stream(arr).forEach(s -> q2s.enqueue(s));

		while (!q2s.isEmpty()) 
			stack.push(q2s.dequeue());

		while (!stack.isEmpty())
			q2s.enqueue(stack.pop());

		System.out.println(q2s.dequeue());
		System.out.println(q2s.dequeue());
		System.out.println(q2s.dequeue());
		System.out.println(q2s.dequeue());
		System.out.println(q2s.dequeue());
		System.out.println(q2s.dequeue());
	}

	public static void main(String[] args) {
		ReverseQueue rq = new ReverseQueue();
		rq.run();
	}
}
