import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Date;
//import org.javatuples.*;

public class AccessoryInstallmentHistoryInfo {
	private final List<String> mobiles; 
	private final int ALLOWED_CTNS = 50;
	private static int counter = 0;
	private Map<String, List<MobileDetails>> activeMobiles = new LinkedHashMap<String, List<MobileDetails>>();
	private Map<String, List<MobileDetails>> inactiveMobiles = new LinkedHashMap<String, List<MobileDetails>>();
	private List<MobileDetails> input = new ArrayList<MobileDetails>();

	public static enum Status {
		ACTIVE,
		COMPLETED,
		CANCELLED,
		ACCELERATED,
		REVOKE;
	}

	public static class MobileDetails {
		public String mobileNumber;
		public String status;
		public String installmentPlanId;
		public int remainingBalance;

		MobileDetails(String mobileNumber, String status, String installmentPlanId, int remainingBalance) {
			this.mobileNumber = mobileNumber;
			this.status = status;
			this.installmentPlanId = installmentPlanId;
			this.remainingBalance = remainingBalance;
		}
	}

	public AccessoryInstallmentHistoryInfo(List<String> mobiles) {
		this.mobiles = mobiles;
	}

	private List<List<String>> checkAndSplitMobileList(List<String> mobiles) {
		List<List<String>> partitions = new ArrayList<List<String>> ();
		int partitionSize = 0;

		if (mobiles.size() > 50) 
			partitionSize = ALLOWED_CTNS;

		for (int i=0; i<mobiles.size(); i += partitionSize) {
			partitions.add(mobiles.subList(i, Math.min(i + partitionSize, mobiles.size())));
		}

		return partitions;
	}

	public void inquireSummaryHistory() {
		//Start the timer
		StringBuilder sb = new StringBuilder();
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time :" + new Date(System.currentTimeMillis()));

		try {
			//List<List<String>> mobilesSubLists = checkAndSplitMobileList(mobiles);
			//System.out.println("Mobile lists are: " + mobilesSubLists);

			//for (List<String> mobileList : mobilesSubLists) {
			List<String> mobileList = new ArrayList<>();
				++counter;
				System.out.println("Invoking InquireSummaryHistory API for list: " + counter);

				input = inquiresummary(mobileList);

				if (input != null || input.isEmpty() != false) {
					/*System.out.println("What's in the input list?: ");

					  for (MobileDetails i : input) 
					  System.out.println(i.mobileNumber + ", " + i.status + ", " + i.installmentPlanId);*/

					//createActiveMaps(input);
					groupBy(input);

					/*for (Map.Entry<String, List<MobileDetails>> m : activeMobiles.entrySet()) {
					  System.out.println("After createActiveMaps - Active Key: " + m.getKey());
					  for (MobileDetails mk : m.getValue())
					  System.out.println(mk.mobileNumber + ", " + mk.status);
					  }*/
				}
			//}

			//rearrangeMaps(input);
			formStatusMaps();

			//printAllMaps();

			System.out.println("Is there anythin in the input list left? - " + input.size());
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			long endtime = System.currentTimeMillis();
			long ttkn = endtime - startTime;
			System.out.println("****************** TIME TAKEN ************ : "+(ttkn/1000) +" seconds");
		}	
	}

	private void formStatusMaps() {
		Map<String, Map<String, List<MobileDetails>>> maps = new HashMap<>();
		Map<String, List<MobileDetails>> temp = new HashMap<>();
		maps.put("ACTIVE", activeMobiles);
		maps.put("HISTORY", inactiveMobiles);

		for (Map.Entry<String, Map<String, List<MobileDetails>>> m : maps.entrySet()) {
			System.out.println("key is: " + m.getKey());
			temp = m.getValue();
			for (Map.Entry<String, List<MobileDetails>> m1 : temp.entrySet()) {
				System.out.println("Inner Key is: " + m1.getKey());
				for (MobileDetails mk : m1.getValue()) {
					System.out.println(mk.mobileNumber + ", " + mk.status + ", " + mk.installmentPlanId + ", " + mk.remainingBalance);
				}
			}
		}
	}

	private void printAllMaps() {
		/*Triplet<List<MobileDetails>, Map<String, List<MobileDetails>>, Map<String, List<MobileDetails>>> triplet = Triplet.with(input, activeMobiles, inactiveMobiles);

		System.out.println("The size of input list is: " + triplet.getValue0().size());

		for (Map.Entry<String, List<MobileDetails>> m : triplet.getValue1().entrySet()) {
			System.out.println("Active Key: " + m.getKey());
			for (MobileDetails mk : m.getValue())
				System.out.println(mk.mobileNumber + ", " + mk.status + ", " + mk.installmentPlanId + ", " + mk.remainingBalance);
		}

		for (Map.Entry<String, List<MobileDetails>> m : triplet.getValue2().entrySet()) {
			System.out.println("Inactive Key: " + m.getKey());
			for (MobileDetails mk : m.getValue())
				System.out.println(mk.mobileNumber + ", " + mk.status + ", " + mk.installmentPlanId + ", " + mk.remainingBalance);
		}*/

		for (Map.Entry<String, List<MobileDetails>> m : activeMobiles.entrySet()) {
			System.out.println("Active Key: " + m.getKey());
			for (MobileDetails mk : m.getValue())
				System.out.println(mk.mobileNumber + ", " + mk.status + ", " + mk.installmentPlanId + ", " + mk.remainingBalance);
		}

		for (Map.Entry<String, List<MobileDetails>> m : inactiveMobiles.entrySet()) {
			System.out.println("Inactive Key: " + m.getKey());
			for (MobileDetails mk : m.getValue())
				System.out.println(mk.mobileNumber + ", " + mk.status + ", " + mk.installmentPlanId + ", " + mk.remainingBalance);
		}
	}

	private void groupBy(List<MobileDetails> input) {
		ListIterator<MobileDetails> it = input.listIterator();
		//while (it.hasNext()) {
		for (MobileDetails t : input) {
			//MobileDetails t = it.next();
			if (Status.valueOf(t.status).equals(Status.ACTIVE)) {
				List<MobileDetails> innerList = activeMobiles.containsKey(t.mobileNumber) ? activeMobiles.get(t.mobileNumber) : new ArrayList<MobileDetails>();
				innerList.add(t);
				activeMobiles.put(t.mobileNumber, innerList);
				//it.remove();
			} else {
				if (activeMobiles.containsKey(t.mobileNumber)) {
					List<MobileDetails> l = activeMobiles.get(t.mobileNumber);
					l.add(t);
					activeMobiles.put(t.mobileNumber, l);
				} else {
					List<MobileDetails> otherList = inactiveMobiles.containsKey(t.mobileNumber) ? inactiveMobiles.get(t.mobileNumber) : new ArrayList<MobileDetails>();
					otherList.add(t);
					inactiveMobiles.put(t.mobileNumber, otherList);
				}
				//it.remove();
			}
		}
	}

		private void createActiveMaps(List<MobileDetails> input) {
			ListIterator<MobileDetails> it = input.listIterator();
			while (it.hasNext()) {
				MobileDetails md = it.next();
				if (Status.valueOf(md.status).equals(Status.ACTIVE)) {
					if (activeMobiles.get(md.mobileNumber) != null) {
						List<MobileDetails> l = activeMobiles.get(md.mobileNumber);
						l.add(md);
						activeMobiles.put(md.mobileNumber, l);
					} else {
						List<MobileDetails> temp = new ArrayList<MobileDetails>();
						temp.add(md);
						activeMobiles.put(md.mobileNumber, temp);
					}

					it.remove();
				}
			}
		}

		private void rearrangeMaps(List<MobileDetails> input) {
			if (input != null || input.isEmpty() != false) {
				ListIterator<MobileDetails> it = input.listIterator();
				while (it.hasNext()) {
					MobileDetails md = it.next();
					if (activeMobiles.get(md.mobileNumber) != null) {
						List<MobileDetails> l = activeMobiles.get(md.mobileNumber);
						l.add(md);
						activeMobiles.put(md.mobileNumber, l);
					} else if (inactiveMobiles.get(md.mobileNumber) != null) {
						List<MobileDetails> lina = inactiveMobiles.get(md.mobileNumber);
						lina.add(md);
						inactiveMobiles.put(md.mobileNumber, lina);
					} else {
						List<MobileDetails> temp = new ArrayList<MobileDetails>();
						temp.add(md);
						inactiveMobiles.put(md.mobileNumber, temp);
					}

					it.remove();
				}
			}
		}

		private Map<String, List<MobileDetails>> mapPlanDetailToMobileNumber(List<MobileDetails> input) {
			Map<String, List<MobileDetails>> plansMap = new HashMap<String, List<MobileDetails>>();

			for (MobileDetails m : input) {
				if (plansMap.get(m.mobileNumber) != null) {
					List<MobileDetails> l = plansMap.get(m.mobileNumber);
					l.add(m);
					plansMap.put(m.mobileNumber, l);
				} else {
					List<MobileDetails> temp = new ArrayList<MobileDetails>();
					temp.add(m);
					plansMap.put(m.mobileNumber, temp);
				}
			}

			return plansMap;
		}

		private List<MobileDetails> inquiresummary(List<String> mobileList) {
			if (counter == 1) {
				MobileDetails details1 = new MobileDetails("123456789", "ACTIVE", "jfdhXok-45jxaaa", 200);
				input.add(details1);
				MobileDetails details1_1 = new MobileDetails("123456789", "CANCELLED", "jfdhXok-45jxbbb", 0);	
				input.add(details1_1);
				MobileDetails details1_2 = new MobileDetails("123456789", "ACCELERATED", "jfdhXok-45jxccc", 0);
				input.add(details1_2);

				MobileDetails details2 = new MobileDetails("6788826922", "ACTIVE", "jfdhXok-45jxxxx", 54);
				input.add(details2);
				MobileDetails details2_1 = new MobileDetails("6788826922", "CANCELLED", "jfdhXok-45jxyyy", 0);
				input.add(details2_1);
				MobileDetails details2_2 = new MobileDetails("6788826922", "COMPLETED", "jfdhXok-45jxzzz", 0);
				input.add(details2_2);


				MobileDetails details3 = new MobileDetails("6788828717", "COMPLETED", "jfdhXok-45jbbbb", 0);
				input.add(details3);
				MobileDetails details3_1 = new MobileDetails("6788828717", "CANCELLED", "jfdhXok-45jbccc", 0);
				input.add(details3_1);
				MobileDetails details3_2 = new MobileDetails("6788828717", "REVOKE", "jfdhXok-45jbddd", 0);
				input.add(details3_2);
			} else if (counter == 2) {
				MobileDetails details4 = new MobileDetails("6788829000", "ACTIVE", "jfdhXok-45jttt", 0);
				input.add(details4);
			} else
				return new ArrayList<MobileDetails>();

			return input;
		}

		public static void main(String[] args) {
			List<String> mobile_list = new ArrayList<String>() {{
				add("1111111101");
				add("1111111102");
				add("1111111103");
				add("1111111104");
				add("1111111105");
				add("1111111106");
				add("1111111107");
				add("1111111108");
				add("1111111109");
				add("1111111110");
				add("1111111111");
				add("1111111112");
				add("1111111113");
				add("1111111114");
				add("1111111115");
				add("1111111116");
				add("1111111117");
				add("1111111118");
				add("1111111119");
				add("1111111120");
				add("1111111121");
				add("1111111122");
				add("1111111123");
				add("1111111124");
				add("1111111125");
				add("1111111126");
				add("1111111127");
				add("1111111128");
				add("1111111129");
				add("1111111130");
				add("1111111131");
				add("1111111132");
				add("1111111133");
				add("1111111134");
				add("1111111135");
				add("1111111136");
				add("1111111137");
				add("1111111138");
				add("1111111139");
				add("1111111140");
				add("1111111141");
				add("1111111142");
				add("1111111143");
				add("1111111144");
				add("1111111145");
				add("1111111146");
				add("1111111147");
				add("1111111148");
				add("1111111149");
				add("1111111150");
				add("1111111151");
				add("1111111152");
				add("1111111153");
				add("1111111154");
				add("1111111155");
				add("1111111156");
				add("1111111157");
				add("1111111158");
				add("1111111159");
				add("1111111160");
			}};

			AccessoryInstallmentHistoryInfo aih = new AccessoryInstallmentHistoryInfo(mobile_list);
			aih.inquireSummaryHistory();
		}
	}
