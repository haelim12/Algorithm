import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Date d= new Date();
		String s = d.toString();
		
		SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formatType.format(d));
	}
}