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

	/* Buttons to return the screen to the main menu and submit input data */
	private JButton submit_button, main_menu_button;	

	/* Text fields for the user to enter intput data */
	private JTextField medication_id_field, medication_name_field, medication_use_field;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Medication_Menu_Panel.
	*********************************************************************************/
	public Insert_Medication_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(9, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		addActionListeners();

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

		add(main_menu_button);
		add(submit_button);

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


	/*********************************************************************************
	* Initializes the buttons for Insert_Medication_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		main_menu_button = new JButton("Main Menu");
		submit_button = new JButton("Submit");
	}



	/*********************************************************************************
	* Adds the action listeners for Insert_Medication_Menu_Panel.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Return user to main menu */
		main_menu_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				main_frame.getMainMenu();
			}
		});


	} // end addActionListeners()




} // end Medication menu class