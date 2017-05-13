public class ResizeQueue<T> {

	T[] array = null;
	int N = 0;

	public ResizeQueue(int cap) {
		array = (T[]) new Object[cap];
	}

	public void enqueue(T item) {
		/*for (int i = array.length - 2; i >= 0; i--) {
			array[i + 1] = array[i];
		}

		array[0] = item;
		N++; */

		T[] result = (T[]) new Object[array.length];

		for (int i = 1; i < array.length ; i++)
			result[i] = array[i - 1];

		result[0] = item;

		for (int j=0; j<result.length; j++) {
			array[j] = result[j];
		}

		N++;
	}

	public T dequeue() {
		System.out.println("N is: " + N);
		T temp = array[N - 1];
		array[N - 1] = null;
		N--;
		return temp;
	}

	public boolean isEmpty() {
		return N==0;
	}

	public int isSize() {
		return N;
	}

	public static void main(String[] args) {
		ResizeQueue<String> rq = new ResizeQueue<String> (20);
		String[] s = new String[] {"Dog", "World", "Poda", "Puneet", "Gupta"};
		for (int j=0; j<s.length; j++) 
			rq.enqueue(s[j]);

		//for (int k=0;k<rq.isSize();k++)
			System.out.println("Dequeue gives: " + rq.dequeue());
			System.out.println("Dequeue gives: " + rq.dequeue());
			System.out.println("Dequeue gives: " + rq.dequeue());
			System.out.println("Dequeue gives: " + rq.dequeue());
			System.out.println("Dequeue gives: " + rq.dequeue());
	}
}
