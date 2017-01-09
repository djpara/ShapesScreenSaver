package main.se450.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;

public class Ship extends Shape
{

	private ArrayList<IShape> sides = new ArrayList<IShape>(4);
	
	private final static int LINE_1 = 0;
	private final static int LINE_2 = 1;
	private final static int LINE_3 = 2;
	private final static int LINE_4 = 3;
	
	
	//Read only pattern
	public Ship(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iStrategy)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor, iStrategy);

		createLines();
    }

	public float getMidpointX()
    {
        return (getLeft() + getRight()) / 2;
    }	
	
    public float getMidpointY()
    {
        return (getTop() + getBottom()) / 2;
    }
    
    private void createLines() 
    {
    	sides.clear();
    	
    	sides.add(LINE_1, new Line(getLeft(), getBottom(), getMidpointX(), getTop(), getX(), getY(), getRotation(), getColor(), getStrategy()));
    	sides.add(LINE_2, new Line(getLeft(), getBottom(), getMidpointX(), getMidpointY(), getX(), getY(), getRotation(), getColor(), getStrategy()));
    	sides.add(LINE_3, new Line(getMidpointX(), getTop(), getRight(), getBottom(), getX(), getY(), getRotation(), getColor(), getStrategy()));
    	sides.add(LINE_4, new Line(getMidpointX(), getMidpointY(), getRight(), getBottom(), getX(), getY(), getRotation(), getColor(), getStrategy()));
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO
        Iterator<IShape> iSides = sides.iterator();
        while (iSides.hasNext())
        {
            iSides.next().draw(g);
        }
	}	
    
    //TODO - add other methods

    @Override
    public void move(float x, float y)
    {
        super.move(x, y);

        createLines();
    }

    @Override
    public void move()
    {
        super.move();

        createLines();
    }
    
    @Override
    public void strategicmove()
    {
        super.strategicmove();

        createLines();
    }
}
 
    