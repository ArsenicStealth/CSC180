import java.util.*;
public class Padding
{
	char endOfText = 0x03;
	public String pad(Object obj, int len)
	{
		String string = obj.toString();
		if(len < string.length())
		{
			//short
			 
			StringBuilder sb = new StringBuilder();
			while(len < string.length())
			{
				sb.append(endOfText);
			}
			return string.concat(sb.toString());
			
		}
		else if(len > string.length())
		{
			//long
			return string.substring(len);
		}
		return string;
		
	}
	
	public Object unpad(String string)
	{
		string.replaceAll("[0x03]", " ");
		return string;
		
	}
}
