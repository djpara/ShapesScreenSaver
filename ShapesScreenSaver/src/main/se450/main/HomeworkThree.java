package main.se450.main;
/*
 * Name     : David Para
 * Depaul#  : 1532165
 * Class    : SE 450
 * Homework : #5
 * Problem  : Homework Three
 * Due Date : 09/19/2016
 *
 * class HomeworkThree
 *
 */

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

//for various J'Controls'
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import main.se450.exceptions.BadShapeException;
import main.se450.factories.JSONFileShapeListFactory;
import main.se450.gui.JCustomPanel;
import main.se450.interfaces.IObservable;
import main.se450.interfaces.IShape;
import main.se450.observable.Motion;
import main.se450.singletons.ShapeList;

public class HomeworkThree extends JFrame /* TODO */ implements IObservable
{
	private static final long serialVersionUID = 1L;//I added this to remove the warning the Eclipse generates

	private Container content;//used for the content pane
	
	private JPanel movePanel;//contains start & stop buttons
	
	private JButton startButton; //stop button
	private JButton stopButton;  //stop button
	
	private JCustomPanel shapeOutput; //the output for the shape data

	public HomeworkThree()
	{
		setSize(600, 800);//set the size of the window to 600 x 800
		setTitle("Homework Three");//set the applications title
		
		setResizable(false);
		
		//Now create a panel to hold the move combo box and move description
		movePanel = new JPanel();
		
		//create the move buttons
		startButton = new JButton("Start");
		stopButton  = new JButton("Stop");
		
		startButton.setPreferredSize(new Dimension(240, 100));
		stopButton.setPreferredSize(new Dimension(240, 100));
		
		//the spring layout will handle the move panels controls spacing 
		//when the window is initialized and sized/resized
		SpringLayout movePanelLayout = new SpringLayout();

		//now lets set up the controls and how they will be position
		//in accordance to one another
		
		//start button is 5 below top of panel
		movePanelLayout.putConstraint(SpringLayout.NORTH, startButton, 5, 
									  SpringLayout.NORTH, movePanel);
		
		//start button 5 above botton of panel 
		movePanelLayout.putConstraint(SpringLayout.SOUTH, movePanel, 10, 
									  SpringLayout.SOUTH, startButton);
		
		//start button and stop button align
		movePanelLayout.putConstraint(SpringLayout.NORTH, stopButton, 0, 
									  SpringLayout.NORTH, startButton);
		
		//up button top adjust horizontally
		movePanelLayout.putConstraint(SpringLayout.WEST, startButton, 15, 
									  SpringLayout.WEST, movePanel);
		
		//down buttons left side with up button left side
		movePanelLayout.putConstraint(SpringLayout.EAST, stopButton, -15, 
									  SpringLayout.EAST, movePanel);
		
		//the panel dependencies has been configured so here we set it
		movePanel.setLayout(movePanelLayout);
		
		//add the buttons to the panel
		movePanel.add(startButton);
		movePanel.add(stopButton);
		
		//create the text area for displaying the shape(s) location
		shapeOutput  = new JCustomPanel();
		
		//give the panel an nice etched and titled border with the heading of "Observe"
		movePanel.setBorder(new TitledBorder(new EtchedBorder(), "Observe"));
		
		//get the content pane, as it is were we'll place our controls
		content = getContentPane();

		//Attach the move panel to the content pane
		content.add(movePanel);
		
		//Attach the scroll pane button to the content pane
		//the scroll pane wrap the move panel, so it will
		//by default include it as well
	    content.add( shapeOutput );
		
	    //lets create a final spring layout to include the other layout
	    //and add the rest of the controls
		SpringLayout contentLayout = new SpringLayout();
		
		//move panel setup
		//set move  panels west border 30 pixels away from content panes west border
		contentLayout.putConstraint(SpringLayout.WEST, movePanel, 20, 
									SpringLayout.WEST, content);

		//fix move panels east border -30 pixels away from content panes east border
		contentLayout.putConstraint(SpringLayout.EAST, movePanel, -20, 
									SpringLayout.EAST, content);
		
		//fix move panels north border 10 pixels away from content panes north border
		contentLayout.putConstraint(SpringLayout.NORTH, content, 10, 
									SpringLayout.SOUTH, movePanel);
		
		//fix scroll panes north border 10 pixels away from down buttons south border
		contentLayout.putConstraint(SpringLayout.NORTH, shapeOutput, 100, 
									SpringLayout.SOUTH, startButton);
		
		//fix scroll panes south border -10 pixels away from content panes south border
		contentLayout.putConstraint(SpringLayout.SOUTH, shapeOutput, -10, 
									SpringLayout.SOUTH, content);
		
		//fix scroll panes west border 30 pixels away from content panes west border
		contentLayout.putConstraint(SpringLayout.WEST, shapeOutput, 30, 
									SpringLayout.WEST, content);
		
		//fix scroll panes east border -30 pixels away from content panes east border
		contentLayout.putConstraint(SpringLayout.EAST, shapeOutput, -30, 
									SpringLayout.EAST, content);
		
	    //set the content panes layout 
		content.setLayout( contentLayout );
		
		//set the app to exit when the user presses the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startButton.addActionListener(new ActionListener()
		{
	        public void actionPerformed(ActionEvent arg0) 
	        {
	    		//TODO
	        	startObserving();
	        }
	    });
		
		stopButton.addActionListener(new ActionListener()
		{
	        public void actionPerformed(ActionEvent arg0) 
	        {
	    		//TODO
	        	stopObserving();
	        }
	    });
		
		//set the app to be visible
		setVisible(true);
		
		final ArrayList<IShape> iShapes = JSONFileShapeListFactory.makeShape("shapes.json", shapeOutput.getSize());
		
		ShapeList.getShapeList().addShapes(iShapes);
	}
	
	public HomeworkThree getHomeworkThree()
	{
		return this;
	}

	//the main entry point for the application
	public static void main(String[] args) throws BadShapeException
	{
		//create a new homework application
		new HomeworkThree();
	}
	
	public void startObserving()
	{
		Motion.startObserving(this);;
	}
	
	public void stopObserving()
	{
		Motion.stopObserving(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		shapeOutput.update();
	}

}
      