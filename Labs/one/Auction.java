import java.util.HashMap;
import java.util.Map;

public class Auction {
	int id;
	int currentBid;
	String owner;
	String name;
	Map<String, Object> prop = new HashMap<String, Object>();
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
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
	Auction(int id, String name, int currentBid){
	this.id = id;
	this.name = name;
	this.currentBid = currentBid;
	}
	public String toString(){
		return this.id + " " + this.currentBid + " " + this.name;
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
