public class DerivedClass extends SuperClass {
	protected String credentialType;
	protected String credentialId;

	public void setCredentialType(String type) {
		this.credentialType = type;
	}

	public String getCredentialType() {
		return credentialType;
	}

	public DerivedClass withCredentialType(String type) {
		setCredentialType(type);
		return this;
	}


	public void setCredentialId(String id) {
		this.credentialId = id;
	}

	public String getCredentialId() {
		return credentialId;
	}

	public DerivedClass withCredentialId(String id) {
		setCredentialId(id);
		return this;
	}

	public static void main(String[] args) {
		DerivedClass dc = new DerivedClass();
		/*dc.setResponseCode(200);
		dc.setResponseMessage("SUCCESS");
		dc.setCredentialType("MobileIdentifier");
		dc.setCredentialId("678882");*/

		dc.withCredentialType("MobileIdentifier")
			.withCredentialId("678882")
			.withResponseCode(200)
			.withResponseMessage("SUCCESS");

		System.out.println("Derived Class: Code - " + dc.getResponseCode() + " - Response Message - " + dc.getResponseMessage() + " - Credential Type - " + dc.getCredentialType());
	}
}
