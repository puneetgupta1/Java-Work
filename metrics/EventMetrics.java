public class EventMetrics {
	public enum EventField {
		EventType,
		ErrorCode,
		RequestID,
		RequestType,
		StartTime,
		Exception,
		HttpRequestTime,
		ResponseProcessingTime,
		RequestCount,
		RetryCount,
		ServiceName,
		HttpStatusCode,
	}

	private final Map<String, Timing> events = new HashMap<String, Timing>();
	private final Map<String, List<Timing>> eventHistory = new HashMap<String, List<Timing>>();

	protected final Timing timing;

	public EventMetrics() {
		this.timing = Timing.startTiming();
	}

	protected EventMetrics(Timing timing) {
		this.timing = timing;
	}

	public final Timing getTiming() {
		return timing;
	}

	public void startEvent(String eventName) {
		events.put(eventName, Timing.startTiming());
	}

	public void endEvent(String eventName) {
		Timing event = events.get(eventName);
		if (event == null) {
			System.out.println("Event is NULL");
			return;
		}

		event.endTiming();
		eventHistory.put(eventName, new Timing(event.getStartTime(), event.getEndTime()));
	}

}


		
