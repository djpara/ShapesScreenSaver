package main.se450.strategies;

import java.awt.Dimension;

import main.se450.collections.Septuplet;
import main.se450.interfaces.IStrategy;

public class ReboundStrategy implements IStrategy
{
	private Dimension dimension = new Dimension(0,0);
	
	public ReboundStrategy(Dimension newDimension)
	{
		dimension.setSize(newDimension);
	}

	@Override
	public Septuplet<?,?,?,?,?,?,?> execute(float left, float top, float right, float bottom, float x, float y, int color) 
	{
		//TODO
		if (left < 0.0f || right > dimension.getWidth())
		{
			x = x + (x * -2.0f);
		}
		
		if (top < 0.0f || bottom > dimension.getHeight())
		{
			y = y + (y * -2.0f);
		}
		
		return new Septuplet<Float,Float,Float,Float,Float,Float,Integer>(left,top,right,bottom,x,y,color);
	}
	
}