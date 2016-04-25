import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new prescription into the database. 
*****************************************************************************************************/
public class Insert_Prescription_Menu_Panel extends JPanel 
{

	/* Text fields for the user to enter intput data */
	private JTextField prescription_id_field, patient_ssn_field, doctor_ssn_field, prescription_date_field, medicaton_field, dosage_field;

	/* String to get input data from fields */
	private String input;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Prescription_Menu_Panel.
	*********************************************************************************/
	public Insert_Prescription_Menu_Panel(Hospital_Frame frame) 
	{
		setLayout(new GridLayout(8, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		addActionListeners();

		initializeTextFields();

		add(new JLabel("Enter information of prescription to be added: "));
		add(new JLabel(""));

		add(new JLabel(" Prescription ID:"));
		add(prescription_id_field);

		add(new JLabel(" Patient SSN:"));
		add(patient_ssn_field);

		add(new JLabel(" Doctor SSN:"));
		add(doctor_ssn_field);

		add(new JLabel(" Prescription Date:"));
		add(prescription_date_field);

		add(new JLabel(" Medication:"));
		add(medicaton_field);

		add(new JLabel(" Dosage:"));
		add(dosage_field);

		add(new Main_Menu_Button(frame));
		add(new Submit_Button());


	}

	/*********************************************************************************
	* Initializes the text fields for Insert_Prescription_Menu_Panel.
	*********************************************************************************/
	private void initializeTextFields()
	{
		prescription_id_field = new JTextField(6);

		patient_ssn_field  = new JTextField(6);
		doctor_ssn_field = new JTextField(6);

		prescription_date_field = new JTextField(6);
		medicaton_field = new JTextField(2);

		dosage_field = new JTextField(6);
	}

	/******************************************************************************
	* Submit button for Insert_Precription_Menu_Panel class.
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
					loadInput();

					//Prescription.insert(input);s

					// display a new popup saying insertion was successful?
					JOptionPane.showMessageDialog(null,"Submitted");
				}
			});
		}

		/******************************************************************
		* Load input from ssn field into corresponding string variable and
		* return that string.
		******************************************************************/
		private String loadInput()
		{
			// get input from textfields and load them into a single string

			input = prescription_id_field.getText() + "\t" + patient_ssn_field.getText() + "\t" + doctor_ssn_field.getText() + "\t" + 
			prescription_date_field().getText() + "\t" + medicaton_field.getText() + "\t" + dosage_field.getText();
			
			return input;
		}

	} // end Submit_Button class







} // end prescription menu class