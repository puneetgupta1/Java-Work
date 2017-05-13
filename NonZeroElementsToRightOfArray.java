import java.util.Arrays;
import java.util.stream.Stream;

public class NonZeroElementsToRightOfArray {
	public void run(int[] arr) {
		int current=0;
		int next= 0;
		for (int i=0; i<arr.length; i++) {
			current=arr[i];
			if (arr[i] > 0) {
				continue;
			} else {
				for (int k=i+1;k<arr.length;k++) {
					if (arr[k] > 0) {
						next=arr[k];
						arr[k]=current;
						arr[i]=next;
						break;
					} else {
						continue;
					}
				}
			}
		}
		
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void main(String[] args) {
		NonZeroElementsToRightOfArray nz = new NonZeroElementsToRightOfArray();

		int[] arr = new int[] {1,2,0,-3,100,-98,2,0,-340,43,6,0,0,3,4,-9};
		nz.run(arr);
	}
}
