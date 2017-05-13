import java.util.Stack;

public class FixedSizeStack<T> extends Stack<T> {
	int maxSize;

	FixedSizeStack(int size) {
		super();
		this.maxSize = size;
	}

	public T push(T item) {
		super.push(item);

		while (this.size() > this.maxSize)
			this.remove(0); //this removed element at the botton of the stack!
						 // this.removeElementAt(this.size() - 1) removes element at the top of the stack
		return null;
	}
}
	
