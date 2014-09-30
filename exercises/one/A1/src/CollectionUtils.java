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
		Object[] ob = new Object[]{5,i,5};
		list.add(0, 5);
		list.add(1, i);
		list.add(2, 5);
		System.out.println(cardinality(o, list));
	}
	public static int cardinality(Object obj, Collection col){
		int numobjects = 0;
		Iterator it = col.iterator();
		while(it.hasNext()){
			Object ob = it.next();
			System.out.println(ob);
			if(ob == obj){
				numobjects++;
			}
		}
		return numobjects;
		
	}
}