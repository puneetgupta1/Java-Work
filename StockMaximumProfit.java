import java.util.Map;
import java.util.HashMap;

public class StockMaximumProfit {
	public static void main(String[] args) {
		//int prices[] = new int[] {100, 180, 260, 310, 40, 535, 695};
		int prices[] = new int[] {2, 30, 15, 10, 8, 25, 80};
		//int prices[] = new int[] {10, 22, 5, 75, 65, 80};
		//int prices[] = new int[] {100, 30, 15, 10, 8, 25, 80};
		//int prices[] = new int[] {90, 80, 70, 60, 50};
		Map<Integer, Integer> bestBuySellCombination = new HashMap<Integer, Integer> ();
		int maximumPriceDifference = 0; 
		int temporaryPriceDifference = 0;
		int min = 0;

		for (int i=0; i<prices.length; i++) {
			for (int j=i+1; j<prices.length; j++) {
				if (prices[j] > prices[i]) {
					if (prices[j] >= min) {
						min = prices[j];

						temporaryPriceDifference = prices[j] - prices[i];
						if (temporaryPriceDifference > maximumPriceDifference) {
							maximumPriceDifference = temporaryPriceDifference;
							bestBuySellCombination.put(prices[i],prices[j]);
						} 
					} else {
						min = 0;
						break;
					}
				} else {
					break;
				}
			} 
		}

		for (Map.Entry<Integer, Integer> itr : bestBuySellCombination.entrySet()) {
			System.out.println("Best combinations are: " + itr.getKey() + " and " + itr.getValue());
			System.out.println("The difference being: " + (itr.getValue() - itr.getKey()));
		}
	}
}
						

					


