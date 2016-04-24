import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A Treatment menu to display to the user all the options for interacting with the Treatment
* database relation.
*****************************************************************************************************/
public class Treatment_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	protected Hospital_Frame hospital_frame;

	/* Main screen displayed to the user */ 
	private JPanel current_panel;

	/* Panel with 1 BUTTON to return the screen to the MAIN MENU */
	private JPanel main_menu_button;	



	/*********************************************************************************
	* Main constructor used for setting up the Treatment_Menu_Panel.
	*********************************************************************************/
	public Treatment_Menu_Panel ( Hospital_Frame  frame ) 
	{
		this.hospital_frame = frame;

		setLayout(new GridLayout(2,1));

		//initializeButtons();
		//addActionListeners();

		add(current_panel = new Treatment_Button_Options());

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
	private class Treatment_Button_Options extends JPanel
	{
		/* Buttons to take user to a panel for interacting with the Treatment relation */
		private JButton insert_treatment_button, delete_treatment_button;

		/*********************************************************************************
		* Main constructor used for setting up the Treatment_Menu_Panel.
		*********************************************************************************/
		public Treatment_Button_Options () 
		{
			setLayout(new GridBagLayout());

			initializeButtons();
			addActionListeners();

			add(insert_treatment_button);
			add(delete_treatment_button);

		}


		/*********************************************************************************
		* Initializes the buttons for Treatment_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			insert_treatment_button = new JButton("Add New Treatment");
			delete_treatment_button = new JButton("Delete Existing Treatment");
		}

		
		/*********************************************************************************
		* Adds the action listeners for Treatment_Button_Options.
		*********************************************************************************/
		private void addActionListeners()
		{

			/* Add functionality - Display panel for inserting a new Treatment */
			insert_treatment_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Insert_Treatment_Menu_Panel());
				}
			});

			/* Add functionality - Display panel for deleting an existing Treatment */
			delete_treatment_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Delete_Treatment_Menu_Panel());
				}
			});

		} // end addActionListeners()

	} // end Treatment Button Options Class











	/*****************************************************************************************************
	* A menu displayed to the user to insert a new Treatment into the database. 
	*****************************************************************************************************/
	private class Insert_Treatment_Menu_Panel extends JPanel 
	{
		/* Button to return the screen to the main menu */
		private JButton submit_button;	

		/* Text fields for the user to enter intput data */
		private JTextField treatment_id_field, patient_ssn_field, doctor_ssn_field, treatment_start_date_field, 
						   treatment_end_date_field, medicaton_field, dosage_field, method_of_delivery_field;


		/*********************************************************************************
		* Main constructor used for setting up the Insert_Treatment_Menu_Panel.
		*********************************************************************************/
		public Insert_Treatment_Menu_Panel() 
		{
			setLayout(new GridLayout(10, 2));

			initializeButtons();
			addActionListeners();

			initializeTextFields();

			add(new JLabel("Enter information of Treatment to be added: "));
			add(new JLabel(""));

			add(new JLabel(" Treatment ID:"));
			add(treatment_id_field);

			add(new JLabel(" Patient SSN:"));
			add(patient_ssn_field);

			add(new JLabel(" Doctor SSN:"));
			add(doctor_ssn_field);

			add(new JLabel(" Treatment Start Date:"));
			add(treatment_start_date_field);

			add(new JLabel(" Treatment End Date:"));
			add(treatment_end_date_field);

			add(new JLabel(" Medication:"));
			add(medicaton_field);

			add(new JLabel(" Dosage:"));
			add(dosage_field);

			add(new JLabel(" Method of Delivery:"));
			add(method_of_delivery_field);

			add(new Back_Button());
			add(submit_button);


		}

		/*********************************************************************************
		* Initializes the text fields for Insert_Treatment_Menu_Panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			treatment_id_field = new JTextField(6);

			patient_ssn_field  = new JTextField(6);
			doctor_ssn_field = new JTextField(6);

			treatment_start_date_field = new JTextField(6);
			treatment_end_date_field = new JTextField(6);
			
			medicaton_field = new JTextField(2);

			dosage_field = new JTextField(6);

			method_of_delivery_field = new JTextField(16);
		}


		/*********************************************************************************
		* Initializes the buttons for Insert_Treatment_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			submit_button = new JButton("Submit");
		}



		/*********************************************************************************
		* Adds the action listeners for Insert_Treatment_Menu_Panel.
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





	} // end Insert Treatment menu class











	/*****************************************************************************************************
	* A menu displayed to the user to delete an existing Treatment from the database. 
	*****************************************************************************************************/
	private class Delete_Treatment_Menu_Panel extends JPanel 
	{
		/* Button to return the screen to the main menu */
		private JButton submit_button;	

		/* Text fields for the user to enter intput data */
		private JTextField treatment_id_field;


		/*********************************************************************************
		* Main constructor used for setting up the Delete_Treatment_Menu_Panel.
		*********************************************************************************/
		public Delete_Treatment_Menu_Panel() 
		{
			setLayout(new GridLayout(4, 2));

			initializeButtons();
			addActionListeners();

			initializeTextFields();

			add(new Centered_Text_Panel("Enter ID of Treatment to be deleted:"));
			add(treatment_id_field);

			add(new JLabel(""));
			add(new JLabel(""));

			add(new Back_Button());
			add(submit_button);
		}

		/*********************************************************************************
		* Initializes the text fields for Delete_Treatment_Menu_Panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			treatment_id_field = new JTextField(6);
		}


		/*********************************************************************************
		* Initializes the buttons for Delete_Treatment_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			submit_button = new JButton("Submit");
		}



		/*********************************************************************************
		* Adds the action listeners for Delete_Treatment_Menu_Panel.
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



	} // end Delete_Treatment_Menu_Panel class




	/*********************************************************************************
	* Returns the user to the main treatment menu
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
					changeCurrentPanel(new Treatment_Button_Options());
				}
			});
		}
	}



} // end Treatment menu class