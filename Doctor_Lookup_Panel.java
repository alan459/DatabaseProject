import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A display for the user to lookup Doctors in the database.
*****************************************************************************************************/
public class Doctor_Lookup_Panel extends JPanel 
{
	/* Panel for displaying output data - deleted and re-added afer every click of 'submit' */
	private JPanel doctor_output_panel;

	/* Fields for getting input from the user */
	private JTextField ssn_field;	
	private String ssn;



	/*********************************************************************************
	* Main constructor for setting up the Doctor lookup menu. 
	*********************************************************************************/
	public Doctor_Lookup_Panel() 
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeTextFields();

		// add the components to the panel
		add(new JLabel("Doctor Lookup"));

		add(new JLabel("by: SSN"));
		add(ssn_field);
		add(new Submit_Button());

		add(new JLabel("Doctor Info:"));

		add(doctor_output_panel = new Doctor_Info_Output());
	}


	/*********************************************************************************
	* Display new output information for a doctor, if any output is currently being
	* displayed, remove it first.
	*********************************************************************************/
	protected void displayNewDoctorOutput(JPanel output)
	{	
		if(doctor_output_panel != null)
			remove(doctor_output_panel);

		add(doctor_output_panel = output);

		revalidate();
		repaint();
	}


	/******************************************************************************
	* Submit button for Doctor_Lookup_Panel class.
	******************************************************************************/
	private class Submit_Button extends JButton
	{
		/******************************************************************
		* Main constructor for Submit_Button
		******************************************************************/
		public Submit_Button()
		{
			super("Submit");

			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					// get input from ssn field into ssn string variable
					loadText();

					// pass input into Doctor instance to modify tuple
					//Doctor doc = new Doctor(ssn);

					//String result = doc.search("DOCTOR");

					// extract fields from string and pass to doctor:
					//displayNewDoctorOutput(new Doctor_Info_Output(result)); 
				}
			});
		}

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

	} // end Submit_Button class



	/*********************************************************************************
	* Panel for displaying Doctor info output data based on input data from the user.
	*********************************************************************************/
	protected class Doctor_Info_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Doctor_Info_Output, initializing empty results.
		***********************************************************************/
		public Doctor_Info_Output()
		{
			setLayout(new GridLayout(5, 2));

			add(new Centered_Text_Panel("Doctor Info:"));
			add(new Centered_Text_Panel(""));

			add(new Centered_Text_Panel("Name:"));
			add(new Centered_Text_Panel("<First><M><Last>"));

			add(new Centered_Text_Panel("SSN:"));
			add(new Centered_Text_Panel("ddd-dd-dddd"));

			add(new Centered_Text_Panel("Dcode:"));
			add(new Centered_Text_Panel("ddddd"));
		}


		/***********************************************************************
		* Primary constructor for Doctor_Info_Output.
		***********************************************************************/
		public Doctor_Info_Output(String result)
		{
			setLayout(new GridLayout(2, 1));

			add(new Centered_Text_Panel("Doctor Info:"));
			//add(new Centered_Text_Panel(""));
			//add(new Centered_Text_Panel(result);
			add(new JTextField(result));
		}


	} // end Doctor_Info_Output class




	/*********************************************************************************
	* Initializes the textfields for the Doctor lookup menu.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_field = new JTextField(10);
	}


} // end Doctor lookup class