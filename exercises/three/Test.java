
public class Test {
	public void Testcreate(){
		InMemoryAuctionService IMAS = new InMemoryAuctionService();
		Auction a1 = new Auction(13, "Crack", 0);
		Auction a2 = new Auction(14, "Human Brain", 1000);
		a1.setProperty("Crack Cocain", 12);
		System.out.println(a1.getProperties());
		a2.setProperty("Human Meat", 60);
		System.out.println(IMAS.create(a1));
		System.out.println(IMAS.create(a2));
		System.out.println(IMAS.retreive(13));
		IMAS.delete(13);
		System.out.println(IMAS.a.get(13));
		System.out.println(IMAS.update(IMAS.a2, 14));
		System.out.println(IMAS.a.get(14));
		
	}
}
