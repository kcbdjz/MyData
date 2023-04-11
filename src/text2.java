import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class text2 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar(2000,1,29);
        date = calendar.getTime();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
        calendar.setTimeInMillis(34355555133101L);
        date = calendar.getTime();
        System.out.println(date);
    }

}
