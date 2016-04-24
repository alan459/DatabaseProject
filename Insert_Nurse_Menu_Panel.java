import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new nurse into the database. 
*****************************************************************************************************/
public class Insert_Nurse_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame main_frame;

	/* Buttons to return the screen to the main menu and submit input data */
	private JButton mainMenuButton, submit_button;	

	/* Text fields for the user to enter intput data */
	private JTextField ssn_field, first_name_field, m_initial_field, last_name_field, supervisor_field;
	// fields that might need to be drop down - dob, gender, location


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Nurse_Menu_Panel.
	*********************************************************************************/
	public Insert_Nurse_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(7, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		addActionListeners();

		initializeTextFields();

		add(new JLabel("Enter information of nurse to be added: "));
		add(new JLabel(""));

		add(new JLabel(" SSN:"));
		add(ssn_field);

		add(new JLabel(" First Name:"));
		add(first_name_field);

		add(new JLabel(" Middle Initial:"));
		add(m_initial_field);

		add(new JLabel(" Last Name:"));
		add(last_name_field);

		add(new JLabel(" Supervisor:"));
		add(supervisor_field);

		add(mainMenuButton);
		add(submit_button);


	}

	/*********************************************************************************
	* Initializes the text fields for Insert_Nurse_Menu_Panel.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_field = new JTextField(6);

		first_name_field  = new JTextField(6);
		m_initial_field = new JTextField(1);
		last_name_field = new JTextField(6);

		supervisor_field = new JTextField(6);
	}


	/*********************************************************************************
	* Initializes the buttons for Insert_Nurse_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		mainMenuButton = new JButton("Main Menu");
		submit_button = new JButton("Submit");
	}



	/*********************************************************************************
	* Adds the action listeners for Insert_Nurse_Menu_Panel.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Return user to main menu */
		mainMenuButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				main_frame.getMainMenu();
			}
		});

		/* Add functionality - Submit input data */
		submit_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

	} // end addActionListeners()





} // end nurse menu class