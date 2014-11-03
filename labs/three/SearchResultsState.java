import java.util.Scanner;


public class SearchResultsState implements Event, Converter<Auction>  {
	public EventLoop eventloop;
	InMemoryAuctionService memory;
	public Auction[] a;
	public String u;
	public String in;
	Scanner scan = new Scanner(System.in);
	@Override
	public void show() {
		System.out.println("What would you like to search for?");
		in = scan.nextLine();
		memory.search(in);
		System.out.println("=============================================================");
		System.out.println("====================			Search Results			====================");
		System.out.println("=============================================================");
		for(Auction auction : a)
		{
			try 
			{
				if(auction.getOwner() != null)
				{
					format(auction);
				}
				else
				{
					format(auction);
				}
			}
			catch(NullPointerException e)
			{
				System.out.println("That item could not be found");
			}
		}
		System.out.println("Enter the item Id to increase the bid by $1. Otherwise, enter another search: (hit enter to go back to home page)");
		in = scan.nextLine();
	
	}

	@Override
	public Event next() {
			return new UserHomeState();
	}
	@Override
	public String format(Auction fromObject) {

		String format = String.format("%-10s%-15s%-10s%-8s%-10s%-12s", fromObject.getId(), fromObject.getName(), fromObject.getCurrentBid(), fromObject.getNOBR(), fromObject.getOwner(), fromObject.getTimeLeft());
		return format;
	}

	@Override
	public Auction Parse(String fromString) {
		// TODO Auto-generated method stub
		return null;
	}

}
