public class Timing {
	private final int UNKNOWN=-1;
	private final Long startTime;
	private final Long endTime;

	public Timing(long startTime, long endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public static Timing startTiming() {
		return new Timing(Long.valueOf(System.currentTimeMillis(),null));
	}

	public Timing endTiming() {
		this.endTime = Long.valueOf(System.currentTimeMillis());
		return this;
	}

	public final long setStartTime() {
		this.startTime = startTime;
	}

	public final long getStartTime() {
		return startTime;
	}

	public final long setEndTime() {
		this.endTime = endTime;
	}

	public final long getEndTime() {
		return endTime == null ? UNKNOWN : endTime;
	}

	public final long getElapsedTime() {
		return endTime != null ? duration(startTime, endTime) : null;
	}

	private double duration(long startTime, long endTime) {
		return (double)(endTime - startTime);
	}
}


		
