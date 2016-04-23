//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*********************************************************************************
* 1 of the 2 INNER JPanels that result from a button being clicked in the button
* interface to display the Doctor record lookup interface on the right side of 
* the window after the "Doctor Record Lookup" button is pressed.
*********************************************************************************/
public class Modify_Doctor_Info_Panel extends JPanel
{
	/*  */
	private Doctor_Menu_Panel outer_menu;

	/* Input submission buttons */
	private JButton submit_info_button;

	/* Labels for describing input/output fields */
	private JLabel lookup_label, ssn_label, results_label;

	/* Input from the user */
	private JTextField ssn_field;

	/* Return to Doctor_Button_Options button */
	private JButton return_button;

	/* Types of records that can be modified for a Doctor */
	private String[] doctor_record_options = {"Supervisor"};

	/* Allows the user to select from the types of records that can be
	*  modified up for a Doctor */
	private JComboBox doctor_record_selection;



	/*********************************************************************************
	* Main constructor used for setting up the Doctor_Record_Lookup panel.
	*********************************************************************************/
	public Modify_Doctor_Info_Panel(Doctor_Menu_Panel menu)
	{	
		this.outer_menu = menu;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeButtons();
		initializeLabels();
		initializeFields();
		initializeComboBoxes();

		addActionListeners();


		// add the components to the panel
		add(lookup_label);

		// add combo box
		add(doctor_record_selection);

		add(new JLabel("to"));

		add(new JTextField(6));

		add(ssn_label);	// add "by ssn: " label

		add(ssn_field); // add text field for ssn

		add(submit_info_button); // add submit button

		add(results_label);	// add "Results: " label

		add(new JLabel("                        "));

		add(return_button); // add "return to" option
	}


	/*********************************************************************************
	* Initializes the JTextFields for the Doctor menu.
	*********************************************************************************/
	private void initializeFields()
	{
		ssn_field = new JTextField(9);
	}

	/*********************************************************************************
	* Initializes the JComboBoxes for the Doctor menu.
	*********************************************************************************/
	private void initializeComboBoxes()
	{
		doctor_record_selection = new JComboBox(doctor_record_options);
	}


	/*********************************************************************************
	* Initializes the buttons for the Doctor menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		submit_info_button = new JButton("submit");

		return_button = new JButton("return to options");
	}



	/*********************************************************************************
	* Initializes the buttons for the Doctor menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		lookup_label = new JLabel("Change: ");

		ssn_label = new JLabel(" for Doctor with ssn: ");

		results_label = new JLabel("Results:");
	}



	/*********************************************************************************
	* Adds the action listeners for Interface_Option_Buttons.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Submit user input */
		submit_info_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});

		/* Add functionality - Return to Button options interface */
		return_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				outer_menu.addDoctorButtonOptions();
			}
		});


	} // end addActionListeners()


} // end Doctor_Record_Lookup class