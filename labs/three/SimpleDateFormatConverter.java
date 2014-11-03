import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatConverter implements Converter<Date> {
	private SimpleDateFormat parserFormat, formatterFormat;
	private SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");

	public SimpleDateFormatConverter() {

		parserFormat = sdf;
		formatterFormat = sdf;
	}

	public SimpleDateFormatConverter(SimpleDateFormat sdf) {
		parserFormat = formatterFormat = sdf;
	}

	public SimpleDateFormatConverter(SimpleDateFormat forParsing,
			SimpleDateFormat forFormatting) {
		if (forParsing == null) {
			forParsing = sdf;
		}
		if (forFormatting == null) {
			forFormatting = sdf;
		}
		parserFormat = forParsing;
		formatterFormat = forFormatting;
	}

	@Override
	public Date Parse(String fromString) {

		try {
			return parserFormat.parse(fromString);
		} catch (ParseException e) {

		}
		return null;
	}

	@Override
	public String format(Date fromObject) {

		return formatterFormat.format(fromObject);

	}

}
