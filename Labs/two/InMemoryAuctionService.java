import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InMemoryAuctionService implements AuctionService {
	Auction a1 = new Auction(1, "milk", 0, "2% milk");
	Auction a2 = new Auction(2, "lunchable", 2, "best food ever");
	Auction a3 = new Auction(3, "shirt", 5, "my awesome shirt");
	Auction a4 = new Auction(4, "human Eye", 200, "my best friends eye i borrowed it for a day");
	static Map<Integer, Auction> a = new HashMap<Integer, Auction>();

	public InMemoryAuctionService() {
		a.put(a1.getId(), a1);
		a.put(a2.getId(), a2);
		a.put(a3.getId(), a3);
		a.put(a4.getId(), a4);
	}
	
	@Override
	public Auction[] search(String criteria)
	{
		Stack<String> OP = new Stack<String>();
		Stack<Predicate> Pred = new Stack<Predicate>();
		String[] spilts = criteria.split(" ");
		
		for(String s : spilts){
			if(s.equals("and") || s.equals("or")){
				if(s.equals("or")){
					while (!OP.empty() && OP.peek().equals("and")) {
						OP.pop();
						ContainsPredicate Tpred = (ContainsPredicate) Pred.pop();
						ContainsPredicate Tpred2 = (ContainsPredicate) Pred.pop();
						APred A = new APred(Tpred, Tpred2);
						Pred.push(A);
					}
					OP.push(s);
				}
				else{
					OP.push(s);
				}
			}
			if(!s.equals("and") && !s.equals("or")){
				ContainsPredicate predicate = new ContainsPredicate(s);
				Pred.push(predicate);
			}
		}
		while(!OP.empty()){
			OP.pop();
			OrPred or = new OrPred(Pred.pop(), Pred.pop());
			Pred.push(or);
		}
		ArrayList<Auction> sear = new ArrayList<Auction>();
		sear.addAll(CollectionUtils.filter(a.values(), Pred.pop()));
		
		return sear.toArray(new Auction[1]);
	}

	@Override
	public void bid(String username, Integer itemid) {
		try
		{
			if(itemid != 0){
				for(Auction auction : a.values()){
					if(auction.getId() == itemid)
					{
						auction.setCurrentBid(auction.getCurrentBid()+1);
						auction.setOwner(username);
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Id or username not found");
		}

	}


	@Override
	public Auction create(Auction auction) {
		// creates new auction with the values from the
		//passed in auction. then returns the new auction.
		int count = 0;
		Auction NA = null;
		for(Auction auc : a.values())
		{
			NA = new Auction(count, auction.getName(), auction.getCurrentBid(), auction.getDescription());
			a.put(auction.getId(), auc);
			count++;
		}
		return NA;
	}


	@Override
	public void delete(Integer id) {
		if(id != null){
			a.remove(id);
		}
		
	}


	@Override
	public Auction retreive(Integer id) {
			try {
				if(id != null){
				return a.get(id);
				}
			} catch (NullPointerException e) {
				System.err.println("Item not found");
			}
		return null;
	}


	@Override
	public Auction update(Auction auction, Integer id) {
		try {
			a.put(id, auction);
		} catch (NullPointerException e) {
			System.err.println("ID not found");
		}
		return a.get(id);
	}
}
