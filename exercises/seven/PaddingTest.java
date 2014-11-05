import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class PaddingTest
{

	@Test
	public void testLongPad()
	{
		Padding padding = new Padding();
		Assert.assertEquals("startin", padding.pad("startingssadsfasasdf", 7));
	}
	
	@Test
	public void testShortPad()
	{
		Padding padding = new Padding();
		Assert.assertEquals("start  ", padding.pad("start", 7));
	}

	@Test
	public void testUnpad()
	{
		Padding padding = new Padding();
		Assert.assertEquals("startsadf",padding.unpad("start"));
	}
}
