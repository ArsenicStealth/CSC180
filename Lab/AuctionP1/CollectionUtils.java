import java.util.List;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CollectionUtils {
	
	public static int cardinality(Object obj, Collection col){
		int numobjects = 0;
		Iterator it = col.iterator();
		while(it.hasNext()){
			Object ob = it.next();
			if(ob == obj){
				numobjects++;
			}
		}
		return numobjects;
		
	}
}
