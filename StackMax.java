public class StackMax {

	public static void main(String[] args) {
		FixedCapacityStack<Integer> fc_stack = new FixedCapacityStack<Integer>(10);
		FixedCapacityStack<Integer> fc_max = new FixedCapacityStack<Integer>(10);

		int[] input = new int[] {13,254,44,92,1,5};

		for (int i=0; i<input.length; i++) {
			if (!fc_max.isEmpty()) {
				int temp = fc_max.pop();
				if (input[i] > temp)
					fc_max.push(input[i]);
				else fc_max.push(temp);
			} else fc_max.push(input[i]);

			fc_stack.push(input[i]);
		}

		System.out.println("The maximum element in the list is: " + fc_max.pop());
	}
}
