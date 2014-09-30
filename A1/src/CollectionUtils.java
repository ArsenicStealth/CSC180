import java.util.Collection;


public class CollectionUtils {
	public static void main(String arg[]){
		
	}
	public static int cardinality(Object obj, Collection col){
		int numobjects = 0;
		for(int i = 0; i < col.size(); i++){
			if(col.contains(obj)){
				numobjects++;
			}
		}
		return numobjects;
		
	}
}
