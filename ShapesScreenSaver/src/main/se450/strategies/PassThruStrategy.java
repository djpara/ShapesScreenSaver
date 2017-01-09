package main.se450.strategies;

import java.awt.Dimension;

import main.se450.collections.Septuplet;
import main.se450.interfaces.IStrategy;

public class PassThruStrategy implements IStrategy
{
	private Dimension dimension = new Dimension();
	
	public PassThruStrategy(Dimension newDimension)
	{
		dimension.setSize(newDimension); 
	}

	@Override
	public Septuplet<?,?,?,?,?,?,?> execute(float left, float top, float right, float bottom, float x, float y, int color) 
	{
		if (right < 0.0f)
		{
			float nWidth = right - left;
			
		    left  = dimension.width;
		    right = left + nWidth;
		}
		else if (left > dimension.getWidth())
		{
			float nWidth = right - left;
			
		    right = 0;
		    left  = right - nWidth;
		}
		
		if (bottom < 0.0f)
		{
			float nHeight = bottom - top;
			
		    top    = dimension.height;
		    bottom = top + nHeight;
		}
		else if (top > dimension.getHeight())
		{
			float nHeight = bottom - top;

		    bottom = 0;
			top    = bottom - nHeight;
		}
		
		return new Septuplet<Float,Float,Float,Float,Float,Float,Integer>(left,top,right,bottom,x,y,color);
	}
}