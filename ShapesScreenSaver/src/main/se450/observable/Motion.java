package main.se450.observable;
/*
 * Name     : David Para
 * Depaul#  : 1532165
 * Class    : SE 450
 * Homework : #5
 * Problem  : LectureFour
 * Due Date : 09/19/2016
 *
 * class LectureThree
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import main.se450.factories.NamedThreadFactory;
import main.se450.interfaces.IObservable;

public class Motion implements Runnable
{
	private static Motion motion = new Motion();
	
	private boolean inMotion = false;
	private ScheduledThreadPoolExecutor scheduler = null;

	private final static int FRAMES_PER_SECOND = 20; 
	
	private final static int NANO_SECONDS_PER_SECOND = 1000000000;
			
	private ArrayList<IObservable> observables  = new ArrayList<IObservable>();
	
	private Motion()
	{
	}

	private static Motion getMotion()
	{
		return motion;
	}
	
	public static void startObserving(final IObservable iObservable)
	{
		Motion motion = getMotion();
		if (motion != null)
			motion.addObserver(iObservable);
	}
	
	private synchronized void addObserver(final IObservable iObservable)
	{
		if (iObservable != null)
		{
			if (!observables.contains(iObservable))
			{
				observables.add(iObservable);
		
				if (!getIsInMotion())
					startMotion();
			}
		}
	}
	
	public static void stopObserving(final IObservable iObservable)
	{
		Motion motion = getMotion();
		if (motion != null)
			motion.removeObserver(iObservable);
	}

	private synchronized void removeObserver(final IObservable iObservable)
	{
		observables.remove(iObservable);

		if (observables.isEmpty())
			stopMotion();
	}
	
	private synchronized void startMotion()
	{
		setIsInMotion(true);
		
		if (FRAMES_PER_SECOND > 0)
		{
			if (scheduler == null)
			{
				NamedThreadFactory lectureFourThreadFactory = new NamedThreadFactory("Motion");
				
				scheduler = new ScheduledThreadPoolExecutor(1, lectureFourThreadFactory);
				if (scheduler != null)
					scheduler.scheduleAtFixedRate(this, 0, NANO_SECONDS_PER_SECOND / FRAMES_PER_SECOND, TimeUnit.NANOSECONDS);//~20 frames per second
			}
		}
	}

	private synchronized void stopMotion()
	{
		setIsInMotion(false);
		
		if (scheduler != null)
		{
			scheduler.shutdown();
			
			scheduler = null;
		}
	}
	
	public static final boolean isInMotion()
	{
		Motion motion = getMotion();
		return (motion != null ? motion.getIsInMotion() : false);
	}

	public final synchronized boolean getIsInMotion()
	{
		return inMotion;
	}
	
	private final synchronized void setIsInMotion(final boolean bIsInMotion)
	{
		inMotion = bIsInMotion;
	}
	
	public synchronized void run()
	{
		if ((observables != null) && (isInMotion()))
		{
			Iterator<IObservable> iiObservables = observables.iterator();
			while (iiObservables.hasNext())
			{
				IObservable iObservable = iiObservables.next();
				if (iObservable != null)
				{
					iObservable.update();
				}
			}
		}
	}	
}
