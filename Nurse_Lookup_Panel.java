import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* To be used as the leftside INNER panel as part of a larger panel containing all the options for 
* the user. 
*
* A display for the user to lookup nurses in the database.
*****************************************************************************************************/
public class Nurse_Lookup_Panel extends JPanel 
{
	/* Input submission buttons */
	private JButton ssn_lookup_button; //, recordLookupButton;		

	/* Display to the user what type of information is being displayed in the adjacent position */
	private JLabel enter_ssn_label, nurse_lookup_label;	

	/* Labels for displaying output data */
	private JLabel nurse_info_label, nurse_name_output_label, nurse_ssn_output_label, nurse_dob_output_label;

	/* Fields for getting input from the user */
	private JTextField ssn_lookup_field;	



	/*********************************************************************************
	* Main constructor for setting up the nurse lookup menu. 
	*********************************************************************************/
	public Nurse_Lookup_Panel() 
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeLabels();
		initializeButtons();
		initializeTextFields();
		addActionListeners();

		// add the components to the panel
		add(nurse_lookup_label);
		//add(recordLookupLabel);
		add(enter_ssn_label);
		add(ssn_lookup_field);
		add(ssn_lookup_button);

		// add labels that will display output info for nurses 
		// labels will be appended with the nurse info after 'submit'
		// clicked (ex: ssn - setText(getSSNText() + ssn) )
		add(nurse_info_label);
		add(nurse_name_output_label);
		add(nurse_ssn_output_label);
		add(nurse_dob_output_label);


		//add(recordLookupButton);
		//add(mainMenuButton);
	}


	/*********************************************************************************
	* Initializes the labels for the nurse lookup menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		nurse_lookup_label = new JLabel("Nurse Lookup");
		//recordLookupLabel = new JLabel("Record Lookup");

		enter_ssn_label = new JLabel("\nby ssn:");

		nurse_info_label = new JLabel("Nurse Info:");

		nurse_name_output_label = new JLabel("Name:");
		nurse_ssn_output_label = new JLabel("SSN:");
		nurse_dob_output_label = new JLabel("DOB:");
	}


	/*********************************************************************************
	* Initializes the buttons for the nurse lookup menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		ssn_lookup_button = new JButton("Submit");
	}


	/*********************************************************************************
	* Initializes the textfields for the nurse lookup menu.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_lookup_field = new JTextField(10);
	}


	/*********************************************************************************
	* Adds the action listeners for the nurse lookup menu.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Lookup a nurse based on ssn */
		ssn_lookup_button.addActionListener(new ActionListener()
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

	}


	/*********************************************************************************
	* Returns the input in the "lookup nurse by ssn" field.
	*********************************************************************************/
	private String getSSNData()
	{
		try 
		{
			return ssn_lookup_field.getText();
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