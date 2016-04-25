import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* Displays to the user options for looking up a patient by SSN and name. 
*
* Reached when the user selects the 'Patient' option next to the 'Access' label and then 'Search 
* Patients'.
*****************************************************************************************************/
public class Patient_Lookup_Panel extends JPanel 
{
	private JPanel patient_output_panel;



	/*********************************************************************************
	* Main constructor for setting up the patient lookup menu. 
	*********************************************************************************/
	public Patient_Lookup_Panel() 
	{
		setLayout(new GridLayout(4, 1));

		add(new Centered_Text_Panel("Lookup Patient:"));

		add(new By_SSN_Panel());

		add(new By_Name_Panel());		

		add(new Patient_Info_Output());
	}

	/*********************************************************************************
	* Display new output information for a patient, if any output is currently being
	* displayed, remove it first.
	*********************************************************************************/
	protected void displayNewPatientOutput(JPanel output)
	{	
		if(patient_output_panel != null)
			remove(patient_output_panel);

		add(patient_output_panel = output);

	}




	/*********************************************************************************
	* Panel for displaying option for getting patient output data from ssn input.
	*********************************************************************************/
	protected class By_SSN_Panel extends JPanel
	{
		private JTextField ssn_field;

		private String ssn;


		/***********************************************************************
		* Main constructor for By_SSN_Panel.
		***********************************************************************/
		public By_SSN_Panel()
		{
			setLayout(new GridLayout(4, 3));

			add(new Centered_Text_Panel("by:"));
			add(new Centered_Text_Panel("SSN"));
			add(ssn_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));

			add(new Centered_Text_Panel(""));
			add(new Submit_Button());

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
		}


		/***********************************************************************
		* Submit button to retrieve data from ssn field and display patient info
		* for the patient with that ssn.
		***********************************************************************/
		private class Submit_Button extends JButton
		{

			/***********************************************************
			* Main constructor for Submit_Button in By_SSN_Panel.
			***********************************************************/
			public Submit_Button()
			{
				super("Submit");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						loadText();

						// pass ssn input into patient instance to lookup tuple

						// create new instance of output panel to display result
					}
				});
			}

		} // end Submit_Button class



		/******************************************************************
		* Load input from ssn field into corresponding string variable.
		*
		* If load is successful, true is returned, otherwise false
		* is returned.
		******************************************************************/
		private boolean loadText()
		{
			// get ssn from field
			try
			{
				ssn = ssn_field.getText();
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "SSN input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}

			// if this point is reached age and ssn were successfully retrieved
			return true;

		}


	} // end By_SSN_Panel class






	/*********************************************************************************
	* Panel for displaying option for getting patient output data from name input.
	*********************************************************************************/
	protected class By_Name_Panel extends JPanel
	{
		private JTextField first_name_field, m_initial_field, last_name_field;

		private String first_name, m_initial, last_name;


		/***********************************************************************
		* Main constructor for By_Name_Panel.
		***********************************************************************/
		public By_Name_Panel()
		{
			setLayout(new GridLayout(4, 3));

			add(new Centered_Text_Panel("by:"));
			add(new Centered_Text_Panel("First Name"));
			add(first_name_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel("Middle Initial"));
			add(last_name_field = new JTextField(1));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel("Last Name"));
			add(last_name_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Submit_Button());
		}


		/***********************************************************************
		* Submit button to retrieve data from the name fields and display
		* patient info for the patient with matching name fields.
		***********************************************************************/
		private class Submit_Button extends JButton
		{

			/***********************************************************
			* Main constructor for Submit_Button in By_Name_Panel.
			***********************************************************/
			public Submit_Button()
			{
				super("Submit");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						loadText();

						// pass ssn input into patient instance to lookup tuple
						
						// create new instance of output panel to display result
					}
				});
			}

		} // end Submit_Button class



		/******************************************************************
		* Load input from ssn field into corresponding string variable.
		*
		* If load is successful, true is returned, otherwise false
		* is returned.
		******************************************************************/
		private boolean loadText()
		{
			// get ssn from field
			try
			{
				first_name = first_name_field.getText();
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "SSN input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}

			// if this point is reached age and ssn were successfully retrieved
			return true;

		}


	} // end By_Name_Panel class




	/*********************************************************************************
	* Panel for displaying patient info output data based on input data from the user.
	*********************************************************************************/
	protected class Patient_Info_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Patient_Info_Output.
		***********************************************************************/
		public Patient_Info_Output()
		{
			setLayout(new GridLayout(5, 2));

			add(new Centered_Text_Panel("Patient Info:"));
			add(new Centered_Text_Panel(""));

			add(new Centered_Text_Panel("Name:"));
			add(new Centered_Text_Panel("<First><M><Last>"));

			add(new Centered_Text_Panel("DOB:"));
			add(new Centered_Text_Panel("mm/dd/yyyy"));

			add(new Centered_Text_Panel("SSN:"));
			add(new Centered_Text_Panel("ddd-dd-dddd"));

			add(new Centered_Text_Panel("Room:"));

		}


		/***********************************************************************
		* Primary constructor for Patient_Info_Output.
		***********************************************************************/
		public Patient_Info_Output(String name, String dob, String ssn, String room)
		{
			add(new Centered_Text_Panel("Patient Info:"));

			add(new Centered_Text_Panel("Patient Info:"));
			add(new Centered_Text_Panel(""));

			add(new Centered_Text_Panel("Name:"));
			add(new Centered_Text_Panel(name));

			add(new Centered_Text_Panel("DOB:"));
			add(new Centered_Text_Panel(dob));

			add(new Centered_Text_Panel("SSN:"));
			add(new Centered_Text_Panel(ssn));

			add(new Centered_Text_Panel("Room:"));
			add(new Centered_Text_Panel(room));

		}

	} // end Patient_Info_Output class
	



} // end patient lookup class