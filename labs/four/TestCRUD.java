
public class TestCRUD {
	public static void main(String[] args) {
		InMemoryAuctionService IMAS = new InMemoryAuctionService();
		System.out.println(IMAS.a.values().toString());
		Auction a = new Auction(4, "4shirt", 45, "4my awesome shirt");
		IMAS.create(a);
		System.out.println(IMAS.a.values().toString());
		IMAS.delete(4);
		System.out.println(IMAS.a.values().toString());
		IMAS.create(a);
		Auction newa = new Auction(10, "12shirt", 10100, "my awesome shirt test");
		System.out.println(IMAS.a.values().toString());
		IMAS.update(newa, 4);
		System.out.println(IMAS.a.values().toString());
	}
	
}
