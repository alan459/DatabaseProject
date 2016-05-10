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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//add(new Centered_Text_Panel("Lookup Patient:"));

		add(new By_SSN_Panel());

		add(new By_Name_Panel());		

		add(patient_output_panel = new Patient_Info_Output());
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

		revalidate();
		repaint();
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
			setLayout(new GridLayout(5, 3));

                        add(new Centered_Text_Panel(""));
                        add(new Centered_Text_Panel("Lookup Patient:"));
			add(new Centered_Text_Panel(""));

			add(new Centered_Text_Panel("by:"));
			add(new Centered_Text_Panel("SSN"));
			add(ssn_field = new JTextField(9));

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

                                                // pass input into Doctor instance to modify tuple
						Patient pat = new Patient(ssn);

						String result = pat.search("PATIENT");
                                                
                                                String[] values = result.split("\n");
                                                
                                            
						// extract fields from string and pass to doctor:
						displayNewPatientOutput(new Patient_Info_Output(values)); 

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
		private JTextField first_name_field, m_initial_field, last_name_field, dob_field;

		private String first_name, m_initial, last_name, dob;

		private String input;


		/***********************************************************************
		* Main constructor for By_Name_Panel.
		***********************************************************************/
		public By_Name_Panel()
		{
			setLayout(new GridLayout(5, 3));

			add(new Centered_Text_Panel("by:"));
			add(new Centered_Text_Panel("First Name"));
			add(first_name_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel("Middle Initial"));
			add(m_initial_field = new JTextField(1));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel("Last Name"));
			add(last_name_field = new JTextField(8));
                        
                        add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel("DOB"));
			add(dob_field = new JTextField(8));

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
						// get input from name fields into a string variable
						loadText();

						// pass input into Doctor instance to modify tuple
						Patient pat = new Patient(input);

						String result = pat.search("PATIENT");
                                                
                                                String[] values = result.split("\n");
                                                
                                            
						// extract fields from string and pass to doctor:
						displayNewPatientOutput(new Patient_Info_Output(values)); 
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
		private String loadText()
		{
			// get name from fields
			input = first_name_field.getText() + "\t" + m_initial_field.getText() + "\t" + last_name_field.getText()
                                + "\t" + dob_field.getText();

			// if this point is reached age and ssn were successfully retrieved
			return input;

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
			setLayout(new GridLayout(2,1));

			add(new Centered_Text_Panel("Patient Info:"));
	

		}


		/***********************************************************************
		* Primary constructor for Patient_Info_Output.
		***********************************************************************/
		public Patient_Info_Output(String result)
		{
			setLayout(new GridLayout(2, 1));

			add(new Centered_Text_Panel("Patient Info:"));

			//add(new Centered_Text_Panel(result));
			add(new JTextField(result));

		}
                
                /***********************************************************************
		* Primary constructor for Patient_Info_Output.
		***********************************************************************/
		public Patient_Info_Output(String[] result)
		{
			setLayout(new GridLayout(result.length + 1, 1));

			add(new Centered_Text_Panel("Patient Info:"));
                        for(int i = 0; i < result.length; i++)
                        {
                            add(new JLabel(result[i]));
                        }
			
		}

	} // end Patient_Info_Output class
	



} // end patient lookup class