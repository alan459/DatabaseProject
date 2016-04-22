//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* To be used as an INNER panel on the left side part of a larger panel containing all the options for 
* the user - A display for the user to lookup patients in the database.
*****************************************************************************************************/
public class Patient_Lookup_Panel extends JPanel 
{
	//private JPanel mainPanel;

	/* Input submission buttons */
	private JButton ssnLookupButton, infoLookupButton; //, recordLookupButton;		

	/* Display to the user what type of information is being displayed in the adjacent position */
	private JLabel enterSSNLabel, enterFirstNameLabel, enterLastNameLabel, enterDOBLabel, patientLookupLabel;	

	/* Labels for displaying output data */
	private JLabel patientInfoLabel, patientNameOutputLabel, patientSSNOutputLabel, patientDOBOutputLabel;

	/* Fields for getting input from the user */
	private JTextField ssnLookupInput, firstNameInput, lastNameInput, dobInput;	



	/*********************************************************************************
	* Main constructor for setting up the patient lookup menu. 
	*********************************************************************************/
	public Patient_Lookup_Panel() 
	{
		//this.mainFrame = main;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeLabels();
		initializeButtons();
		initializeTextFields();
		addActionListeners();

		// add the components to the panel
		add(patientLookupLabel);
		//add(recordLookupLabel);
		add(enterSSNLabel);
		add(ssnLookupInput);
		add(ssnLookupButton);

		add(enterFirstNameLabel);
		add(firstNameInput);

		add(enterLastNameLabel);
		add(lastNameInput);

		add(enterDOBLabel);
		add(dobInput);

		add(infoLookupButton);

		// add labels that will display output info for patients 
		// labels will be appended with the patient info after 'submit'
		// clicked (ex: ssn - setText(getSSNText() + ssn) )
		add(patientInfoLabel);
		add(patientNameOutputLabel);
		add(patientSSNOutputLabel);
		add(patientDOBOutputLabel);


		//add(recordLookupButton);
		//add(mainMenuButton);
	}


	/*********************************************************************************
	* Initializes the labels for the Patient lookup menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		patientLookupLabel = new JLabel("Patient Lookup");
		//recordLookupLabel = new JLabel("Record Lookup");

		enterSSNLabel = new JLabel("by ssn:");

		enterFirstNameLabel = new JLabel("by first:");
		enterLastNameLabel = new JLabel("by last:");

		enterDOBLabel = new JLabel("dob:");


		patientInfoLabel = new JLabel("Patient Info:");

		patientNameOutputLabel = new JLabel("Name:");
		patientSSNOutputLabel = new JLabel("SSN:");
		patientDOBOutputLabel = new JLabel("DOB:");
	}


	/*********************************************************************************
	* Initializes the buttons for the patient lookup menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		ssnLookupButton = new JButton("Submit");
		infoLookupButton = new JButton("Submit");
		//recordLookupButton = new JButton("Submit");
		//mainMenuButton = new JButton("Main Menu");
	}


	/*********************************************************************************
	* Initializes the textfields for the patient lookup menu.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssnLookupInput = new JTextField(10);
		firstNameInput = new JTextField(10);
		lastNameInput = new JTextField(10);
		dobInput = new JTextField(10);
	}


	/*********************************************************************************
	* Adds the action listeners for the patient lookup menu.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Lookup a patient based on ssn */
		ssnLookupButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    	String ssn = getSSNData();
		    	if (ssn != null)
		    	{
		    		// pass the ssn data to a method that lookups patient data and returns it as a string
		    		// String patientData = getPatientData(ssn);
		    		//displayPatientData(patientData); 
		    	}
		    	else
		    	{
		    		// display error message somewhere
		    	}
		  }
		});

		/* Add functionality - Submit info button */
		infoLookupButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		   		
		  }
		});
	}


	/*********************************************************************************
	* Returns the input in the "lookup patient by ssn" field.
	*********************************************************************************/
	private String getSSNData()
	{
		try 
		{
			return ssnLookupInput.getText();
		} 
		catch (Exception e) 
		{
			return null;
		}
	}


	/*********************************************************************************
	* Fills the patient display fields with a patient's data.
	*********************************************************************************/
	private void displayPatientData(String data)
	{

	}
	

} // end patient lookup class