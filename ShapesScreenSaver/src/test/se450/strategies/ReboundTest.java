package se450.strategies;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.se450.collections.Septuplet;
import main.se450.strategies.ReboundStrategy;

public class ReboundTest {
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
	public void testSeptuplet() 
	{
		Dimension dimension = new Dimension(0,0);
		ReboundStrategy strategy = new ReboundStrategy(dimension);
		
		// For visual purposes: x is negative and y is positive 20
		float x = -20.0f;
		float y = 20.0f;
		
		Septuplet newXandY = strategy.execute(20, 20, 80, 80, x, y, 0);
		
		// After executing the inverse, x should be 20
		float testX = (float)newXandY.getT5();
		assertTrue(testX == 20);
		
		// After executing the inverse, y should be negative 20
		float testY = (float)newXandY.getT6();
		assertTrue(testY == -20);
		
	}

}
