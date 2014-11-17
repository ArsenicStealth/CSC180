import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class EventLoop {
	public Queue<State> Q1 = new LinkedList<State>();
//	 public Queue<State> Q2 = new LinkedList<State>();
//	 public Queue<State> Q3 = new LinkedList<State>();

	InMemoryAuctionService memory = new InMemoryAuctionService();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		EventLoop EV = new EventLoop();
		EV.Begin();

	}

	public void Begin() throws FileNotFoundException, IOException {

		Queue<State> ToDo = Q1;
//		 Queue<State> Done = Q2;
//		 Queue<State> Temp = Q3;

		DefaultState Def = new DefaultState();
		UserHomeState Home = new UserHomeState();
		SearchResultsState Results;
		AuctionCreateState Create;

		Def.show();
		if (Def.next() != null) {
			Def.UserState.setCurrentState(Home);
			if (Def.next() != null) {
				ToDo.add(Def.UserState);
				Home.u = Def.UserState.getUserName();
			}
		}
		Auction[] auction = null;
		for (int i = 0; i < ToDo.size();) {
			Def = new DefaultState();
			Home = new UserHomeState();
			Results = new SearchResultsState();
			Create = new AuctionCreateState();
			Def.show();
			
			if (Def.next() != null) {
				Def.UserState.setCurrentState(Home);
				
				if (Def.next() != null) {
					ToDo.add(Def.UserState);
					Home.u = Def.UserState.getUserName();
				}
			}
			
			if (ToDo.peek() != null) {
				State state = ToDo.poll();
				Event event = state.getCurrentState();
				
				if (event instanceof UserHomeState) {

					((UserHomeState) event).u = state.getUserName();
					((UserHomeState) event).event = this;
					event.show();
					auction = ((UserHomeState) event).a;
					state.setCurrentState(new SearchResultsState());
					SearchResultsState result = (SearchResultsState) state
							.getCurrentState();
					result.a = auction;
					
				} else if (event instanceof SearchResultsState) {
					((SearchResultsState) event).u = state.getUserName();
					((SearchResultsState) event).eventloop = this;
					event.show();
					state.setCurrentState(new UserHomeState());
				}
				
				if (event.next() != null) {
					ToDo.add(state);
//
//					 Temp = ToDo;
//					 ToDo = Done;
//					 Done = Temp;
				}
			}
		}
	}
}
