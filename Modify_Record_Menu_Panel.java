import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new patient into the database. 
*****************************************************************************************************/
public class Modify_Record_Menu_Panel extends JPanel 
{

	/* Text fields for the user to enter intput data */
	private JTextField record_id_field;
	// fields that might need to be drop down - dob, gender, location

	/* String to get input data from fields */
	private String input;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Patient_Menu_Panel.
	*********************************************************************************/
	public Modify_Record_Menu_Panel() 
	{
		setLayout(new GridLayout(2, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		add(new Centered_Text_Panel("Enter ID of the record to be inactivated: "));
		add(record_id_field = new JTextField(5));

                add(new JLabel(""));
		add(new Submit_Button());


	}


	/******************************************************************************
	* Submit button for Insert_Patient_Menu_Panel class.
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

					// insert the patient into the database
					Patient.changeRecordStatus(input);

					JOptionPane.showMessageDialog(null, "Submitted");

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
				input = record_id_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "ID input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// if this point is reached age and ssn were successfully retrieved
			return true;

		}

	} // end Submit_Button class






} // end patient menu class