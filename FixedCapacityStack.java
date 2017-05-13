import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<T> implements Iterable<T> {
	private T[] arr;
	private int N;

	public FixedCapacityStack(int cap) {
		arr = (T[]) new Object[cap];
	}

	public boolean isEmpty() {return N==0;}

	public boolean isFull() {
		return N==arr.length;
	}

	public int size() {return N;}

	public void push(T item) {
		if (isFull())
			resize(2*arr.length);

		arr[N++] = item; 
	}

	public T pop() {
		T item = arr[--N];
		arr[N] = null; //to avoid loitering
		if (N>0 && N == arr.length/4) resize(arr.length/2);
		return item;
	}

	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int j=0; j<N; j++) 
			temp[j] = arr[j];
		arr = temp;
	}

	public Iterator<T> iterator() {
		return new ArrIterator();
	}

	private class ArrIterator implements Iterator<T> {
		private int i = 0;

		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			return arr[i++];
		}

		public boolean hasNext() { return i < N; }
		public void remove() { throw new UnsupportedOperationException(); }
	}

	public static void main(String[] args) {
		FixedCapacityStack<String> fc = new FixedCapacityStack<String>(2);

		String[] input = new String[] {"it","was","-", "the", "best", "-", "of", "times", "-", "-", "-", "it","was", "-", "the", "-", "-"};

		for (int i=0; i<input.length; i++) {
			String item = input[i];
			if (!item.equals("-")) 
				fc.push(item);
			else if (!fc.isEmpty()) System.out.println(fc.pop() + " ");
		}

		System.out.println(fc.size() + " left on stack");
		
		fc.push("guptaji");
		fc.push("is on");
		fc.push("the role");

		for (String s : fc) 
			System.out.println("After implementing the iterator: " + s);
	}
}
