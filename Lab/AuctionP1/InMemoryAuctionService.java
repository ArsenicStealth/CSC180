import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchControls;

public class InMemoryAuctionService implements AuctionService {
	Auction a1 = new Auction(12, "Milk", 0);
	Auction a2 = new Auction(23, "Lunchable", 2);
	Auction a3 = new Auction(34, "Shirt", 5);
	Auction a4 = new Auction(45, "Human Eye", 200);
	static ArrayList<Auction> a = new ArrayList<Auction>();

	public InMemoryAuctionService() {
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
	}


	@Override
	public Auction[] search(String criteria) {
		ArrayList<Auction> auc = new ArrayList<Auction>();
		if (criteria != null && criteria != "") {
			for (Auction auction : a) {
				if (auction.getName().contains(criteria)) {
					auc.add(auction);
				}
			}
		}
		return auc.toArray(new Auction[1]);
	}

	@Override
	public void bid(String username, int itemid) {
		ArrayList<Auction> auc = new ArrayList<Auction>();
		if(itemid != 0){
			for(Auction auction : a){
				if(auction.getId() == itemid){
					auction.currentBid += 1;
					auction.owner = username;
				}
			}
		}

	}
}
