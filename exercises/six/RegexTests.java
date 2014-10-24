

import org.junit.Test;


public class RegexTests {

	@Test
	//nums
	public void testNumbers() {
		RegexPractice reg = new RegexPractice();
		String math = "8+2-5*8/9";
		System.out.println(reg.extractNumbers(math));
	}
	
	@Test
	// Ops
	public void testOperators() {
		RegexPractice reg = new RegexPractice();
		String equation = "1+6-8*1/4";
		System.out.println(reg.extractOperators(equation));
	}
	
	@Test
	// Emails
	public void testEmails() {
		RegexPractice reg = new RegexPractice();
		String E = "13sdpuckett@live.com is the best while cracker@live.com is stupid";
		System.out.println(reg.extractEmails(E));
	}
	
	@Test
	// Text
	public void testLists() {
		RegexPractice reg = new RegexPractice();
		String LT = "<li>How Cool Is This</li>";
		System.out.println(reg.extractListBody(LT));
	}

	
}
