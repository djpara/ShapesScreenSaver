package main.se450.model;

import java.awt.Graphics;

import main.se450.collections.Septuplet;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;

/**
 * Shape is the abstract base class for all shape contexts which allow the application to create and
 * instantiate a shape, set its coordinates, direction of it's move function, and its individual
 * strategy to implement when the shape contacts the extreme limits of the window on which the
 * application is run.
 * The Shape object encapsulates the attributes needed for rendering operations of the class. This
 * includes:
 * <p>
 * <ul>
 * <li>The left, top, right, and bottom coordinates
 * <li>The x and y direction coordinates
 * <li>The rotation speed
 * <li>The color of the shape
 * <li>The rebound or pass through strategy
 * <p>
 * 
 * @author anthonyfruende
 * @see main.se450.interfaces.IShape
 *
 */
public abstract class Shape implements IShape
{
	private float     left      = 0.0f;
	private float     top       = 0.0f;
	private float     right     = 0.0f;
	private float     bottom    = 0.0f;
	private float     x         = 0.0f;
	private float     y         = 0.0f;
	private float     rotation  = 0.0f;
	private int       color     = 0;
	private IStrategy iStrategy = null;
	
	//Read only pattern
	/**
	 * The Shape(...) method instantiates the shape and sets its attributes.
	 *
	 * @param nLeft sets the left-most point of the shape
	 * @param nTop sets the top-most point of the shape
	 * @param nRight sets the right-most point of the shape
	 * @param nBottom sets the bottom-most point of the shape
	 * @param nX sets the direction speed on the x axis
	 * @param nY sets the direction speed on the y axis
	 * @param nRotation sets the rotation speed of the shape
	 * @param nColor sets the color of the shape
	 * @param iiStrategy sets the shape strategy to rebound or pass through
	 */
	public Shape(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iiStrategy)
	{
		left      = nLeft;
		top       = nTop;
		right     = nRight;
		bottom    = nBottom;
		x         = nX;
		y         = nY;
		rotation  = nRotation;
		color     = nColor;
		iStrategy = iiStrategy;
	}
	
	/**
	 * @return the left-most point of the shape 
	 */
	public float getLeft()
	{
		return left;
	}
	
	/**
	 * @return the top-most point of the shape
	 */
	public float getTop()
	{
		return top;
	}
	
	/**
	 * @return the right-most point of the shape
	 */
	public float getRight()
	{
		return right;
	}
	
	
	/**
	 * @return the bottom-most point of the shape
	 */
	public float getBottom()
	{
		return bottom;
	}
	
	/**
	 * @return the direction speed of the shape on the x axis
	 */
	public float getX()
	{
		return x;
	}
	
	/**
	 * @return the direction speed of the shape on the y axis
	 */
	public float getY()
	{
		return y;
	}

	/**
	 * @return the rotation speed of the shape
	 */
	public float getRotation()
	{
		return rotation;
	}
	
	/**
	 * @return the color of the shape
	 */
	public int getColor()
	{
		return color;
	}
	
	/**
	 * @return the width of the shape by calculating the difference from the right-most point and the left-most point of the shape
	 */
	public float getWidth()
	{
		return getRight() - getLeft();
	}
	
	/**
	 * @return the height of the shape by calculating the difference from the top-most point and the bottom-most point of the shape
	 */
	public float getHeight()
	{
		return getBottom() - getTop();
	}
	
	/**
	 * @return rebound or pass through strategy of the shape
	 */
	public final IStrategy getStrategy()
	{
		return iStrategy;
	}
	
	/**
	 * Shape overrides the generic move method of the {@link main.se450.interfaces.IShape} interface 
	 */
	@Override
	public void move() 
	{
		left   += x;
		top    += y;
		right  += x;
		bottom += y;
	}

	/**
	 * Shape overrides the argument move method of the {@link main.se450.interfaces.IShape} interface
	 */
	@Override
	public void move(float nX, float nY) 
	{
		left   += nX;
		top    += nY;
		right  += nX;
		bottom += nY;
	}
	
	/**
	 * Shape overrides the generic strategicmove method of the {@link main.se450.interfaces.IShape} interface
	 */
    @Override
    public void strategicmove()
    {
    	move();
    	
    	Septuplet<?,?,?,?,?,?,?> septuplet = iStrategy.execute(left, top, right, bottom, x, y, color);
    	
    	left   = (Float)septuplet.getT1();
    	top    = (Float)septuplet.getT2();
    	right  = (Float)septuplet.getT3();
    	bottom = (Float)septuplet.getT4();
    	x      = (Float)septuplet.getT5();
    	y      = (Float)septuplet.getT6();
    	color  = (Integer)septuplet.getT7();
    }
    
    /**
     * Shape overrides the draw method of the {@link main.se450.interfaces.IShape} interface
     */
	@Override
	public abstract void draw(Graphics g);
}
      