package main.se450.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import main.se450.interfaces.IShape;
import main.se450.singletons.ShapeList;

/*
 * Name     : David Para
 * Depaul#  : 1532165
 * Class    : SE 450
 * Homework : #5
 * Problem  : LectureTwo
 * Due Date : 09/19/2016
 *
 * class LectureTwo
 *
 */

public class JCustomPanel extends JPanel
{
  	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JCustomPanel()
	{
	}
	
	public void paint(Graphics g) 
  	{
		Dimension dimension = getSize();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, dimension.width, dimension.height);
		
		final ArrayList<IShape> iShapeList = ShapeList.getShapeList().getShapes();
		if (iShapeList != null)
		{
			Iterator<IShape> iiShapes = iShapeList.iterator();
			while (iiShapes.hasNext())
			{
				iiShapes.next().draw(g);
			}
		}
    }  	
	
	public void update() 
	{
		ArrayList<IShape> iShapeList = 	ShapeList.getShapeList().getShapes();
		if (iShapeList != null)
		{
			Iterator<IShape> iiShapes = iShapeList.iterator();
			while (iiShapes.hasNext())
			{
				IShape iShape = iiShapes.next();
				if (iShape != null)
				{
					iShape.strategicmove();
				}
			}
		}
		
		repaint();
	}

}
      