package main.se450.factories;

import java.awt.Dimension;

import main.se450.exceptions.BadStrategyException;
import main.se450.interfaces.IStrategy;
import main.se450.strategies.PassThruStrategy;
import main.se450.strategies.ReboundStrategy;

public class StrategyFactory
{
	private StrategyFactory()
	{
	}
	
	public static IStrategy makeStrategy(final String sStrategy, final Dimension dimension) throws BadStrategyException
	{
		IStrategy iStrategy = null;

    	if (sStrategy.equals("PassThru"))
    	{
    		iStrategy = new PassThruStrategy(dimension);
    	}
        else if (sStrategy.equals("Rebound"))
    	{
        	iStrategy = new ReboundStrategy(dimension);
    	}
    	else
    	{
    		throw new BadStrategyException(sStrategy);
    	}
		
		return iStrategy;
	}
}
      