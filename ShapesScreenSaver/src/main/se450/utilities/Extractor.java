package main.se450.utilities;

/**
*
*  The parser for the shapes file
* 
* @author Anthony Freund
*
*/

public class Extractor
{
	final public static Integer extractInteger(final Object object)
	{
		return Integer.parseInt(object.toString(), 10);
	}

	final public static Float extractFloat(final Object object)
	{
		return Float.parseFloat(object.toString());
	}
}
