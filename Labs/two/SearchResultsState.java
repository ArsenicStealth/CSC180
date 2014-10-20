import java.util.Scanner;


public class SearchResultsState implements Event  {
	public EventLoop eventloop;
	//InMemoryAuctionService memory = new InMemoryAuctionService();
	public Auction[] a;
	public String u;
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.println(u + ", Search Results");
		for (Auction auction : a) {
			
				try {
					if(auction.getOwner() != null){
						System.out.println(auction.getId() + "\t" + auction.getName() + "\t$" + auction.getCurrentBid() + "\t" + auction.getOwner());
					}else{
						System.out.println(auction.getId() + "\t" + auction.getName() + "\t$" + auction.getCurrentBid());
					}
				} catch (NullPointerException e) {
					
				} 			
				
				
			
		}
		System.out.println("Enter the item id to increase the bid by $1.  Otherwise, enter another search: (hit enter to go back to home page)");
		String UserInput = scan.nextLine();
		if(!UserInput.equals("")){
			
				eventloop.memory.bid(u,Integer.parseInt(UserInput));
			
		}
	}

	@Override
	public Event next() {
			return new UserHomeState();
	}
}
