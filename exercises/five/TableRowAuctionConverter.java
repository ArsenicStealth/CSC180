
public class TableRowAuctionConverter implements Converter<Auction> {

	@Override
	public String format(Auction fromObject)
	{
		String format = "| " +fromObject.getId() + "\t" + fromObject.getName() + "\t" + "$" +fromObject.getCurrentBid() + "\t" + fromObject.getDescription() + " |";
		return format;
	}

	@Override
	public Auction Parse(String fromString) {
		// TODO Auto-generated method stub
		return null;
	}

}
