package main.se450.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import main.se450.interfaces.IStrategy;

public class Line extends Shape
{
	//Read only pattern
	public Line(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iStrategy)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor, iStrategy);
	}
	
	@Override
	public void draw(Graphics graphics) 
	{
  		Line2D line = new Line2D.Float(getLeft(), getTop(), getRight(), getBottom());
		
  		Graphics2D g2d = (Graphics2D)(graphics);
  		
  		g2d.setColor(new Color(getColor()));
  		g2d.draw(line);
	}
}
    
      