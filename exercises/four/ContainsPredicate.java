import java.util.ArrayList;


public class ContainsPredicate implements Predicate<Auction>
{
	private String criteria = "";
	
	public ContainsPredicate(String criteria){
		this.criteria = criteria;
	}
	@Override
	public boolean evaluate(Auction t)
	{
		//goes through one auction item and compares against one search criteria(one liner)
		return t.getName().contains(criteria);
	}
}
