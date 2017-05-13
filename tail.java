import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class tail {
  	private static final String WORD_REGEXP = "[- .:,]+";

	private void run(int k) throws IOException {
		long count;
		BufferedReader reader = null;
		String path = "C:\\Puneet\\Downloads\\Personal\\Technical\\Oracle Java 8 Sessions\\homework\\lesson2\\SonnetI.txt";

		try {
		
			reader = Files.newBufferedReader(
					Paths.get(path), StandardCharsets.UTF_8);

			count = reader.lines().count();

			System.out.println("Count of lines: " + count);
		} catch(IOException ioe) { throw new IOException(ioe); }

		try {
			reader = Files.newBufferedReader(
					Paths.get(path), StandardCharsets.UTF_8);
		
			List<String> l = reader.lines()
					.skip(count - k)
					.limit(k)
					.collect(Collectors.toList());
			System.out.println(l);
		} catch(IOException ioe) { throw new IOException(ioe); }
	}

	public static void main(String[] args) {
		tail t = new tail();

		try{
			t.run(1);
		} catch(Exception e) {
		}
	}
}

