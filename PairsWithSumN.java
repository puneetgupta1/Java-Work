import java.util.Map;
import java.util.HashMap;

public class PairsWithSumN {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void run(int[] arr1, int[] arr2, int sum) {
		if (arr1.length >= arr2.length) {
			findpairs(arr1,arr2,sum);
		} else {
			findpairs(arr2,arr1,sum);
		}
	}

	public void findpairs(int[] arr1, int[] arr2, int sum) {
		for (int i=0; i<arr1.length; i++) {
			for (int j=0; j<arr2.length; j++) {
				if (arr1[i] + arr2[j] == sum) {
					map.put(arr1[i],arr2[j]);
				}
			}
		}

		for (Map.Entry<Integer,Integer> m : map.entrySet())
			System.out.println(m.getKey() + " : " + m.getValue());
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,4,-6,5,7,9};
		int[] arr2 = new int[] {3,6,3,4,0,-1,-2,-3};

		PairsWithSumN p = new PairsWithSumN();
		p.run(arr1,arr2,5);
	}
}
