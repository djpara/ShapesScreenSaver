package se450.collections;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.se450.collections.ShapeTuplet;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;
import main.se450.model.Circle;
import main.se450.strategies.PassThruStrategy;

public class ShapeTupletTest {
	
	@BeforeClass
	public static void setUpBeforeClass()  throws Exception 
	{
	}
	
	@AfterClass
	public static void tearDownBeforeClass()  throws Exception 
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
	public void testShapeTuplet()
	{
		Dimension d = new Dimension();
		IStrategy passThru = new PassThruStrategy(d);
		IShape  shape = new Circle(100, 100, 200, 200, 3, 4, 1, 0, passThru);
		ShapeTuplet shapeTuplet = new ShapeTuplet(shape, passThru);

		// Assert T1 stored Circle shape
		assertTrue(shapeTuplet.getT1() == shape);
		// Assert T2 stored PassThru strategy
		assertTrue(shapeTuplet.getT2() == passThru);
		
		
		
	}
	
}
