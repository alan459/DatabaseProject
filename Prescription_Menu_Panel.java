import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// NEED TO ADD SUBMIT BUTTON HERE

/*****************************************************************************************************
* A Prescription menu to display to the user all the options for interacting with the prescription
* database relation.
*****************************************************************************************************/
public class Prescription_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	protected Hospital_Frame hospital_frame;

	/* Main screen displayed to the user */ 
	private JPanel current_panel;

	/* Panel with 1 BUTTON to return the screen to the MAIN MENU */
	private JPanel main_menu_button;	



	/*********************************************************************************
	* Main constructor used for setting up the Prescription_Menu_Panel.
	*********************************************************************************/
	public Prescription_Menu_Panel ( Hospital_Frame  frame ) 
	{
		this.hospital_frame = frame;

		setLayout(new GridLayout(2,1));

		//initializeButtons();
		//addActionListeners();

		add(current_panel = new Prescription_Button_Options());

		add(main_menu_button = new Main_Menu_Button(hospital_frame));
	}

	
	/*********************************************************************************
	* Switches the current main panel to the passed in one
	*********************************************************************************/
	protected void changeCurrentPanel(JPanel panel)
	{
		remove(current_panel);

		// need to remove and re-add so the button stays on the bottom
		remove(main_menu_button);

		add(current_panel = panel);
		add(main_menu_button = new Main_Menu_Button(hospital_frame));

		revalidate();
		repaint();

	} // end changeCurrentPanel()











	/*********************************************************************************
	* Panel for displaying options for interacting with database.
	*********************************************************************************/
	private class Prescription_Button_Options extends JPanel
	{
		/* Buttons to take user to a panel for interacting with the prescription relation */
		private JButton insert_prescription_button, delete_prescription_button;

		/*********************************************************************************
		* Main constructor used for setting up the Prescription_Menu_Panel.
		*********************************************************************************/
		public Prescription_Button_Options () 
		{
			setLayout(new GridBagLayout());

			initializeButtons();
			addActionListeners();

			add(insert_prescription_button);
			add(delete_prescription_button);

		}


		/*********************************************************************************
		* Initializes the buttons for Prescription_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			insert_prescription_button = new JButton("Add New Prescription");
			delete_prescription_button = new JButton("Delete Existing Prescription");
		}

		
		/*********************************************************************************
		* Adds the action listeners for Prescription_Button_Options.
		*********************************************************************************/
		private void addActionListeners()
		{

			/* Add functionality - Display panel for inserting a new prescription */
			insert_prescription_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Insert_Prescription_Menu_Panel());
				}
			});

			/* Add functionality - Display panel for deleting an existing prescription */
			delete_prescription_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Delete_Prescription_Menu_Panel());
				}
			});

		} // end addActionListeners()

	} // end Prescription Button Options Class











	/*****************************************************************************************************
	* A menu displayed to the user to insert a new prescription into the database. 
	*****************************************************************************************************/
	private class Insert_Prescription_Menu_Panel extends JPanel 
	{
		/* Button to return the screen to the main menu */
		private JButton submit_button, back_button;	

		/* Text fields for the user to enter intput data */
		private JTextField patient_ssn_field, doctor_ssn_field, prescription_date_field, medicaton_field, dosage_field,
                        optional_field, refills_field;

		private String input;


		/*********************************************************************************
		* Main constructor used for setting up the Insert_Prescription_Menu_Panel.
		*********************************************************************************/
		public Insert_Prescription_Menu_Panel() 
		{
			setLayout(new GridLayout(9, 2));

			//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			initializeButtons();
			addActionListeners();

			initializeTextFields();

			add(new JLabel("Enter information of prescription to be added: "));

			// skip to the next row in the grid layout
			add(new JLabel(""));

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
                        
                        add(new JLabel(" Optional:"));
			add(optional_field);
                        
                        add(new JLabel(" Refills:"));
			add(refills_field);

			add(back_button);
			add(submit_button);


		}

		/*********************************************************************************
		* Initializes the text fields for Insert_Prescription_Menu_Panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			patient_ssn_field  = new JTextField(6);
			doctor_ssn_field = new JTextField(6);

			prescription_date_field = new JTextField(6);
			medicaton_field = new JTextField(2);

			dosage_field = new JTextField(6);
                        
                        optional_field = new JTextField(1);
			refills_field = new JTextField(3);
		}


		/*********************************************************************************
		* Initializes the buttons for Insert_Prescription_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			submit_button = new JButton("Submit");
			back_button = new JButton("<- Back");
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
					loadInput();

					Doctor.insertPPT("PRESCRIPTION", input);
                                        
                                        JOptionPane.showMessageDialog(null, "Submitted");
				}
			});

			/* Add functionality - Return to button options */
			back_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Prescription_Button_Options());
				}
			});

		} // end addActionListeners()


		/*********************************************************************************
		* Loads the text from the fields into input String variable.
		*********************************************************************************/
		private void loadInput()
		{
			input =  patient_ssn_field.getText() + "\t" + doctor_ssn_field.getText() + "\t" + 
			prescription_date_field.getText() + "\t" + medicaton_field.getText() + "\t" + dosage_field.getText()
                                + "\t" + optional_field.getText() + "\t" + refills_field.getText();
		}

	} // end Insert_Prescription_Menu_Panel class











	/*****************************************************************************************************
	* A menu displayed to the user to delete an existing prescription from the database. 
	*****************************************************************************************************/
	private class Delete_Prescription_Menu_Panel extends JPanel 
	{
		/* Button to return the screen to the main menu */
		private JButton submit_button, back_button;	

		/* Text fields for the user to enter intput data */
		private JTextField prescription_id_field;

		private String input;

		/*********************************************************************************
		* Main constructor used for setting up the Delete_Prescription_Menu_Panel.
		*********************************************************************************/
		public Delete_Prescription_Menu_Panel() 
		{
			setLayout(new GridLayout(4, 2));

			//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			initializeButtons();
			addActionListeners();

			initializeTextFields();

			add(new Centered_Text_Panel("Enter ID of Prescription to be deleted:"));
			add(prescription_id_field);

			add(new JLabel(""));
			add(new JLabel(""));

			add(back_button);
			add(submit_button);


		}

		/*********************************************************************************
		* Initializes the text fields for Delete_Prescription_Menu_Panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			prescription_id_field = new JTextField(6);
		}


		/*********************************************************************************
		* Initializes the buttons for Delete_Prescription_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			submit_button = new JButton("Submit");
			back_button = new JButton("<- Back");
		}



		/*********************************************************************************
		* Adds the action listeners for Delete_Prescription_Menu_Panel.
		*********************************************************************************/
		private void addActionListeners()
		{
			/* Add functionality - Submit data in text fields */
			submit_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					loadInput();

					Patient.delete(input, "PRESCRIPTION");
                                        
                                        JOptionPane.showMessageDialog(null, "Deleted");
				}
			});

			/* Add functionality - Return to button options */
			back_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Prescription_Button_Options());
				}
			});

		} // end addActionListeners()


		/*********************************************************************************
		* Loads the text from the fields into input String variable.
		*********************************************************************************/
		private void loadInput()
		{
			input = prescription_id_field.getText();
		}



	} // end Delete_Prescription_Menu_Panel class





} // end Prescription menu class