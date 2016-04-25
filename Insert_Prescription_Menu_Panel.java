import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new prescription into the database. 
*****************************************************************************************************/
public class Insert_Prescription_Menu_Panel extends JPanel 
{
	/* Button to return the screen to the main menu */
	private JButton submit_button;	

	/* Text fields for the user to enter intput data */
	private JTextField prescription_id_field, patient_ssn_field, doctor_ssn_field, prescription_date_field, medicaton_field, dosage_field;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Prescription_Menu_Panel.
	*********************************************************************************/
	public Insert_Prescription_Menu_Panel() 
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

		add(submit_button);


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


	/*********************************************************************************
	* Initializes the buttons for Insert_Prescription_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		submit_button = new JButton("submit");
	}



	/*********************************************************************************
	* Adds the action listeners for Insert_Prescription_Menu_Panel.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Submit data in text fields */
		submit_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

	} // end addActionListeners()





} // end prescription menu class