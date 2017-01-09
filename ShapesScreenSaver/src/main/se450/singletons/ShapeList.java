package main.se450.singletons;

import java.util.ArrayList;

import main.se450.interfaces.IShape;

public class ShapeList
{
	private static ShapeList shapeList = null;
	
	private ArrayList<IShape> iShapes = null;
	
	static 
	{
		//TODO
		if (shapeList == null)
		{
			shapeList = new ShapeList();
		}
	}
	
    private ShapeList()
    {
		//TODO
    	iShapes = new ArrayList<IShape>();
    }
    
	public final static ShapeList getShapeList() 
	{
		//TODO
		return shapeList;
	}
	
	public synchronized final ArrayList<IShape> getShapes()
	{
		//TODO
		return iShapes;
	}
	
	public synchronized void addShapes(final ArrayList<IShape> iShapeList)
	{
		iShapes = iShapeList;
		//TODO
	}
}
      