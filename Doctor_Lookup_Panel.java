//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* To be used as the leftside INNER panel as part of a larger panel containing all the options for 
* the user. 
*
* A display for the user to lookup Doctors in the database.
*****************************************************************************************************/
public class Doctor_Lookup_Panel extends JPanel 
{
	//private JPanel mainPanel;

	/* Input submission buttons */
	private JButton ssn_lookup_button, info_lookup_button; //, recordLookupButton;		

	/* Display to the user what type of information is being displayed in the adjacent position */
	private JLabel enter_ssn_label, enter_first_name_label, enter_last_name_label, enter_dob_label, doctor_lookup_label;	

	/* Labels for displaying output data */
	private JLabel doctor_info_label, doctor_name_output_label, doctor_ssn_output_label, doctor_dob_output_label;

	/* Fields for getting input from the user */
	private JTextField ssn_lookup_field, first_name_field, last_name_field, dob_field;	



	/*********************************************************************************
	* Main constructor for setting up the Doctor lookup menu. 
	*********************************************************************************/
	public Doctor_Lookup_Panel() 
	{
		//this.mainFrame = main;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeLabels();
		initializeButtons();
		initializeTextFields();
		addActionListeners();

		// add the components to the panel
		add(doctor_lookup_label);
		//add(recordLookupLabel);
		add(enter_ssn_label);
		add(ssn_lookup_field);
		add(ssn_lookup_button);

		add(enter_first_name_label);
		add(first_name_field);

		add(enter_last_name_label);
		add(last_name_field);

		add(enter_dob_label);
		add(dob_field);

		add(info_lookup_button);

		// add labels that will display output info for Doctors 
		// labels will be appended with the Doctor info after 'submit'
		// clicked (ex: ssn - setText(getSSNText() + ssn) )
		add(doctor_info_label);
		add(doctor_name_output_label);
		add(doctor_ssn_output_label);
		add(doctor_dob_output_label);


		//add(recordLookupButton);
		//add(mainMenuButton);
	}


	/*********************************************************************************
	* Initializes the labels for the Doctor lookup menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		doctor_lookup_label = new JLabel("Doctor Lookup");
		//recordLookupLabel = new JLabel("Record Lookup");

		enter_ssn_label = new JLabel("\nby ssn:");

		enter_first_name_label = new JLabel("\n\nby first:");
		enter_last_name_label = new JLabel("by last:");

		enter_dob_label = new JLabel("dob:");


		doctor_info_label = new JLabel("Doctor Info:");

		doctor_name_output_label = new JLabel("Name:");
		doctor_ssn_output_label = new JLabel("SSN:");
		doctor_dob_output_label = new JLabel("DOB:");
	}


	/*********************************************************************************
	* Initializes the buttons for the Doctor lookup menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		ssn_lookup_button = new JButton("Submit");
		info_lookup_button = new JButton("Submit");
		//recordLookupButton = new JButton("Submit");
		//mainMenuButton = new JButton("Main Menu");
	}


	/*********************************************************************************
	* Initializes the textfields for the Doctor lookup menu.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_lookup_field = new JTextField(10);
		first_name_field = new JTextField(10);
		last_name_field = new JTextField(10);
		dob_field = new JTextField(10);
	}


	/*********************************************************************************
	* Adds the action listeners for the Doctor lookup menu.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Lookup a Doctor based on ssn */
		ssn_lookup_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ssn = getSSNData();
				if (ssn != null)
				{
					// pass the ssn data to a method that lookups Doctor data and returns it as a string
					// String DoctorData = getDoctorData(ssn);
					//displayDoctorData(DoctorData); 
				}
				else
				{
					// display error message somewhere
				}
			}
		});

		/* Add functionality - Submit info button */
		info_lookup_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					
			}
		});
	}


	/*********************************************************************************
	* Returns the input in the "lookup Doctor by ssn" field.
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
	* Fills the Doctor display fields with a Doctor's data.
	*********************************************************************************/
	private void displayDoctorData(String data)
	{

	}

} // end Doctor lookup class