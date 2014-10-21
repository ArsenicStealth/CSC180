import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


public class ConvTest {

	@Test
	public void test() {
		Converter<Date> dates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMM yyyy"));
		Converter<Date> Fdates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"), new SimpleDateFormat("d MM yyyy"));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		
		
		String formatted = dates.format(d);
		
		Assert.assertEquals(formatted, "21 Oct 2015");
	}
	
	@Test
	public void test2() {
		Converter<Date> dates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMM yyyy"));
		Converter<Date> Fdates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"), new SimpleDateFormat("d MM yyyy"));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		
		String formatted = Fdates.format(d);
		
		Assert.assertEquals(formatted, "21 10 2015");		
	}
	
	@Test
	public void test3() {
		Converter<Date> dates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMM yyyy"));
		Converter<Date> Fdates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"), new SimpleDateFormat("d MM yyyy"));
		Converter<Date> nulll = new SimpleDateFormatConverter();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		
		String formatted = nulll.format(d);
		
		Assert.assertEquals(formatted, "21 10 2015");// should fail		
	}
	
	
	
	@Test
	public void testAuctionFormat()
	{
		Auction a = new Auction(1, "friend", 32, "maybe");
		Converter<Auction> auc = new TableRowAuctionConverter();
		String formatted = auc.format(a);

		
		Assert.assertEquals("| 1	friend	$32		maybe |", formatted);//should fail
		
	}
	
	@Test
	public void testAuctionFormat2()
	{
		Auction a = new Auction(2, "human", 300, "not for trafficing");
		Converter<Auction> auc = new TableRowAuctionConverter();
		String formatted = auc.format(a);
		
		Assert.assertEquals("| 2\thuman\t$300\tnot for trafficing |", formatted);//should pass
		
	}


}
