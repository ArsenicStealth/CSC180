
public interface Converter<T> {

		T Parse(String fromString);
		String format(T fromObject);
}
