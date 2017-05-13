import java.util.Arrays;
import java.util.stream.Stream;

public class InsertElementInArray {

	/*
		a = {1,2,3,4,5}
		a = {1,2,87,4,5}
	*/
	public int[] addToPos(int[] a, int atPosition, int numberToInsert) {
		int[] result = new int[a.length];

		for (int i=0; i<atPosition; i++)
			result[i] = a[i];

		result[atPosition] = numberToInsert;

		for (int j=atPosition+1; j<a.length; j++)
			result[j] = a[j - 1];

		return result;
	}

	public static void main(String[] args) {
		InsertElementInArray ins = new InsertElementInArray();

		int[] array = new int[] {1,2,3,4,5};
		int pos = 2;
		int num = 87;

		int[] result = ins.addToPos(array, 2, 87);
		
		Arrays.stream(result).forEach(System.out::println);
	}
}


