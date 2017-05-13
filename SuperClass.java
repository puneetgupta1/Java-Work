public class SuperClass {
	protected int responseCode;
	protected String responseMessage;

	public void setResponseCode(int code) {
		this.responseCode = code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public SuperClass withResponseCode(int code) {
		setResponseCode(code);
		return this;
	}

	public void setResponseMessage(String message) {
		this.responseMessage = message;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public SuperClass withResponseMessage(String message) {
		setResponseMessage(message);
		return this;
	}
}
