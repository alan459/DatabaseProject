import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* Displays to the user options for looking up records for a Doctor by SSN. 
*
* Reached when the user selects the 'Doctor' option next to the 'Access' label and then 'Search 
* Records for a Doctor'.
*****************************************************************************************************/
public class Doctor_Record_Lookup_Panel extends JPanel 
{
	private JPanel record_output_panel;


	/*********************************************************************************
	* Main constructor for setting up the Doctor lookup menu. 
	*********************************************************************************/
	public Doctor_Record_Lookup_Panel() 
	{
		//setLayout(new GridLayout(3, 1));
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                JPanel top = new JPanel();
		top.add(new Centered_Text_Panel("Record Lookup:"));
                add(top);

		add(new Lookup_Panel());

		add(record_output_panel = new Doctor_Record_Output());
	}

	/*********************************************************************************
	* Display new output information for a Doctor, if any output is currently being
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
	* access and the ssn of the Doctor for which to access it.
	*********************************************************************************/
	protected class Lookup_Panel extends JPanel
	{
		private JTextField ssn_field;

		private String selected_record_type, ssn;

		private String[] record_types = {"PATIENT", "TREATMENT", "PROCEDURE", "PRESCRIPTION"};

		private JComboBox record_types_combo_box;

		/***********************************************************************
		* Main constructor for Lookup_Panel.
		***********************************************************************/
		public Lookup_Panel()
		{
			setLayout(new GridLayout(2, 4));

			add(new Centered_Text_Panel("Lookup"));
			add(record_types_combo_box = new JComboBox(record_types));
			add(new Centered_Text_Panel(" for Doctor with SSN "));
			add(ssn_field = new JTextField(8));

			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Centered_Text_Panel(""));
			add(new Submit_Button());
		}


		/***********************************************************************
		* Submit button to retrieve data from ssn field and type of record to 
		* lookup and display record info for the Doctor with that ssn.
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

						// pass ssn input into Doctor instance to lookup tuple
						 Doctor a = new Doctor(ssn);
                                                 
                                                 String result = a.search(selected_record_type);
                                                 
                                                 String[] values = result.split("\n");
                                                 
						// create new instance of output panel to display result
						 displayNewRecordOutput(new Doctor_Record_Output(values));
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
	* Panel for displaying Doctor info output data based on input data from the user.
	*********************************************************************************/
	protected class Doctor_Record_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Doctor_Record_Output.
		***********************************************************************/
		public Doctor_Record_Output()
		{
			add(new Centered_Text_Panel("Results:"));
		}
                
                
                 /***********************************************************************
		* Primary constructor for Doctor_Info_Output.
		***********************************************************************/
		public Doctor_Record_Output(String[] result)
		{
			setLayout(new GridLayout(result.length + 1, 1));

			add(new Centered_Text_Panel("Results:"));
                        for(int i = 0; i < result.length; i++)
                        {
                            add(new JLabel(result[i]));
                        }
			
		}


		/***********************************************************************
		* Primary constructor for Doctor_Record_Output.
		***********************************************************************/
		public Doctor_Record_Output(String result)
		{
			setLayout(new GridLayout(2, 1));

			add(new Centered_Text_Panel("Results:"));
			add(new JTextField(result));

			/*switch(relation)
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
			}*/
			

		}

	} // end Doctor_Record_Output class
	



} // end Doctor lookup class