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
		boolean eval = false;
		if(criteria.contains("or")){
			String[] seperate = criteria.split("or");
			for (int i = 0; i < seperate.length; i++) {
				
			}
		}
		
		if(criteria.contains("and")){
			String[] seperate = criteria.split("and");
			
		}

		return t.getName().contains(criteria) || t.getDescription().contains(criteria);
	}
}
