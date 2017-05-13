import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;

public class TwoWayIterator<T> implements Iterable<T> {
	private List<T> arraylist;
	private int N;

	public TwoWayIterator(List<T> list) {
		this.arraylist = list;
		this.N = list.size();
	}

	public Iterator<T> iterator() {
		Iterator<T> itr = new Iterator<T>() {
			private int i = 0;
			private int j = N - 1;

			public boolean hasNext() {
				return i < N;
			}

			public T next() {
				if(!hasNext()) throw new NoSuchElementException();
				return arraylist.get(i++);
			}

			public boolean hasPrevious() {
				return j >= 0;
			}

			public T previous() {
				if (!hasPrevious()) throw new NoSuchElementException();
				return arraylist.get(j--);
			}

			public void remove() { throw new UnsupportedOperationException(); }
		};

		return itr;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String> ();
		list.add("puneet");
		list.add("ria");
		list.add("risha");
		list.add("bhavna");
		list.add("twinkle");

		TwoWayIterator<String> twoway = new TwoWayIterator<String>(list);

		Iterator<String> itr = twoway.iterator();

		while (itr.hasPrevious())
			System.out.println(itr.previous());
	}
}


