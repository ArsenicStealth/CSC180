import java.util.HashMap;
import java.util.Map;

public class Auction {
	private int id;
	private int currentBid;
	private String owner;
	private String name;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	
	public int getCurrentBid() {
		return currentBid;
	}
	
	public void setCurrentBid(int currentBid) {
		this.currentBid = currentBid;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	Auction(int id, String name, int currentBid, String description){
	this.id = id;
	this.name = name;
	this.currentBid = currentBid;
	this.description = description;
	}
	
	Auction(String name, int currentBid, String description){
		this.name = name;
		this.currentBid = currentBid;
		this.description = description;
		
	}
	
	public String toString(){
		return this.getId() + " " + this.getCurrentBid() + " " + this.getName() + " " + this.getDescription() + " " + this.getOwner();
	}
	
	public boolean equals(Object obj){
		return equals((Auction)obj);
	}
	
	public boolean equals(Auction a){
		return name.equals(a.name);
	}
	
	public int hashCode(){
		return name.hashCode();
		}
	
	}
