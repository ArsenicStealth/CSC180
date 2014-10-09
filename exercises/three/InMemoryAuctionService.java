import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAuctionService implements AuctionService {
	Auction a1 = new Auction(12, "Milk", 0);
	Auction a2 = new Auction(23, "Lunchable", 2);
	Auction a3 = new Auction(34, "Shirt", 5);
	Auction a4 = new Auction(45, "Human Eye", 200);
	static Map<Integer, Auction> a = new HashMap<Integer, Auction>();

	public InMemoryAuctionService() {
		a.put(a1.getId(), a1);
		a.put(a2.getId(), a2);
		a.put(a3.getId(), a3);
		a.put(a4.getId(), a4);
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.Testcreate();
	}
	@Override
	public Auction[] search(String criteria) {
		ArrayList<Auction> auc = new ArrayList<Auction>();
		if (criteria != null && criteria.equals("")) {
			for (Auction auction : a.values()) {
				if (auction.getName().contains(criteria)) {
					auc.add(auction);
				}
			}
		}
		return auc.toArray(new Auction[1]);
	}

	@Override
	public Auction bid(String username, Integer itemid) {
		if(itemid != null){
			for(Auction auction : a.values()){
				try {
					if(auction.getId() == itemid){
						auction.setCurrentBid(auction.getCurrentBid() + 1);
						auction.setOwner(username);
						return auction;
					}	
				} catch (NullPointerException e) {
					System.err.println("Item ID not found");
				}
			}
		}
		return null;

	}


	@Override
	public Auction create(Auction auction) {
		// creates new auction with the values from the
		//passed in auction. then returns the new auction.
		Auction newAuc = new Auction(
				auction.getId(),
				auction.getName(),
				auction.getCurrentBid(),
				auction.getProperties()
				);
		a.put(auction.getId(), newAuc);
		return newAuc;
	}


	@Override
	public void delete(Integer id) {
		if(id != null){
			a.remove(id);
		}
		
	}


	@Override
	public Auction retreive(Integer id) {
		if(id != null){
			try {
				return a.get(id);	
			} catch (NullPointerException e) {
				System.err.println("Item not found");
			}
		}
		return null;
	}


	@Override
	public Auction update(Auction auction, Integer id) {
		try {
			return a.get(id);	
		} catch (NullPointerException e) {
			System.err.println("ID not found");
		}
		return a.get(id);
	}
}
