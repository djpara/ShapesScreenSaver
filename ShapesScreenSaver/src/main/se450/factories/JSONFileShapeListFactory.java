package main.se450.factories;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.se450.exceptions.BadShapeException;
import main.se450.exceptions.BadStrategyException;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;
import main.se450.utilities.Extractor;

/**
 * The JSONFileShapeListFactory is a factory pattern that offers a less cohesive way of extracting 
 * data from the JSON file.
 * 
 * @author anthonyfreunde
 */
public class JSONFileShapeListFactory
{
	/**
	 *  JSONFileShapeListFactory default constructor.
	 */
	private JSONFileShapeListFactory()
	{
	}
	
	/**  
	 * The makeShape method extracts shape data from the JSON file to create an a new instance of type
	 * {@link main.se450.interfaces.IShape}.
	 * <p>
 	 * <ul>
 	 * <li>{@link main.se450.model.Circle}
 	 * <li>{@link main.se450.model.Line}
 	 * <li>{@link main.se450.model.Ship}
 	 * <li>{@link main.se450.model.Square}
 	 * <li>{@link main.se450.model.Triangle}
 	 * </ul>
 	 * <p>
 	 * The shapes are created by using the {@link main.se450.interfaces.IShape} interface for encapsulation and by implementing 
 	 * another factory pattern through the {@link main.se450.factories.ShapeFactory} class.
  	 * The ShapeFactory returns a shape of type {@link main.se450.interfaces.IShape} and adds the shape to an ArrayList.
 	 * <p>
 	 * Should a bad shape be passed, it will catch the exception and move on to the next shape in
 	 * the JSON file.
 	 * <p>
 	 * Returns iShapes ArrayList containing all of the eligible shapes extracted from the JSON file.
 	 * 
	 * @param fileName the name of the file from which to read in shape data
	 * @param dimension of type Dimension encapsulating height and width of a component. 
	 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html">Dimension</a>
	 * @see main.se450.factories.ShapeFactory
	 * @see main.se450.interfaces.IShape 
	 * @return The iShapes ArrayList containing all of the shapes extracted from the JSON file and their attributes.
	 */
	public static ArrayList<IShape> makeShape(String fileName, final Dimension dimension)
	{
        ArrayList<IShape> iShapes = new ArrayList<IShape>();
        
		try
		{ 
	        JSONParser parser = new JSONParser();
	 
	        Object obj = parser.parse(new FileReader(fileName));
	 
	        JSONObject jsonObject = (JSONObject) obj;
	 
	        JSONArray jsonArray = (JSONArray) jsonObject.get("shapes");
	        
	        Iterator<?> jsonIterator = jsonArray.iterator();
	        while (jsonIterator.hasNext())
	        {
	        	JSONObject someShape = (JSONObject)jsonIterator.next();
	        	if (someShape.containsKey("type"))
	        	{
	        		try
	        		{
	        			try
	        			{
							IStrategy iStrategy = StrategyFactory.makeStrategy(someShape.get("borders").toString(), dimension);
						
			        		IShape iShape = ShapeFactory.makeShape(someShape.get("type").toString(), 
					        									   Extractor.extractFloat(someShape.get("left")),
					        									   Extractor.extractFloat(someShape.get("top")),
					        									   Extractor.extractFloat(someShape.get("right")),
					        									   Extractor.extractFloat(someShape.get("bottom")),
					        									   Extractor.extractFloat(someShape.get("x")),
					        									   Extractor.extractFloat(someShape.get("y")),
					        									   Extractor.extractFloat(someShape.get("rotation")),
					        									   Extractor.extractInteger(someShape.get("color")),
			        											   iStrategy);
		        		
			        		iShapes.add(iShape);
	        			}
	        			catch (BadStrategyException e)
	        			{
		        			System.out.println(e);
	        			}
	        		}
	        		catch (BadShapeException e)
	        		{
	        			System.out.println(e);
	        		}
	        	}
	        	
	        }
		}
        catch(FileNotFoundException eFileNotFound)
        {
        }
        catch(IOException eIOException)
        {
        	
        }
        catch(ParseException eParseException)
        {
        }
		
		return iShapes;
	}
}
      