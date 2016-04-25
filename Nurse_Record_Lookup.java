import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*********************************************************************************
* 1 of the 2 INNER JPanels that result from a button being clicked in the button
* interface to display the nurse record lookup interface on the right side of 
* the window after the "nurse Record Lookup" button is pressed.
*********************************************************************************/
public class Nurse_Record_Lookup extends JPanel
{
	private Nurse_Menu_Panel outer_menu;

	/* Input submission buttons */
	private JButton submit_info_button;

	/* Labels for describing input/output fields */
	private JLabel lookup_label, ssn_label, results_label;

	/* Input from the user */
	private JTextField ssn_field;

	/* Return to Interface_Option_Buttons button */
	private JButton return_button;

	/* Types of records that can be looked up for a nurse */
	private String[] nurse_record_options = {"Supervisor"};

	/* Allows the user to select from the types of records that can be
	*  looked up for a nurse */
	private JComboBox nurse_record_selection;



	/*********************************************************************************
	* Main constructor used for setting up the Nurse_Record_Lookup panel.
	*********************************************************************************/
	public Nurse_Record_Lookup(Nurse_Menu_Panel menu)
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
		add(nurse_record_selection);

		add(ssn_label);	// add "by ssn: " label

		add(ssn_field); // add text field for ssn

		add(submit_info_button); // add submit button

		add(results_label);	// add "Results: " label

		add(new JLabel("                        "));

		add(return_button); // add "return to" option
	}


	/*********************************************************************************
	* Initializes the JTextFields for the nurse menu.
	*********************************************************************************/
	private void initializeFields()
	{
		ssn_field = new JTextField(9);
	}

	/*********************************************************************************
	* Initializes the JComboBoxes for the nurse menu.
	*********************************************************************************/
	private void initializeComboBoxes()
	{
		nurse_record_selection = new JComboBox(nurse_record_options);
	}


	/*********************************************************************************
	* Initializes the buttons for the nurse menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		submit_info_button = new JButton("submit");

		return_button = new JButton("return to options");
	}



	/*********************************************************************************
	* Initializes the buttons for the nurse menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		lookup_label = new JLabel("Lookup: ");

		ssn_label = new JLabel(" for Nurse with ssn: ");

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
		  	outer_menu.addNurseButtonOptions();
		  }
		});


	} // end addActionListeners()


} // end Nurse_Record_Lookup class