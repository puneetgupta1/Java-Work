import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
	public static void main(String[] args) {
		LinkedList<AtomicInteger> l = new LinkedList<AtomicInteger>();

		l.add(new AtomicInteger(5));
		l.add(new AtomicInteger(9));

		System.out.println(l.getLast().incrementAndGet());
		System.out.println(l.getLast().get());
	}
}
