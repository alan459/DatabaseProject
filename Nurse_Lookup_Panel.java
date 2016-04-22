//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* To be used as an INNER panel on the left side part of a larger panel containing all the options for 
* the user - A display for the user to lookup nurses in the database.
*****************************************************************************************************/
public class Nurse_Lookup_Panel extends JPanel 
{
	//private JPanel mainPanel;

	/* Input submission buttons */
	private JButton SSN_LOOKUP_BUTTON, INFO_LOOKUP_BUTTON; //, recordLookupButton;		

	/* Display to the user what type of information is being displayed in the adjacent position */
	private JLabel ENTER_SSN_LABEL, ENTER_FIRST_NAME_LABEL, ENTER_LAST_NAME_LABEL, ENTER_DOB_LABEL, NURSE_LOOKUP_LABEL;	

	/* Labels for displaying output data */
	private JLabel NURSE_INFO_LABEL, NURSE_NAME_OUTPUT_LABEL, NURSE_SSN_OUTPUT_LABEL, NURSE_DOB_OUTPUT_LABEL;

	/* Fields for getting input from the user */
	private JTextField SSN_LOOKUP_FIELD, FIRST_NAME_FIELD, LAST_NAME_FIELD, DOB_FIELD;	



	/*********************************************************************************
	* Main constructor for setting up the nurse lookup menu. 
	*********************************************************************************/
	public Nurse_Lookup_Panel() 
	{
		//this.mainFrame = main;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeLabels();
		initializeButtons();
		initializeTextFields();
		addActionListeners();

		// add the components to the panel
		add(NURSE_LOOKUP_LABEL);
		//add(recordLookupLabel);
		add(ENTER_SSN_LABEL);
		add(SSN_LOOKUP_FIELD);
		add(SSN_LOOKUP_BUTTON);

		add(ENTER_FIRST_NAME_LABEL);
		add(FIRST_NAME_FIELD);

		add(ENTER_LAST_NAME_LABEL);
		add(LAST_NAME_FIELD);

		add(ENTER_DOB_LABEL);
		add(DOB_FIELD);

		add(INFO_LOOKUP_BUTTON);

		// add labels that will display output info for nurses 
		// labels will be appended with the nurse info after 'submit'
		// clicked (ex: ssn - setText(getSSNText() + ssn) )
		add(NURSE_INFO_LABEL);
		add(NURSE_NAME_OUTPUT_LABEL);
		add(NURSE_SSN_OUTPUT_LABEL);
		add(NURSE_DOB_OUTPUT_LABEL);


		//add(recordLookupButton);
		//add(mainMenuButton);
	}


	/*********************************************************************************
	* Initializes the labels for the nurse lookup menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		NURSE_LOOKUP_LABEL = new JLabel("Nurse Lookup");
		//recordLookupLabel = new JLabel("Record Lookup");

		ENTER_SSN_LABEL = new JLabel("by ssn:");

		ENTER_FIRST_NAME_LABEL = new JLabel("by first:");
		ENTER_LAST_NAME_LABEL = new JLabel("by last:");

		ENTER_DOB_LABEL = new JLabel("dob:");


		NURSE_INFO_LABEL = new JLabel("nurse Info:");

		NURSE_NAME_OUTPUT_LABEL = new JLabel("Name:");
		NURSE_SSN_OUTPUT_LABEL = new JLabel("SSN:");
		NURSE_DOB_OUTPUT_LABEL = new JLabel("DOB:");
	}


	/*********************************************************************************
	* Initializes the buttons for the nurse lookup menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		SSN_LOOKUP_BUTTON = new JButton("Submit");
		INFO_LOOKUP_BUTTON = new JButton("Submit");
		//recordLookupButton = new JButton("Submit");
		//mainMenuButton = new JButton("Main Menu");
	}


	/*********************************************************************************
	* Initializes the textfields for the nurse lookup menu.
	*********************************************************************************/
	private void initializeTextFields()
	{
		SSN_LOOKUP_FIELD = new JTextField(10);
		FIRST_NAME_FIELD = new JTextField(10);
		LAST_NAME_FIELD = new JTextField(10);
		DOB_FIELD = new JTextField(10);
	}


	/*********************************************************************************
	* Adds the action listeners for the nurse lookup menu.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Lookup a nurse based on ssn */
		SSN_LOOKUP_BUTTON.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    	String ssn = getSSNData();
		    	if (ssn != null)
		    	{
		    		// pass the ssn data to a method that lookups nurse data and returns it as a string
		    		// String nurseData = getnurseData(ssn);
		    		//displaynurseData(nurseData); 
		    	}
		    	else
		    	{
		    		// display error message somewhere
		    	}
		  }
		});

		/* Add functionality - Submit info button */
		INFO_LOOKUP_BUTTON.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		   		
		  }
		});
	}


	/*********************************************************************************
	* Returns the input in the "lookup nurse by ssn" field.
	*********************************************************************************/
	private String getSSNData()
	{
		try 
		{
			return SSN_LOOKUP_FIELD.getText();
		} 
		catch (Exception e) 
		{
			return null;
		}
	}


	/*********************************************************************************
	* Fills the nurse display fields with a nurse's data.
	*********************************************************************************/
	private void displayNurseData(String data)
	{

	}

} // end nurse lookup class