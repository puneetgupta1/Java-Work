import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WithinDateRange {
	public boolean isDateWithinRange(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		try {
			Date date = new Date();
			String today = sdf.format(date);
			System.out.println("Today date is: " + today);
			//Date date = sdf.parse(dateToValidate);
			//System.out.println("Date passed is: " + date);
			Calendar currentDate = Calendar.getInstance();
			currentDate.add(Calendar.DAY_OF_MONTH, 0);

			Calendar retentionPeriod = Calendar.getInstance();
			retentionPeriod.add(Calendar.DAY_OF_MONTH, -(100 * 12));

			//System.out.println("Current Date: " + /*sdf.format(*/Calendar.getInstance().getTime());
			System.out.println("Current Date with 0: " + /*sdf.format(*/currentDate.getTime());
			System.out.println("Retention Period: " + /*sdf.format(*/retentionPeriod.getTime());
			System.out.println("Formatted Dates: " + today + " and " + sdf.format(currentDate.getTime()));

			if ((date.after(retentionPeriod.getTime()) && date.before(currentDate.getTime())) || 
					(today.equals(sdf.format(currentDate.getTime()))) || (today.equals(sdf.format(retentionPeriod.getTime())))) {
				System.out.println("The date lies within the range");
				return true;
			} else {
				System.out.println("The date lies outside the range");
				return false;
			}
		} catch(Exception e) {
			System.out.println(e);
		}

		return true;
	}

	public static void main(String[] args) {
		WithinDateRange r = new WithinDateRange();
		r.isDateWithinRange("MM/dd/yyyy HH:mm:ss");
	}
}
