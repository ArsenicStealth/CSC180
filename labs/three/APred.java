
public class APred implements Predicate<Auction> {
	private Predicate<Auction> first;
	private Predicate<Auction> last;
	
	public APred(Predicate one, Predicate two) {
		this.setF(one);
		this.setL(two);
		}
	public Predicate getF() {
		return first;
	}
	public void setF(Predicate first){
		this.first = first;
	}
	public Predicate getL(){
		return last;
	}
	public void setL(Predicate last){
		this.last = last;
	}
	@Override
	public boolean evaluate(Auction a){
		return first.evaluate(a) && last.evaluate(a);
	}
}
