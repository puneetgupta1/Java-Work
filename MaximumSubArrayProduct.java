import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

public class MaximumSubArrayProduct {
	public void run() {
		//int[] input = new int[] {-2,-4000,0,-20000,3,0,2000,10};
		int[] input = new int[] {1, -2, -3, 0, 7, -8, 2};
		int maxProduct = 1;
		int temp = 1;
		int counter = 0;
		//Map<Integer,Integer> zerocounters = new LinkedHashMap<Integer,Integer>();

		for (int i=0; i<input.length; i++) {
			if (input[i] != 0) {
				maxProduct = maxProduct * input[i];
			} else {
				if (maxProduct > temp) {
					temp = maxProduct;
					//zerocounters.put(temp,i);
				} //else
					//zerocounters.put(maxProduct,i);

				maxProduct=1;
			}
		}

		if (temp > maxProduct) {
			/*for (int j=0;j<zerocounters.get(temp);j++)
				System.out.println(input[j]);*/
			System.out.println("Maximum product is: " + temp);
		}else {
			/*counter = (int)zerocounters.values().toArray()[zerocounters.size()-1];
			for (int j=counter+1; j<input.length; j++) 
				System.out.println(input[j]);*/
			System.out.println("Maximum product is: " + maxProduct);
		}
	}

	public static void main(String[] args) {
		MaximumSubArrayProduct m = new MaximumSubArrayProduct();
		m.run();
	}
}
			
