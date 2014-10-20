import java.util.Scanner;


public class DefaultState implements Event {
	private boolean User;
	public State UserState;
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.println("New User, would you like to log in? (hit enter to decline)");
		String UserInput = scan.nextLine();
		if(!UserInput.equals("")){
			UserState = new State(UserInput, this);
			User = true;
		}else{
			User = false;
		}
	}

	@Override
	public Event next() {
		if(User){
			return new UserHomeState();
		}else{
			return null;	
		}
	}

}
