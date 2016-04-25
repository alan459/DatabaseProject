import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* Displays to the user options for looking up records for a Nurse by SSN. 
*
* Reached when the user selects the 'Nurse' option next to the 'Access' label and then 'Search 
* Records for a Nurse'.
*****************************************************************************************************/
public class Nurse_Record_Lookup_Panel extends JPanel 
{
	private JPanel record_output_panel;


	/*********************************************************************************
	* Main constructor for setting up the Nurse lookup menu. 
	*********************************************************************************/
	public Nurse_Record_Lookup_Panel() 
	{
		setLayout(new GridLayout(3, 1));

		add(new Centered_Text_Panel("Record Lookup:"));

		add(new Lookup_Panel());

		add(record_output_panel = new Nurse_Record_Output());
	}

	/*********************************************************************************
	* Display new output information for a Nurse, if any output is currently being
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
	* access and the ssn of the Nurse for which to access it.
	*********************************************************************************/
	protected class Lookup_Panel extends JPanel
	{
		private JTextField ssn_field;
		private String input;

		// variables involved with selecting record type
		private String selected_record_type;
		private String[] record_types = {"Supervisor"};
		private JComboBox record_types_combo_box;


		/***********************************************************************
		* Main constructor for Lookup_Panel.
		***********************************************************************/
		public Lookup_Panel()
		{
			setLayout(new GridLayout(2, 4));

			add(new Centered_Text_Panel("Lookup"));
			add(record_types_combo_box = new JComboBox(record_types));
			add(new Centered_Text_Panel(" for Nurse with SSN "));
			add(ssn_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Submit_Button());
		}


		/***********************************************************************
		* Submit button to retrieve data from ssn field and type of record to 
		* lookup and display record info for the Nurse with that ssn.
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
						loadInput();

						// pass ssn input and/or type of record?
						// Nurse a = new Nurse(input);

						//String result = a.search("NURSE");

						// create new instance of output panel to display result
						// displayNewRecordOutput(new Nurse_Record_Output(result));
					}
				});
			}

		} // end Submit_Button class



		/******************************************************************
		* Load input from ssn field into corresponding string variable and
		* return that string.
		******************************************************************/
		private String loadInput()
		{
			// get input from textfields and load them into a single string

			input = ssn_field.getText();
			
			return input;
		}


	} // end Lookup_Panel class




	/*********************************************************************************
	* Panel for displaying Nurse info output data based on input data from the user.
	*********************************************************************************/
	protected class Nurse_Record_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Nurse_Record_Output.
		***********************************************************************/
		public Nurse_Record_Output()
		{
			add(new Centered_Text_Panel("Results:"));
		}


		/***********************************************************************
		* Primary constructor for Nurse_Record_Output.
		***********************************************************************/
		public Nurse_Record_Output(String result)
		{
			setLayout(new GridLayout(2, 1));

			add(new Centered_Text_Panel("Results:"));
			add(new JTextField(result));
			

		}

	} // end Nurse_Record_Output class
	



} // end Nurse lookup class