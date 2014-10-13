import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class InMemoryAuctionService implements AuctionService
{
	Auction a1 = new Auction(12, "Milk", 0);
	Auction a2 = new Auction(23, "Lunchable", 2);
	Auction a3 = new Auction(34, "Shirt", 5);
	Auction a4 = new Auction(45, "Human Eye", 200);
	static Map<Integer, Auction> a = new HashMap<Integer, Auction>();

	public InMemoryAuctionService()
	{
		a.put(a1.getId(), a1);
		a.put(a2.getId(), a2);
		a.put(a3.getId(), a3);
		a.put(a4.getId(), a4);
	}
	public static void main(String[] args)
	{
		InMemoryAuctionService mas = new InMemoryAuctionService();
		System.out.println(Arrays.toString(mas.search("Milk")));
		System.out.println(Arrays.toString(mas.search("Human Eye")));
		System.out.println(Arrays.toString(mas.search("Shirt")));
		
		
		
	}
	@Override
	public Auction[] search(String criteria)
	{
		ContainsPredicate pred = new ContainsPredicate(criteria);
		ArrayList<Auction> search = new ArrayList<Auction>();
		search.addAll(CollectionUtils.filter(a.values(), pred));

		return search.toArray(new Auction[1]);
	}

	@Override
	public Auction bid(String username, Integer itemId)
	{
		try
		{
			if(itemId != 0)
			{
				for(Auction auction : a.values())
				{
					if(auction.getId() == itemId)
					{
						auction.setCurrentBid(auction.getCurrentBid()+1);
						auction.setOwner(username);
						return auction;
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Id or username not found");
		}
		return null;
	}
	@Override
	public Auction create(Auction auction)
	{
		Auction newAuction = new Auction(auction.getId(), auction.getName(), auction.getCurrentBid());
		a.put(auction.getId(), newAuction);
		return newAuction;
	}
	@Override
	public void delete(Integer id)
	{
		if(id != null)
		{
			a.remove(id);
		}
	}
	@Override
	public Auction retreive(Integer id)
	{
		try
		{
			if(id != null)
			{
				return a.get(id);
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Id not found");
		}
		return null;
	}
	@Override
	public Auction update(Auction auction, Integer id)
	{
		try
		{
			a.put(id, auction);
			
		}
		catch(NullPointerException e)
		{
			System.out.println("Id not found.");
		}
		return a.get(id);
	}

}
