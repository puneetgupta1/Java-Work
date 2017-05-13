public class QueueUsing2Stacks<T> {
	private GenericStack<T> input = new GenericStack<T> ();
	private GenericStack<T> output = new GenericStack<T> ();

	public void enqueue(T item) {
		input.push(item);
	}

	public T dequeue() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.pop();
	}

	public boolean isEmpty() { return output.size() == 0; }

	public static void main(String[] args) {
		QueueUsing2Stacks<String> q2s = new QueueUsing2Stacks<String> ();

		/*q2s.enqueue("Puneet");
		q2s.enqueue("Gupta");
		q2s.enqueue("Ria");
		q2s.enqueue("Risha");*/
		String[] arr = new String[] {"P","U","N","E","E","T"};

		//Arrays.stream(arr).forEach(s -> q2s.enqueue(s));
		for (int i=0;i<arr.length; i++) {
			System.out.println(arr[i]);
			q2s.enqueue(arr[i]);
		}

		System.out.println("Queue gives element on dequeue: " + q2s.dequeue());
		System.out.println("Queue gives element on dequeue: " + q2s.dequeue());
		System.out.println("Queue gives element on dequeue: " + q2s.dequeue());
		System.out.println("Queue gives element on dequeue: " + q2s.dequeue());
		System.out.println("Queue gives element on dequeue: " + q2s.dequeue());
	}
}


