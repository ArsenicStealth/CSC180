import java.util.Scanner;


public class AuctionCreateState implements Event {
	InMemoryAuctionService IMAS = new InMemoryAuctionService();
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
			System.out.println("What is the Name of the item you would like to add");
			String item = scan.nextLine();
			System.out.println("What is the description of the item");
			String des = scan.nextLine();
			System.out.println("what is the starting price of the item");
			int price = scan.nextInt();
			for (int i = 0; i < IMAS.a.size(); i++) {
				
			}
			int i = 0;
			for (Auction a : IMAS.a.values()) {
				i++;
			}
			Auction a = new Auction(i, item, price, des);
			IMAS.create(a);
			
			next();
		
		
	}

	@Override
	public Event next() {
		
		return new UserHomeState();
	}

}
