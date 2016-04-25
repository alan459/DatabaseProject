import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new Medication into the database. 
*****************************************************************************************************/
public class Insert_Medication_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame main_frame;

	/* Text fields for the user to enter input data */
	private JTextField medication_id_field, medication_name_field, medication_use_field;

	/* String to get input data from fields */
	private String input;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Medication_Menu_Panel.
	*********************************************************************************/
	public Insert_Medication_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(9, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeTextFields();

		add(new JLabel("Enter information of Medication to be added: "));
		add(new JLabel(""));

		// skip a row in the grid layout
		add(new JLabel(""));
		add(new JLabel(""));

		add(new JLabel(" Medication ID:"));
		add(medication_id_field);

		add(new JLabel(" Medication Name:"));
		add(medication_name_field);

		add(new JLabel(" Medication Use:"));
		add(medication_use_field);

		// skip a row in the grid layout
		add(new JLabel(""));
		add(new JLabel(""));

		// skip a row in the grid layout
		add(new JLabel(""));
		add(new JLabel(""));

		add(new Main_Menu_Button(frame));
		add(new Submit_Button());

	}

	/*********************************************************************************
	* Initializes the text fields for Insert_Medication_Menu_Panel.
	*********************************************************************************/
	private void initializeTextFields()
	{
		medication_id_field = new JTextField(6);

		medication_name_field  = new JTextField(6);
		medication_use_field = new JTextField(6);
	}


	/******************************************************************************
	* Submit button for Insert_Medication_Menu_Panel class.
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

					// * somehow get string of doctors name, ssn, code from instance *  and then:
					//Medication.insert(input);
					JOptionPane.showMessageDialog(null,"Submitted");
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
				input = medication_id_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Medication input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}

			// get medication name from field
			try
			{
				input += medication_name_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Medication name input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}

			// get medication use from field
			try
			{
				input += medication_use_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Medication use input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// if this point is reached age and ssn were successfully retrieved
			return true;

		}

	} // end Submit_Button class


} // end Medication menu class