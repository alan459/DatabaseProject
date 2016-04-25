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

	/* Text fields for the user to enter intput data */
	private JTextField ssn_field, first_name_field, m_initial_field, last_name_field, code_field;

	/* String to get input data from fields */
	private String input;


	/*********************************************************************************
	* Main constructor used for setting up the Insert_Doctor_Menu_Panel.
	*********************************************************************************/
	public Insert_Doctor_Menu_Panel(Hospital_Frame frame) 
	{
		this.main_frame = frame;

		setLayout(new GridLayout(7, 2));

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

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


		add(new Main_Menu_Button(frame));
		add(new Submit_Button());
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


	/******************************************************************************
	* Submit button for Insert_Doctor_Menu_Panel class.
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

					//Doctor.insert(input);s

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

			input = ssn_field.getText() + "\t" + first_name_field.getText() + "\t" + m_initial_field.getText() + "\t" + 
			last_name_field.getText() + "\t" + code_field.getText();
			
			return input;
		}

	} // end Submit_Button class


} // end insert doctor menu class