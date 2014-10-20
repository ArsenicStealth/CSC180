
public class State {
	private final String UserName;
	private Event CurrentState;
	
	public State(String userName, Event currentState) {
		this.UserName = userName;
		this.CurrentState = currentState;
	}

	public Event getCurrentState() {
		return CurrentState;
	}

	public void setCurrentState(Event currentState) {
		CurrentState = currentState;
	}

	public String getUserName() {
		return UserName;
	}

}
