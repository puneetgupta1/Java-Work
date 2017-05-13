public class OverrideEquals {
	private String id;
	private String description;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	  public int hashCode() {
		  final int prime = 31;
		  int result = 1;
		  result = prime * result + ((id == null) ? 0 : id.hashCode());
		  return result;
	  }

	/* 
	 * Override equals method so that at any given point if we want to compare 2 InstallmentAgreementTenders then
	 * all we have to do is: if (InstallmentAgreementTender1.equals(InstallmentAgreementTender2))
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OverrideEquals other = (OverrideEquals) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static void main(String[] args) {
		OverrideEquals o = new OverrideEquals();
		o.setId("xy345z");
		o.setDescription("this is test 1 object");
		OverrideEquals o1 = new OverrideEquals();
		o1.setId("xy345z");
		o.setDescription("this is test 2 object");

		System.out.println("Are objects equals? : " + o.equals(o1));
	}
}
