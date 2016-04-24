import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A menu displayed to the user to insert a new doctor into the database. 
*****************************************************************************************************/
public class Insert_Doctor_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame main_frame;

	/* Button to return the screen to the main menu */
	private JButton main_menu_button;	

	/* Text fields for the user to enter intput data */
	private JTextField ssn_field, first_name_field, m_initial_field, last_name_field, code_field;



	/* Left side interface displayed to the user to lookup a doctor */
	private JPanel doctorLookup;

	/* Right side interface displayed to the user, displaying either button options or
	* an interface based on button pressed */
	private JPanel currentInterface;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Doctor_Menu_Panel.
	*********************************************************************************/
	public Insert_Doctor_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(7, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		addActionListeners();

		initializeTextFields();

		add(new JLabel("Enter information of doctor to be added: "));
		add(new JLabel(""));

		add(new JLabel(" SSN:"));
		add(ssn_field);

		add(new JLabel(" First Name:"));
		add(first_name_field);

		add(new JLabel(" Middle Initial:"));
		add(m_initial_field);

		add(new JLabel(" Last Name:"));
		add(last_name_field);

		add(new JLabel(" Doctor Code:"));
		add(code_field);


		add(main_menu_button);

		add(new JButton("submit"));
	}

	/*********************************************************************************
	* Initializes the text fields for Insert_Doctor_Menu_Panel.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_field = new JTextField(6);

		first_name_field  = new JTextField(6);
		m_initial_field = new JTextField(1);
		last_name_field = new JTextField(6);

		code_field = new JTextField(6);
	}


	/*********************************************************************************
	* Initializes the buttons for Insert_Doctor_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		main_menu_button = new JButton("Main Menu");
	}



	/*********************************************************************************
	* Adds the action listeners for Insert_Doctor_Menu_Panel.
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



	//private class 



} // end insert doctor menu class