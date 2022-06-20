import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		//현재 달력
		Calendar calendar = Calendar.getInstance();

		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

		calendar.add(Calendar.MONTH, 10);
		
		Date date = calendar.getTime();
		System.out.println(date);
		calendar.set(2023, 11, 19);	//12월 19일
		
	}

}
