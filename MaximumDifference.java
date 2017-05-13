import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumDifference {
	public static void main (String[] args) {
		//code
		int[] array = new int[] {2,3,10,6,4,8,1};
		int max_diff = 0;
		int max_diff1= 0;
		int i,j;

		for (i=0; i<array.length; i++) {
			for (j=i+1; j<array.length; j++) {
				if (array[j] > array[i]) {
					System.out.println("array[j] is: " + array[j] + " and array[i] is: " + array[i]);
					max_diff1 = array[j] - array[i];
					if (max_diff1 > max_diff) {
						max_diff = max_diff1;
					}
				}
			}
		}

		System.out.println("Maximum difference is: " + max_diff);
	}
}
