import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new patient into the database. 
*****************************************************************************************************/
public class Insert_Patient_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame main_frame;

	/* Text fields for the user to enter intput data */
	private JTextField ssn_field, first_name_field, last_name_field, m_initial_field, dob_field, age_field, location_field;
	// fields that might need to be drop down - dob, gender, location

	/* String to get input data from fields */
	private String input;

	private JComboBox gender_selection;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Patient_Menu_Panel.
	*********************************************************************************/
	public Insert_Patient_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(10, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeTextFields();
		initializeComboBoxes();

		add(new Centered_Text_Panel("Enter information of patient to be added: "));
		add(new JLabel(""));

		add(new Centered_Text_Panel(" SSN:"));
		add(ssn_field);

		add(new Centered_Text_Panel(" First Name:"));
		add(first_name_field);

		add(new Centered_Text_Panel(" Middle Initial:"));
		add(m_initial_field);

		add(new Centered_Text_Panel(" Last Name:"));
		add(last_name_field);

		add(new Centered_Text_Panel(" Date of Birth:"));
		add(dob_field);

		add(new Centered_Text_Panel(" Age:"));
		add(age_field);

		add(new Centered_Text_Panel(" Gender:"));
		add(gender_selection);

		add(new Centered_Text_Panel(" Location:"));
		add(location_field);

		add(new Main_Menu_Button(main_frame));
		add(new Submit_Button());


	}

	/*********************************************************************************
	* Initializes the text fields for Insert_Patient_Menu_Panel.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_field = new JTextField(6);

		first_name_field  = new JTextField(6);
		m_initial_field = new JTextField(1);
		last_name_field = new JTextField(6);

		dob_field = new JTextField(6);
		age_field = new JTextField(2);

		location_field = new JTextField(6);
	}

	/*********************************************************************************
	* Initializes the combo boxes for Insert_Patient_Menu_Panel.
	*********************************************************************************/
	private void initializeComboBoxes()
	{
		gender_selection = new JComboBox(new String[]{"M", "F"});
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
					Patient.insert(input);
                                       

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
				input = ssn_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "SSN input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get first name from field
			try
			{
				input += first_name_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "First name input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get Middle initial  from field
			try
			{
				input += m_initial_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Middle initial input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get last name from field
			try
			{
				input += last_name_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Last name input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get dob from field
			try
			{
				input += dob_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "DOB input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get age from field
			try
			{
				input += age_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Age input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get gender selection from field
			try
			{
				input += gender_selection.getSelectedItem().toString() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Gender input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get gender selection from field
			try
			{
				input += location_field.getText();
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Location input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}

			// if this point is reached age and ssn were successfully retrieved
			return true;

		}

	} // end Submit_Button class






} // end patient menu class