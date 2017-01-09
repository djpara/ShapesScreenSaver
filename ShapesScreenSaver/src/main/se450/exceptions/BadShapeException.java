package main.se450.exceptions;

/**
 * The BadShapeException is a concrete Exception class which allows the application to keep
 * running and omit any shapes that are incompatible with the program.
 * For example, if a shape is passed through the JSON parser, but is not recognize ("Amoeba"), the
 * BadShapeException simple throws the exception and proceeds to the next shape in the list.
 * 
 * @author anthonyfruende
 *
 */
		
public class BadShapeException extends Exception
{

	private static final long serialVersionUID = 1L;

	private String type = "Unknown";

	/**
	 * Default BadShapeException constructor
	 */
	public BadShapeException()
	{
	}
	
	/**
	 * 
	 * @param sType represents the string message printed to the Console upon execution of the BadShapeException
	 */
	public BadShapeException(final String sType)
	{
		type = sType;
	}
	
	/**
	 * The getMessage String generates the appropriate message to display upon execution of the BadShapeException
	 */
	public String getMessage()
	{
		return "Bad Shape : "  + type;
	}
}
    