import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class UserHomeState implements Event {
	EventLoop event;
	private boolean User;
	public Auction[] a;
	public String u;
	String UserInput;
	@Override
	public void show() throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println(u + " would you like to create and item 1 to create or just search for an item (hit enter to log out)");
		 UserInput = scan.nextLine().toLowerCase();
		 if(UserInput.equals("1")){
			 AuctionCreateState create = new AuctionCreateState();
			 create.show();
			 show();
		 }
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
	public String[] parseInput(String inputString){
		
		inputString.split("or");
		
		return new String[1];
	}

}
