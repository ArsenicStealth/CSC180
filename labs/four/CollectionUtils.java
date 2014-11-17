import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils
{
	public static <T> Collection<T> filter(Collection<T> coll, Predicate<T> predicate)
	{
		//should iterate through the elements of the collection and include them in a final collection
		//that only if that element passes the evaluate method in the predicate
		List<T> results = new ArrayList<T>();
		for(T t : coll)
		{
			if(predicate.evaluate(t))
			{
				results.add(t);
			}
		}
		return results;
	}
	public static int cardinality(java.lang.Object obj, Collection coll)
	{
		int count = 0;
		for (Object obj1 : coll)
		{
			if (obj.equals(obj1))
			{
				count++;
			}
		}

		return count;
	}
}
