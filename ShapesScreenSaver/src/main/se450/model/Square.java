package main.se450.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import main.se450.interfaces.IStrategy;

public class Square extends Shape
{
	//Read only pattern
	public Square(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iStrategy)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor, iStrategy);
	}
	
	@Override
	public void draw(Graphics graphics) 
	{
  		Rectangle2D square = new Rectangle2D.Float(getLeft(), getTop(), getWidth(), getHeight());
		
  		Graphics2D g2d = (Graphics2D)(graphics);
  		
  		g2d.setColor(new Color(getColor()));
  		g2d.draw(square);
	}
}
    