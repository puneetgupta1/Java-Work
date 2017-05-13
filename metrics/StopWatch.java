public class StopWatch {
	public static class watch {
		private static long start;

		public static void start() {
			start = System.currentTimeMillis();
		}

		public static double elapsedTime() {
			long now = System.currentTimeMillis();
			return (now - start) / 1000.0;
		}
	}

	public static void main(String[] args) {
		StopWatch.watch w = new StopWatch.watch();

		w.start();
		for (long i=0; i<10000000; i++) {
			//do nothing
		}

		System.out.println("Time elapsed: " + w.elapsedTime());
	}
}
