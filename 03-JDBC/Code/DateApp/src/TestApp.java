import java.util.Date;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Date");
		
		Date date = new Date();
		System.out.println("Util Date is :: "+date);
		long value = date.getTime();
		System.out.println("Information about date in milisecond ::"+value);
		//java.sql.Date -> we use to store Date information
		
		java.sql.Date sqlDate = new java.sql.Date(value);
		System.out.println("SQL date :: "+sqlDate);
		
	}

}
