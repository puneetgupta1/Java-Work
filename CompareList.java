import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;

public class CompareList {
	public static class Plan {
		public String status;
		public String id;
		public double balance;
	}

	public static enum Status {
		Active("Active"),
		Accelerated("Accelerated"),
		Cancelled("Completed");

		private final String planStatus;

		Status(String planStatus) {
			this.planStatus = planStatus;
		}

		public String value() {return planStatus;}
	}

		public static void main(String[] args) {
			List<Plan> p1 = new ArrayList<Plan> ();
			List<Plan> s = new LinkedList<Plan> ();

			CompareList.Plan p = new CompareList.Plan();

			p.status = "ACTIVE";
			p.id = "1111";
			p.balance = 20.0;
			p1.add(p);

			CompareList.Plan p2 = new CompareList.Plan();

			p2.status = "ACCELERATED";
			p2.id = "2222";
			p2.balance = 30.0;
			p1.add(p2);


			CompareList.Plan p3 = new CompareList.Plan();

			p3.status = "CANCELLED";
			p3.id = "3333";
			p3.balance = 40.0;
			p1.add(p3);

			Collections.sort(p1, new Comparator<Plan> () {
					//private String onTop = "ACTIVE";

					public int compare(Plan one, Plan two) {
						if (CompareList.Status.Active.value().equalsIgnoreCase(one.status)) {return -1;}
						if (CompareList.Status.Active.value().equalsIgnoreCase(two.status)) {return 1;}
						return one.status.compareToIgnoreCase(two.status);
					}
			});

			for (Plan m : p1) {
				System.out.println(m.status);
				System.out.println(m.id);
				System.out.println(m.balance);
			}
		}
	}
