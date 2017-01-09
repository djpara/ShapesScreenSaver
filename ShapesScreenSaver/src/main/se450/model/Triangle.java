package main.se450.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;

public class Triangle extends Shape
{
    private ArrayList<IShape> sides = new ArrayList<IShape>(3);

    private final static int BOTTOM_SIDE = 0;
    private final static int LEFT_SIDE   = 1;
    private final static int RIGHT_SIDE  = 2;
    
	//Read only pattern
	public Triangle(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iStrategy)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor, iStrategy);

        createLines();
    }

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
    
    private void createLines()
    {
        sides.clear();

        sides.add(BOTTOM_SIDE, new Line(getLeft(),     getBottom(), getRight(),    getBottom(), getX(), getY(), getRotation(), getColor(), getStrategy()));
        sides.add(LEFT_SIDE,   new Line(getLeft(),     getBottom(), getMidpoint(), getTop   (), getX(), getY(), getRotation(), getColor(), getStrategy()));
        sides.add(RIGHT_SIDE,  new Line(getMidpoint(), getTop(),    getRight(),    getBottom(), getX(), getY(), getRotation(), getColor(), getStrategy()));
    }

    private float getMidpoint()
    {
        return ((getRight() + getLeft()) * 0.5f);
    }	
	
	@Override
	public void draw(Graphics graphics) 
	{
        Iterator<IShape> iSides = sides.iterator();
        while (iSides.hasNext())
        {
            iSides.next().draw(graphics);
        }
    }
}
    