public class GenericSet {
	private String val;

	public void setParameter(Object value) {
		this.val = String.valueOf(value);
	}

	public String getParameter() {
		return this.val;
	}

	public static void main(String[] args) {
		GenericSet g = new GenericSet();
		//g.setParameter("Puneet");
		g.setParameter("6782376599");
		System.out.println(Long.toString(Long.parseLong(g.getParameter())));
	}
}
