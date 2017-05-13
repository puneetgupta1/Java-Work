import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest {
	public static void main(String[] args) {
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Date date1 = dateformat.parse(date);
		Calendar cal = new GregorianCalendar();
		System.out.println(date);
		System.out.println(cal.getTime());
		System.out.println(dateformat.format(date));
		System.out.println(dateformat.format(cal.getTime()));
		System.out.println(dateformat.format(date1));
	}
}
	
