package main.se450.factories;

import main.se450.exceptions.BadShapeException;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;
import main.se450.model.Circle;
import main.se450.model.Line;
import main.se450.model.Ship;
import main.se450.model.Square;
import main.se450.model.Triangle;

/**
 * The ShapeFactory is a factory design class that allows the application to produce
 * different shapes.
 * The ShapeFactory class is designed to create a less cohesive model and allows a more
 * decoubled design.
 *
 * @author anthonyfruende
 *
 */
public class ShapeFactory
{
	/**
	 * Default constructor for the ShapeFactory class.
	 */
	private ShapeFactory()
	{
	}
	
	/**
	 * This makeShape(...) method creates an instance of a shape casted to IShape.
	 * This method creates the following shapes:
	 * <p>
	 * <ul>
	 * <li>{@link main.se450.model.Circle}
	 * <li>{@link main.se450.model.Square}
	 * <li>{@link main.se450.model.Line}
	 * <li>{@link main.se450.model.Triangle}
	 * <li>{@link main.se450.model.Ship}
	 * </ul>
	 * 
	 * @param type represents the shape to be created
	 * @param left represents the left-most point on the shape
	 * @param top represents the top-most point on the shape
	 * @param right represents the right-most point on the shape
	 * @param bottom represents the bottom-most point on the shape
	 * @param x represents the direction the shape is moving on the x axis
	 * @param y represents the direction the shape is moving on the y axis
	 * @param rotation represents the rotations speed on the z axis
	 * @param color represents the color of the shape
	 * @param iStrategy represents the strategy used when the shape approaches the end of the window
	 * @return returns a shape of type {@link main.se450.interfaces.IShape}
	 * @throws BadShapeException throws exception if the type is an invalid entry and is not one of the shapes listed above.
	 * @see main.se450.exceptions.BadShapeException
	 */
	public static IShape makeShape(final String type, float left, float top, float right, float bottom, float x, float y, float rotation, int color, IStrategy iStrategy) throws BadShapeException
	{
		IShape iShape = null;

    	if (type.equals("Circle"))
    	{
    		iShape = new Circle(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
        else if (type.equals("Square"))
    	{
    		iShape = new Square(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else if (type.equals("Line"))
    	{
    		iShape = new Line(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else if (type.equals("Triangle"))
    	{
    		iShape = new Triangle(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else if (type.equals("Ship"))
    	{
    		iShape = new Ship(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else
    	{
    		throw new BadShapeException(type);
    	}
		
		return iShape;
	}
}
      