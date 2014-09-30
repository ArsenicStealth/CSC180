import java.util.List;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CollectionUtils {
	public static void main(String arg[]){
		Object o = 5;
		Object i = null;
		List list = new ArrayList();
		list.add(0, 5);
		list.add(1, i);
		list.add(2, 5);
		List l = new ArrayList();
		//null
		System.out.println(cardinality(o, l));
		// not null
		System.out.println(cardinality(o, list));
	}
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
