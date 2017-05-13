public class EnumTest2 {
	public static enum Status {
		Active("Active"),
		Inactive("Rejected");

		private final String planStatus;

		Status(String planStatus) {
			this.planStatus = planStatus;
		}

		public String value() {return planStatus;}
	}

	public static class Nested {
		public Status status;
		public String name;
	}

	public static void main(String[] args) {
		EnumTest2.Nested n = new EnumTest2.Nested();
		n.status = Status.Active;
		n.name = "Puneet";

		EnumTest2.Nested n1 = new EnumTest2.Nested();
		n1.status = Status.Inactive;
		n1.name = "Ria";

		System.out.println("The plan status is: " + Status.valueOf("Active"));
		System.out.println("The plan status is: " + Status.valueOf("Inactive"));
		if (n.status == Status.Active) {
			System.out.println("Puneet's status is: " + Status.Active);
		}

		if (n1.status == Status.Inactive) {
			System.out.println("Ria's status is: " + Status.Inactive);
		}
	}
}
