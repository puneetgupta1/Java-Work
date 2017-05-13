public class LongString {
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public static void main(String args[]) {
		LongString ls = new LongString();

		ls.setId(String.valueOf(0.0));

		System.out.println(ls.getId());
	}
}
