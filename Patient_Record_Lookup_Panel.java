import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* Displays to the user options for looking up records for a patient by SSN. 
*
* Reached when the user selects the 'Patient' option next to the 'Access' label and then 'Search 
* Records for a Patient'.
*****************************************************************************************************/
public class Patient_Record_Lookup_Panel extends JPanel 
{
	private JPanel record_output_panel;


	/*********************************************************************************
	* Main constructor for setting up the patient lookup menu. 
	*********************************************************************************/
	public Patient_Record_Lookup_Panel() 
	{
		setLayout(new GridLayout(3, 1));

		add(new Centered_Text_Panel("Record Lookup:"));

		add(new Lookup_Panel());

		add(record_output_panel = new Patient_Record_Output());
	}

	/*********************************************************************************
	* Display new output information for a patient, if any output is currently being
	* displayed, remove it first.
	*********************************************************************************/
	protected void displayNewRecordOutput(JPanel output)
	{	
		if(record_output_panel != null)
			remove(record_output_panel);

		add(record_output_panel = output);

		revalidate();
		repaint();
	}




	/*********************************************************************************
	* Panel for displaying to the user options for selecting the type of record to 
	* access and the ssn of the patient for which to access it.
	*********************************************************************************/
	protected class Lookup_Panel extends JPanel
	{
		private JTextField ssn_field;

		private String selected_record_type, ssn;

		private String[] record_types = {"Treatments", "Procedures", "Prescriptions"};

		private JComboBox record_types_combo_box;

		/***********************************************************************
		* Main constructor for Lookup_Panel.
		***********************************************************************/
		public Lookup_Panel()
		{
			setLayout(new GridLayout(2, 4));

			add(new Centered_Text_Panel("Lookup"));
			add(record_types_combo_box = new JComboBox(record_types));
			add(new Centered_Text_Panel(" for patient with SSN "));
			add(ssn_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Submit_Button());
		}


		/***********************************************************************
		* Submit button to retrieve data from ssn field and type of record to 
		* lookup and display record info for the patient with that ssn.
		***********************************************************************/
		private class Submit_Button extends JButton
		{

			/***********************************************************
			* Main constructor for Submit_Button in Lookup_Panel.
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
						displayNewRecordOutput(new Patient_Record_Output(selected_record_type, ""));
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

			// get record type from combo box
			try
			{
				selected_record_type = record_types_combo_box.getSelectedItem().toString();
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Selected Record Type could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}

			// if this point is reached age and ssn were successfully retrieved
			return true;

		}


	} // end Lookup_Panel class




	/*********************************************************************************
	* Panel for displaying patient info output data based on input data from the user.
	*********************************************************************************/
	protected class Patient_Record_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Patient_Record_Output.
		***********************************************************************/
		public Patient_Record_Output()
		{
			add(new Centered_Text_Panel("Results:"));
		}


		/***********************************************************************
		* Primary constructor for Patient_Record_Output.
		***********************************************************************/
		public Patient_Record_Output(String relation, String results)
		{
			add(new Centered_Text_Panel("Results:"));

			switch(relation)
			{
				case "Treatments":
					add(new Tuple_Display_Panel(Relation_Attributes.treatment, results));
					break;

				case "Procedures":
					add(new Tuple_Display_Panel(Relation_Attributes.procedure, results));
					break;

				case "Prescriptions":
					add(new Tuple_Display_Panel(Relation_Attributes.prescription, results));
					break;

				default:
					break;				
			}
			

		}

	} // end Patient_Record_Output class
	



} // end patient lookup class