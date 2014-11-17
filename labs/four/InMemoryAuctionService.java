import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InMemoryAuctionService implements AuctionService {
	int count = 0;
	RegexPractice regx = new RegexPractice();
	static Map<Integer, Auction> a = new HashMap<Integer, Auction>();

	public InMemoryAuctionService() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		Auction a0 = new Auction(0, "milk", "2% milk from a human", 0, 0, d);
		Auction a1 = new Auction(1, "lunchable", "best food ever", 2, 0, d);
		Auction a2 = new Auction(2, "shirt", "my awesome shirt", 5, 0, d );
		Auction a3 = new Auction(3, "human Eye", "my best friends eye i borrowed it for a day", 200, 0, d);
		a.put(a0.getId(), a0);
		a.put(a1.getId(), a1);
		a.put(a2.getId(), a2);
		a.put(a3.getId(), a3);
		count = count + 4;
	}
	
	public InMemoryAuctionService(Path filePath) throws IOException
	{
		
		String id = "";
		String name = "";
		String currentBid = "";
		String bidsRemaining = "";
		String date = "";
		
		byte[] arrayofbytes = null;
		try {
			arrayofbytes = Files.readAllBytes(filePath);
		} catch (IOException e) {
			
		}
		String text = new String(arrayofbytes);
				String[] s = text.split("<h3 class=\"lv[a-zA-Z0-9\"]+><a href=\"");
				for (int i = 1; i < s.length; i++)
				{
					Pattern pattern = Pattern.compile("[0-9]+</li>");
					Matcher matcher = pattern.matcher(s[i]);
					
					if (matcher.find()) {
					    id = (matcher.group());
					    id = id.replace("</li>", "");
					}
					pattern = Pattern.compile("\"img\" alt=\"(?:[^\\\"]+|\\.)*\"");
					matcher = pattern.matcher(s[i]);
					
					if (matcher.find()) {
					    name = (matcher.group());
					    name = name.replace("\"img\" alt=\"", "");
					}
					pattern = Pattern.compile("Get it on or before <b>[a-zA-Z0-9,?.? ?]+");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    date = (matcher.group());
					    date = (date.replace("<b>", ""));
					    date = (date.replace("Get it on or before", ""));
					}pattern = Pattern.compile("[$]+[0-9]+.+ ");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    currentBid = (matcher.group());
					    currentBid = currentBid.replace("$", "");
					    currentBid = currentBid.replace(".", "");
					}
					pattern = Pattern.compile("<span>+[0-9]+ bid");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    bidsRemaining = (matcher.group());
					    bidsRemaining = bidsRemaining.replace("<span>", "");
					    bidsRemaining = bidsRemaining.replace(" bid", "");
					}
					Date d= null;
					try
					{
						d = new SimpleDateFormat("EE, MM. d", Locale.ENGLISH).parse(date);
					} catch (ParseException e)
					{
						System.err.println("Invalid Date FOrmat");
						
					}

					this.create(new Auction(123, name, "car", 5 , 0, d));
				}		  

		
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
			// if fixed this
			if(OP.pop().equals("and")){
				APred and = new APred(Pred.pop(), Pred.pop());
					Pred.push(and);
			}else{
			OrPred or = new OrPred(Pred.pop(), Pred.pop());
			Pred.push(or);
			}
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
		// creates new auction with the values from the FIXED
		//passed in auction. then returns the new auction. FIXED
		// have a static value that will check for the available number FIXED
		return a.put(auction.getId(), auction);
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
		DefaultState DEF = new DefaultState();
		try {
			if(auction.getOwner() == DEF.UserState.getUserName()){
				a.put(id, auction);
				return a.get(id);
			}else{
				
			}
			
		} catch (NullPointerException e) {
			System.err.println("ID not found");
		}
		return null;
	}
}
