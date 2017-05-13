public class DeleteIthElement<T> extends ResizeQueue<T> {

	@SuppressWarnings("unchcked")
	public DeleteIthElement(int cap) {
		super(cap);
	}

	public T remove(int i) throws Exception {
		if (isEmpty()) throw new Exception("Queue is empty!");
		T temp = array[i - 1];
		array[i - 1] = null;
		N--;
		return temp;
	}

	public static void main(String[] args) {
		DeleteIthElement<Integer> de = new DeleteIthElement<Integer> (10);

		try {
			de.enqueue(1001);
			de.enqueue(45);
			de.enqueue(8456);
			de.enqueue(324);
			de.enqueue(766);
			de.enqueue(666);

			System.out.println(de.dequeue());
			System.out.println(de.remove(1));

		} catch(Exception e) { System.out.println(e);
		}
	}
}
