import java.util.*;

public class GenericStack<T> {
	private List<T> stack = new ArrayList<T> ();
	private int top=0;

	public int size() {return top;}

	public void push(T item) {
		stack.add(top++, item);
	}

	public T pop() {
		return stack.remove(--top);
	}

	public T peek() {
		if (!this.isEmpty())
			return stack.get(this.size() - 1);
		else throw new NoSuchElementException();
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public static void main(String[] args) {
		GenericStack<String> s = new GenericStack<String> ();
		s.push("Puneet");
		s.push("Ria");
		s.push("Risha");
		System.out.println("Peek returns: " + s.peek());
		System.out.println("The stack contains: " + s.pop());
	}
}
