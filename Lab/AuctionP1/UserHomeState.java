import java.util.Scanner;


public class UserHomeState implements Event {
	EventLoop event;
	private boolean User;
	public Auction[] a;
	public String u;
	String UserInput;
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.println(u + " what would you like to search for? (hit enter to log out)");
		 UserInput = scan.nextLine();
		if(!UserInput.equals("")){
			User = true;
			a = event.memory.search(UserInput);
		}else{
			User = false;
		}
		
	}

	@Override
	public Event next() {
		if(User){
			return new SearchResultsState();
		}else{
			return null;	
		}
	}

}
