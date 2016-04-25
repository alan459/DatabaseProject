import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A Procedure menu to display to the user all the options for interacting with the Procedure
* database relation.
*****************************************************************************************************/
public class Procedure_Menu_Panel extends JPanel 
{
	/* Main panel displayed to the user */ 
	private JPanel current_panel;

	/* Pointer to the main java window for passing to new instances of a main menu button panel */
	protected Hospital_Frame hospital_frame;

	/* Pointer to menu button panel so it can be removed when necessary */
	private JPanel main_menu_button;	

	/* String to get input data from fields */
	private String input;




	/*********************************************************************************
	* Main constructor used for setting up the Procedure_Menu_Panel.
	*********************************************************************************/
	public Procedure_Menu_Panel ( Hospital_Frame  frame ) 
	{
		this.hospital_frame = frame;

		setLayout(new GridLayout(2,1));

		add(current_panel = new Procedure_Button_Options());

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
	private class Procedure_Button_Options extends JPanel
	{
		/* Buttons to take user to a panel for interacting with the Procedure relation */
		private JButton insert_procedure_button, delete_procedure_button;

		/*********************************************************************************
		* Main constructor used for setting up the Procedure_Menu_Panel.
		*********************************************************************************/
		public Procedure_Button_Options () 
		{
			setLayout(new GridBagLayout());

			initializeButtons();
			addActionListeners();

			add(insert_procedure_button);
			add(delete_procedure_button);

		}


		/*********************************************************************************
		* Initializes the buttons for Procedure_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			insert_procedure_button = new JButton("Add New Procedure");
			delete_procedure_button = new JButton("Delete Existing Procedure");
		}

		
		/*********************************************************************************
		* Adds the action listeners for Procedure_Button_Options.
		*********************************************************************************/
		private void addActionListeners()
		{

			/* Add functionality - Display panel for inserting a new Procedure */
			insert_procedure_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Insert_Procedure_Menu_Panel());
				}
			});

			/* Add functionality - Display panel for deleting an existing Procedure */
			delete_procedure_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Delete_Procedure_Menu_Panel());
				}
			});

		} // end addActionListeners()

	} // end Procedure Button Options Class











	/*****************************************************************************************************
	* A menu displayed to the user to insert a new Procedure into the database. 
	*****************************************************************************************************/
	private class Insert_Procedure_Menu_Panel extends JPanel 
	{
		/* Text fields for the user to enter intput data */
		private JTextField procedure_id_field, procedure_description_field, patient_ssn_field, doctor_ssn_field,
						   nurse_ssn_field, scheduled_time_field, scheduled_date_field;


		/*********************************************************************************
		* Main constructor used for setting up the Insert_Procedure_Menu_Panel.
		*********************************************************************************/
		public Insert_Procedure_Menu_Panel() 
		{
			setLayout(new GridLayout(9, 2));

			initializeTextFields();

			add(new JLabel("Enter information of Procedure to be added: "));
			add(new JLabel(""));

			add(new JLabel(" Procedure ID:"));
			add(procedure_id_field);

			add(new JLabel(" Procedure Description:"));
			add(procedure_description_field);

			add(new JLabel(" Patient SSN:"));
			add(patient_ssn_field);

			add(new JLabel(" Doctor SSN:"));
			add(doctor_ssn_field);

			add(new JLabel(" Nurse SSN:"));
			add(nurse_ssn_field);

			add(new JLabel(" Scheduled Date:"));
			add(scheduled_date_field);

			add(new JLabel(" Scheduled Time:"));
			add(scheduled_time_field);

			add(new Back_Button());
			add(new Submit_Button());

		}

		/*********************************************************************************
		* Initializes the text fields for Insert_Procedure_Menu_Panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			procedure_id_field = new JTextField(6);
			procedure_description_field = new JTextField(25);

			patient_ssn_field  = new JTextField(6);
			doctor_ssn_field = new JTextField(6);
			nurse_ssn_field = new JTextField(6);

			scheduled_date_field = new JTextField(6);
			scheduled_time_field = new JTextField(6);
		}


		/******************************************************************************
		* Submit button for Insert_Procedure_Menu_Panel class.
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

						// * somehow get string of doctors name, ssn, code from instance *  and then:
						//Patient.insert(input);

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

				input = procedure_id_field.getText() + "\t" + patient_ssn_field.getText() + "\t" + doctor_ssn_field.getText() + "\t" + 
				nurse_ssn_field.getText() + "\t" + scheduled_date_field.getText() + "\t" + scheduled_time_field.getText();

				
				// if this point is reached age and ssn were successfully retrieved
				return input;

			}

		} // end Submit_Button class


	} // end Insert Procedure menu class











	/*****************************************************************************************************
	* A menu displayed to the user to delete an existing Procedure from the database. 
	*****************************************************************************************************/
	private class Delete_Procedure_Menu_Panel extends JPanel 
	{
		/* Text fields for the user to enter intput data */
		private JTextField procedure_id_field;


		/*********************************************************************************
		* Main constructor used for setting up the Delete_Procedure_Menu_Panel.
		*********************************************************************************/
		public Delete_Procedure_Menu_Panel() 
		{
			setLayout(new GridLayout(4, 2));

			initializeTextFields();

			add(new Centered_Text_Panel("Enter ID of Procedure to be deleted:"));
			add(procedure_id_field);

			add(new JLabel(""));
			add(new JLabel(""));

			add(new Back_Button());
			add(new Submit_Button());
		}

		/*********************************************************************************
		* Initializes the text fields for Delete_Procedure_Menu_Panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			procedure_id_field = new JTextField(6);
		}

		/******************************************************************************
		* Submit button for Delete_Procedure_Menu_Panel class.
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

						// * somehow get string of doctors name, ssn, code from instance *  and then:
						//Procedure.delete(input);

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

				input = procedure_id_field.getText();
				
				// if this point is reached age and ssn were successfully retrieved
				return input;

			}

		} // end Submit_Button class


	} // end Delete_Procedure_Menu_Panel class




	/*********************************************************************************
	* Returns the user to the main Procedure menu
	*********************************************************************************/
	private class Back_Button extends JButton
	{
		public Back_Button()
		{
			super("<- Back");

			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Procedure_Button_Options());
				}
			});
		}
	}



} // end Procedure menu class