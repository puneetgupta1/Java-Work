import java.util.Objects;

public class NonNull {
	public void test(String test) {
		Objects.requireNonNull(test, "test cannot be null");
		System.out.println("The string is: " + test);
	}

	public static void main(String[] args) {
		NonNull nn = new NonNull();
		String test=null;
		nn.test(test);
	}
}
