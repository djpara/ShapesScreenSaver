package test.se450.singletons;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.se450.singletons.ShapeList;
import main.se450.interfaces.IShape;
import main.se450.exceptions.BadShapeException;
import main.se450.factories.ShapeFactory;

public class SingletonsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	}

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}
	
	@Test
	public void testAddShapes() throws BadShapeException
	{
		ArrayList<IShape> shapes = new ArrayList<IShape>();
		// Sanity Check #1
		assertTrue(shapes.size() == 0);
		shapes.add(ShapeFactory.makeShape("Circle", 150, 150, 50, 50, 5, 5, 5, 0, null));
		// Sanity Check #2
		assertTrue(shapes.size() == 1);
		IShape shape = shapes.get(0);
		// Add Shapes to the Singleton instance
		ShapeList.getShapeList().addShapes(shapes);
		// Retrieve shapesList from the Singleton instance
		ArrayList<IShape> shapesInShapesList = ShapeList.getShapeList().getShapes();
		// Make sure its the same list by first checking the size
		assertTrue(shapesInShapesList.size() == 1);
		IShape shapeInShapesList = shapesInShapesList.get(0);
		// Now check to make sure that the contents are the same
		assertTrue(shape == shapeInShapesList);
	}
	
}
