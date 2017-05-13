import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CountOccurances {
	public class Plan {
		public String name;
		public int age;
	}

	public void count() {
		List<String> list = new ArrayList<String>();
		list.add("puneet");
		list.add("puneet");
		list.add("puneet");
		list.add("puneet");
		list.add("amol");
		list.add("batman");
		list.add("batman");
		list.add("batman");
		list.add("batman");
		list.add("batman");

		List<Plan> plans = new ArrayList<Plan>();
		Plan p1 = new Plan();
		p1.name = "puneet";

		Plan p2 = new Plan();
		p2.name = "bhavna";
		Plan p3 = new Plan();
		p3.name = "ria";
		Plan p4 = new Plan();
		p4.name = "risha";
		Plan p5 = new Plan();
		p5.name = "twinkle";
		Plan p6 = new Plan();
		p6.name = "puneet";
		Plan p7 = new Plan();
		p7.name = "puneet";

		plans.add(p1);
		plans.add(p2);
		plans.add(p3);
		plans.add(p4);
		plans.add(p5);
		plans.add(p6);
		plans.add(p7);
	
		System.out.println("The count is: " + Collections.frequency(list, "batman"));

		int count=0;
		for (Plan p : plans) {
			if (p.name.equalsIgnoreCase("puneet")) {
				count++;
			}
		}

		System.out.println("The count in the plans is: " + count);

	}

	public static void main(String[] args) {
		CountOccurances co = new CountOccurances();
		co.count();
	}
}
