package main.se450.interfaces;

import java.awt.Graphics;

/**
 * The interface designed to be implemented by the {@link main.se450.model.Shape} class providing an extra level of encapsulation.
 * 
 * @author anthonyfruende
 *
 */
public interface IShape 
{
	/**
	 * Each shape implementing IShape with move in accordance to its x and y attributes.
	 * This overloaded move method is expected to be overwritten by each class implementing the IShape interface.
	 * 
	 * @param x represents the x axis of the Cartesian Coordinate system
	 * @param y represents the y axis of the Cartesian Coordinate system
	 */
	void move(float x, float y);
	
	/**
	 * General move method.
	 * This move method is expected to be overwritten by each class implementing the IShape interface.
	 */
	void move();
	
	/**
	 * Each shape will hold either a pass-through function or a rebound function.
	 * The strategicmove method is expected to be overwritten by each class implementing the IShape interface.
	 */
	void strategicmove();
	
	/**
	 * 
	 * Each shape will draw its own pattern, color, and size.
	 * The draw method is expected to be overwritten by each class implementing the IShape interface.
	 * 
	 * @param g holds the reference to a Graphics class to be implemented for drawing objects.
	 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Graphics</a>
	 */
	void draw(Graphics g);
}
      