import java.io.IOException;
import java.util.Scanner;


public class FileBasedDatasource {
	InMemoryAuctionService IMAS = new InMemoryAuctionService();
	String UI = "milk";
	String input;
	Auction a = new Auction();
	Auction[] auctionResults = IMAS.search(UI);
	DefaultState def = new DefaultState();
	Scanner scan = new Scanner(System.in);
	public void CRUD() throws IOException{
	for(Auction auc : auctionResults){
		def.UserInput = "Scott";
		a.setCreate(def.UserInput);
		try{
			System.out.println(auc.toString());
		}
		catch(Exception e){
		}
		if(def.UserInput.equals(auc.getCreate())){
			System.out.println("It appears that you have created one or more items in the search results, would you like to edit/delete an item (y/n)");
			String userInput = null;
			userInput = scan.nextLine();
			if(userInput.equalsIgnoreCase("y")){
				//Iterates through and checks to see if they were the creator or not then prints that out
				System.out.println("Type in the id of the item to edit.");
				int id = 0;
				input = scan.nextLine();
				id = Integer.parseInt(input);
				System.out.println("Do you want to edit the 1)name, 2)description, 3)end date, 4)price or 5)delete.");
				input = scan.nextLine();
				if(input.equalsIgnoreCase("1")){
					if(auc.getCreate().equals(def.UserInput) && auc.getOwner() == null){
						System.out.println("The current name is \"" + auc.getName() + "\" type in the new name.");

						System.out.print("Type in the new name: ");
						IMAS.update(auc, id);
						input = scan.nextLine();
						auc.setName(input);
						System.out.println("The new name is \"" + auc.getName() + "\".");
					}
					else{
						System.out.println("You are not the owner of the selected item or a bid was already placed on the item.");
					}
				}
				else if(input.equalsIgnoreCase("2")){
						System.out.println("The current description is \"" + a.getDescription() + "\" type in the new description.");
						System.out.println("Type in the new description");
						IMAS.update(a, id);
						input = scan.nextLine();
						a.setDescription(input);
				}
				else if(input.equalsIgnoreCase("3")){
					//goes through and will edit the end date with the one received 
				}
				else if(input.equalsIgnoreCase("4")){
					System.out.println("Type in the new price");
					IMAS.update(a, id);
					input = scan.nextLine();
					int price = Integer.parseInt(input);
					a.setCurrentBid(price);
				}
				else if(input.equalsIgnoreCase("5")){
					//finds the item with the correct id then removes that item
					System.out.println("The item is now deleted.");
					IMAS.delete(id);
			   }	
			}
		 }
	  }
   }
}
