import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConversionCodeApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Read the input from the user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the date (dd-mm-yyyy) ::");
		String sdate = sc.next();
		
		//Convert the date from String to java.util,Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
		java.util.Date uDate = sdf.parse(sdate);
	
		//Convert java.util.Date to java.sql.sql
		long value = uDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(value);
		
		//printing all the 3 formate of Date
		System.out.println("String formate date is :: "+sdate);
		System.out.println("Uti DAte is :: "+uDate);
		System.out.println("SQL DATE is :: "+sqlDate);
		
		System.out.println();
		System.out.println("Enter the dom in the following format ::(yyyy-MM-dd)");
		String standardInpit = sc.next();
		java.sql.Date sqlStandardInput =  java.sql.Date.valueOf(standardInpit); 
		System.out.println("String standardInput    ::"+standardInpit);
		System.out.println("String sqlStandardInput ::"+sqlStandardInput);
	}

}
