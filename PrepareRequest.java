public class PrepareRequest {
	private String name;
	private int age;
	private String description;

	public PrepareRequest() {}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PrepareRequest withName(String name) {
		setName(name);
		return this;
	}

	public PrepareRequest withAge(int age) {
		setAge(age);
		return this;
	}

	public PrepareRequest withDescription(String description) {
		setDescription(description);
		return this;
	}

	public static class PrepareMoreRequest {
		private String status;
		private String ethnicity;

		public String getStatus() {
			return status;
		}

		public String getEthnicity() {
			return ethnicity;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setEthnicity(String ethnicity) {
			this.ethnicity= ethnicity;
		}

		public PrepareMoreRequest withStatus(String status) {
			setStatus(status);
			return this;
		}

		public PrepareMoreRequest withEthnicity(String ethnicity) {
			setEthnicity(ethnicity);
			return this;
		}
	}

	public static void main(String[] args) {
		PrepareRequest pr = new PrepareRequest();
		pr.withName("Puneet")
			.withAge(38);

		System.out.println("Name: " + pr.getName());
		System.out.println("Age: " + pr.getAge());

		pr.withDescription("Medium Height");

		System.out.println("Name: " + pr.getName());
		System.out.println("Age: " + pr.getAge());
		System.out.println("Description: " + pr.getDescription());

		PrepareRequest.PrepareMoreRequest pmr = new PrepareMoreRequest();

		pmr.withStatus("Married").withEthnicity("Asian");

		System.out.println("Name: " + pr.getName());
		System.out.println("Age: " + pr.getAge());
		System.out.println("Description: " + pr.getDescription());
		System.out.println("Status: " + pmr.getStatus());
		System.out.println("Ethnicity: " + pmr.getEthnicity());
	}
}

