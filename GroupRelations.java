import java.util.Arrays;
import java.util.stream.Stream;

public class GroupRelations {
	public void run() {
		int[][] input = new int[2][2];
		int[][] output = new int[2][2];
		input = new int[][] {{1,2},{2,3},{3,4},{4,5}};

		for (int i=0; i<input.length; i++) {
			for (int j=i+1; j<input[0].length; j++) {
				//System.out.println(input[i][j]);
				if (input[i][j-1]!=input[j][i]) { 
					output[i][j]=input[i][j-1];
				} 
				
				if (input[i][j-1]!=input[j][j]) {
					output[i][j]=input[j][j];
				}

				if (input[i][j]!=input[j][i]) {
					output[i][j]=input[i][j];
				}

				if (input[i][j]!=input[j][j]) {
					output[i][j]=input[j][j];
				}
			}
		}

		Arrays.stream(output).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);
	}

	public static void main(String[] args) {
		GroupRelations g = new GroupRelations();
		g.run();
	}
}
			
