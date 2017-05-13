import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

public class RandomQueue<T> implements Iterable<T> {
	private T[] array;
	private int N;

	public RandomQueue() {
		N = 0;
		array = (T[]) new Object[2];
	}

	public boolean isEmpty() {
		return N==0;
	}

	public int size() {
		return N;
	}

	public int randomInt(int min, int max) {
		Random rand = new Random();

		return rand.nextInt((max - min) + 1) + min;
	}

	public void enqueue(T item) {
		if (N == array.length)
			resize(2*array.length);

		array[N++] = item;
	}

	public T dequeue() {
		if (isEmpty()) throw new RuntimeException("Stack underflow");

		int i = randomInt(0, size());
		T item = array[i];
		array[i] = array[N - 1];
		array[N - 1] = null;

		N--;

		if (N>0 && N==array.length/4)
			resize(N/2);

		return item;
	}

	public T sample() {
		if (isEmpty()) throw new RuntimeException("Stack underflow");

		int i = randomInt(0, size());
		return array[i];
	}

	public void resize(int max) {
		T[] temp = (T[]) new Object[max];

		for (int i=0; i<size(); i++)
			temp[i] = array[i];

		array = temp;
	}

	public Iterator<T> iterator() {
		return new RandomQueueIterator<T> ();
	}

	private class RandomQueueIterator<T> implements Iterator<T> {
		private int i=0;

		public boolean hasNext() {
			return i < N;
		}

		public T next() {
			if(!hasNext()) throw new NoSuchElementException();

			int j = randomInt(0,N);
			T item = array[j];
			array[j] = array[N - 1];
			array[N - 1] = null;

			N--;

			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		RandomQueue<Integer> rq = new RandomQueue<Integer>();

		rq.enqueue(3);
		rq.enqueue(59);
		rq.enqueue(169);
		rq.enqueue(34);
		rq.enqueue(2949);
		rq.enqueue(19);
		rq.enqueue(57);
		rq.enqueue(82);
		rq.enqueue(254);
		rq.enqueue(23);

		System.out.println("Random dequeue yields: " + rq.dequeue());

		RandomQueue<String> srq = new RandomQueue<String>();

		srq.enqueue("Puneet");
		srq.enqueue("Gupta");
		srq.enqueue("Ria");
		srq.enqueue("Risha");
		srq.enqueue("Bhavna");
		srq.enqueue("Twinkle");

		Iterator itr = srq.iterator();

		while (itr.hasNext()) System.out.println(itr.next());
	}
}

