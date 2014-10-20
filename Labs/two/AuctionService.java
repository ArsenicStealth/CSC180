import java.util.HashMap;


public interface AuctionService {
	Auction[] search(String criteria);
	void bid(String username, Integer itemid);
	Auction create(Auction auction);
	void delete(Integer id);
	Auction retreive(Integer id);
	Auction update(Auction auction, Integer id);
}
