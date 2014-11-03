import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Mafia {
	//number format
	//Date simple
	// other libraries
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to MafiaPlusPlus, Please Enter your DOB");
		String DOB = scan.nextLine();
		System.out.println("Thank you, Please enter your SSN (This app is completley secure)");
		String SSN = scan.nextLine();
		System.out.println("Thank you, PLease enter your Back account balance (no, we are not trying to steal your identity, WE ALL READY HAVE IT MUHAAA)");
		long BAB = scan.nextLong();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("d MM yyyy");
		SimpleDateFormatConverter sdfc = new SimpleDateFormatConverter(sdf);
		
		Date d = sdfc.Parse(DOB);
		System.out.println("Your DOB is " + DOB);
		
		
		String[] spilts = SSN.split("-");
		
		System.out.println("Your SSN is " + spilts[0] + "-" + spilts[1] + "-" + spilts[2]);
		
		
		NumberFormat nf = DecimalFormat.getCurrencyInstance();
		String Money = nf.format(BAB);
		System.out.println("Your Balance is " + Money);
		
	
	}
	
}
