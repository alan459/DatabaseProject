import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new Record into the database. 
*****************************************************************************************************/
public class Insert_Record_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame main_frame;

	/* Text fields for the user to enter intput data */
	private JTextField patient_ssn_field, admittance_date_field, primary_doctor_field, 
					   patient_diagnosis_field, status_field;

	/* String to get input data from fields */
	private String input;

	private JComboBox gender_selection;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Record_Menu_Panel.
	*********************************************************************************/
	public Insert_Record_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(7, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeTextFields();
		initializeComboBoxes();

		add(new Centered_Text_Panel("Enter information of Record to be added: "));
		add(new JLabel(""));

		add(new Centered_Text_Panel(" Patient SSN:"));
		add(patient_ssn_field);

		add(new Centered_Text_Panel(" Admittance Date:"));
		add(admittance_date_field);

		add(new Centered_Text_Panel(" Primary Doctor:"));
		add(primary_doctor_field);

		add(new Centered_Text_Panel(" Patient Diagnosis:"));
		add(patient_diagnosis_field);

		add(new Centered_Text_Panel(" Status:"));
		add(status_field);

		add(new Main_Menu_Button(main_frame));
		add(new Submit_Button());


	}

	/*********************************************************************************
	* Initializes the text fields for Insert_Record_Menu_Panel.
	*********************************************************************************/
	private void initializeTextFields()
	{
		patient_ssn_field = new JTextField(6);

		primary_doctor_field = new JTextField(1);
		admittance_date_field = new JTextField(6);

		patient_diagnosis_field = new JTextField(6);
		status_field = new JTextField(2);
	}

	/*********************************************************************************
	* Initializes the combo boxes for Insert_Record_Menu_Panel.
	*********************************************************************************/
	private void initializeComboBoxes()
	{
		gender_selection = new JComboBox(new String[]{"M", "F"});
	}


	/******************************************************************************
	* Submit button for Insert_Record_Menu_Panel class.
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

					// insert the Record into the database
					String success = Patient.insertRecord(input);

					JOptionPane.showMessageDialog(null, success);

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
				input = patient_ssn_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "SSN input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get admittance_date_field from field
			try
			{
				input += admittance_date_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "admittance_date_field input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get Primary Doctor from field
			try
			{
				input += primary_doctor_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "Primary Doctor input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get patient_diagnosis_field from field
			try
			{
				input += patient_diagnosis_field.getText() + "\t";
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "patient_diagnosis_field input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}


			// get status_field from field
			try
			{
				input += status_field.getText();
			} 
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(new JPanel(), "status_field input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
				return false;	
			}



			// if this point is reached age and ssn were successfully retrieved
			return true;

		}

	} // end Submit_Button class






} // end Record menu class