public class EnumTest {
	public static enum mode {
		INITIATE("SubmitMerchantProductOrder"),
		COMPLETE("ManageMerchantProductOrder"),
		REFUND("SubmitMerchantProductRefund"),
		HISTORY("InquireSubscriberContractDetails"),
		ACCELERATE("CancelMerchantInstallmentCharges");

		private final String csiApiName;

		mode(String csiApiName) {
			this.csiApiName = csiApiName;
		}

		public String value() {return csiApiName;}

		public static String getEnumByString(String csiApiName){
			for(mode e : mode.values()){
				if(csiApiName == e.csiApiName) return e.name();
			}
			return null;
		}
	}

	public mode md;

	public void setModed(mode m) {
		this.md = m;
	}

	public mode getModed() {
		return md;
	}

	public static enum header {
		GENERIC,
		SECURITY,
		SEQUENCE,
		TRACKING;
	}

	public static String getMode(mode m) {
		switch(m) {
			case INITIATE:
				return m.value();
			case COMPLETE:
				return m.value();
		}
		return null;
	}

	public static String getHeader(header h) {
		switch(h) {
			case GENERIC:
				return "Generic";
			case SECURITY:
				return "Security";
		}

		return null;
	}
		

	public static void main(String[] args) {
		EnumTest e = new EnumTest();
		System.out.println(e.getMode(mode.INITIATE));
		String temp = "InquireSubscriberContractDetails";
		System.out.println(EnumTest.mode.getEnumByString(temp));

		String temp1 = "HISTORY";
		e.setModed(mode.valueOf(temp1));
		System.out.println(e.getModed());
		System.out.println(e.getModed().value());
	}
}
