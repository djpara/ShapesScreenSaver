package test.se450.model;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.se450.model.Ship;

public class ShipTest 
{

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
	public void testGetMidpointX() 
	{
		Ship ship = new Ship(50.0f, 50.0f, 200.0f, 200.0f, 0.0f, 0.0f, 0.0f, 0, null);
				
		assertTrue(ship.getMidpointX() == 125.0f);
	}

	@Test
	public void testGetMidpointY() 
	{
		Ship ship = new Ship(10.0f, 20.0f, 30.0f, 40.0f, 0.0f, 0.0f, 0.0f, 0, null);

		assertTrue(ship.getMidpointY() == 30.0f);
	}
}
