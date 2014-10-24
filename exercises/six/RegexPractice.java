
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexPractice {
	
	public ArrayList<Character> extractOperators(String equation) {
		ArrayList<Character> op = new ArrayList<Character>();
		for (int i = 0; i < equation.length(); i++) {
			if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '/' || equation.charAt(i) == '*') {
				op.add(equation.charAt(i - 1));
			}
		}
		op.toString();
		return op;
	}
	
	public ArrayList<Character> extractNumbers(String equation) {
		ArrayList<Character> nums = new ArrayList<Character>();
		for (int i = 0; i < equation.length(); i++) {
			if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '/' || equation.charAt(i) == '*') {
				nums.add(equation.charAt(i));
			}
		}
		nums.toString();
		return nums;
	}
	
	public ArrayList<String> extractEmails(String emails) {
		ArrayList<String> address = new ArrayList<String>();
		Pattern pat = Pattern.compile("\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
		Matcher match = pat.matcher(emails);
		while(match.find()) {
			address.add(match.group());
		}
		address.toString();
		return address;
	}
	
	public ArrayList<String> extractListBody(String list) {
		ArrayList<String> LT = new ArrayList<String>();
		Pattern pat = Pattern.compile("<li>(.+?)</li>");
		Matcher match = pat.matcher(list);
		match.find();
		LT.add(match.group(1));
		LT.toString();
		return LT;
	}
	
	public static void main(String[] args) {
		RegexTests t = new RegexTests();
		t.testEmails();
	}
}
