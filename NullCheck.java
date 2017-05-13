import java.util.List;
import java.util.ArrayList;

public class NullCheck {
	private String name;
	private List<String> attributes;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public List<String> getAttributes() {
		return this.attributes;
	}

	public List<String> returnAll() {
		if (getAttributes() != null) {
			return getAttributes();
		}

		//return new ArrayList<String> ();
		return null;
	}

	public static void main(String[] args) {
		NullCheck nc = new NullCheck();
		List<String> list = new ArrayList<String>();
		nc.setName("Puneet");
		list.add("Blue");
		list.add("Black");
		list.add("Brown");
		//nc.setAttributes(list);
		System.out.println(nc.returnAll());
	}
}
