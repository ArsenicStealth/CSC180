import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class AuctionCreateState implements Event {
	InMemoryAuctionService IMAS = new InMemoryAuctionService();
	@Override
	public void show() throws FileNotFoundException, IOException {
		SimpleDateFormatConverter sdfc = new SimpleDateFormatConverter();
		Scanner scan = new Scanner(System.in);
			System.out.println("What is the Name of the item you would like to add");
			String item = scan.nextLine();
			String it = item;
			System.out.println("What is the description of the item");
			String des = scan.nextLine();
			System.out.println("What is the starting price of the item");
			int price = scan.nextInt();
			System.out.println("How many bids are remaining on the item");
			int bids = scan.nextInt();
			System.out.println("When is the end date");
			item = scan.nextLine();
			Date d = sdfc.Parse(item);
			int i = 0;
			Auction newa = new Auction(IMAS.count, it, des, price, bids, d);
			IMAS.create(newa);
			System.out.println(IMAS.count++);
			Lab4.FileP();
			next();
		
		
	}

	@Override
	public Event next() {
		
		return new UserHomeState();
	}

}
