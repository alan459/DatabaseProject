import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* Represents an instance of a main menu to display on the JFrame.
*****************************************************************************************************/
public class Main_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	protected Hospital_Frame hospital_frame;

	/* Panels displaying different options to the user */
	private JPanel panel1, panel2;


	/*********************************************************************************
	* Main constructor used when creating a main menu.
	*********************************************************************************/
	public Main_Menu_Panel(Hospital_Frame frame) 
	{
		setLayout(new GridLayout(2, 4));

		// establish a reference to the frame to change the displayed panel
		this.hospital_frame = frame;

		add(new Centered_Text_Panel("Access Records for: "));

		add(panel1 = new Records_Panel());

		add(new Centered_Text_Panel("Insert/Delete Records for: "));

		add(panel2 = new Update_Panel());

	}




	private class Records_Panel extends JPanel
	{
		/* Buttons to select which type of entity the user is interested in */
		private JButton patient_button, doctor_button, nurse_button;


		/*********************************************************************************
		* Main constructor used when creating a records panel.
		*********************************************************************************/
		public Records_Panel() 
		{
			setLayout(new GridBagLayout());
			initializeButtons();
			addActionListeners();

			add(patient_button);
			add(doctor_button);
			add(nurse_button);
		}


		/*********************************************************************************
		* Initialize the buttons for the main menu.
		*********************************************************************************/
		private void initializeButtons()
		{
			patient_button = new JButton("Patient");
			doctor_button = new JButton("Doctor");
			nurse_button = new JButton("Nurse");
		}


		
		/*********************************************************************************
		* Adds the action listeners for the main menu.
		*********************************************************************************/
		private void addActionListeners()
		{
			patient_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					hospital_frame.changeScreen( new Patient_Menu_Panel(hospital_frame) );			    
				}

			});


			doctor_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					hospital_frame.changeScreen( new Doctor_Menu_Panel(hospital_frame) );		    
				}

			});


			nurse_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					hospital_frame.changeScreen( new Nurse_Menu_Panel(hospital_frame) );		    
				}

			});
		}

	} // end Records class




	private class Update_Panel extends JPanel
	{
		/* Button to select which type of entity the user is interested in */
		private JButton submit_button;

		/* Drop down menu for selecting which relation to insert into */
		private JComboBox relation_selection_combo_box;

		/* Options for the user to select from in the drop down menu */
		private String[] relation_selection_options = {"Patient", "Nurse", "Doctor", "Medication", "Prescription", "Treatment", "Procedure"};


		/*********************************************************************************
		* Main constructor used when creating a Update_Panel.
		*********************************************************************************/
		public Update_Panel() 
		{
			setLayout(new GridBagLayout());

			initializeButtons();
			addActionListeners();

			relation_selection_combo_box = new JComboBox(relation_selection_options);

			add(relation_selection_combo_box);
			add(submit_button);
		}


		/*********************************************************************************
		* Initialize the buttons for the insert patient button in the main menu.
		*********************************************************************************/
		private void initializeButtons()
		{
			submit_button = new JButton("Submit");
		}


		
		/*********************************************************************************
		* Adds the action listeners for the nsert patient button in the main menu.
		*********************************************************************************/
		private void addActionListeners()
		{
			submit_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					fetchDropDownMenuSelection();
				}

			});

		}

		/*********************************************************************************
		* Get the selected relation from the drop down menu and change the screen to the 
		* panel for inserting into that selection
		*********************************************************************************/
		private void fetchDropDownMenuSelection()
		{
			String selection = relation_selection_combo_box.getSelectedItem().toString();

			// Switch the screen to the selected option
			switch(selection)
			{
				case "Patient": 
					hospital_frame.changeScreen(new Insert_Patient_Menu_Panel(hospital_frame));
					break;

				case "Nurse": 
					hospital_frame.changeScreen(new Insert_Nurse_Menu_Panel(hospital_frame));
					break;

				case "Doctor": 
					hospital_frame.changeScreen(new Insert_Doctor_Menu_Panel(hospital_frame));
					break;

				case "Prescription": 
					hospital_frame.changeScreen(new Prescription_Menu_Panel(hospital_frame));
					break;

				case "Treatment": 
					hospital_frame.changeScreen(new Treatment_Menu_Panel(hospital_frame));
					break;

				case "Medication": 
					hospital_frame.changeScreen(new Insert_Medication_Menu_Panel(hospital_frame));
					break;

				case "Procedure":
					hospital_frame.changeScreen(new Procedure_Menu_Panel(hospital_frame));
					break;

				default:
					hospital_frame.changeScreen(new Insert_Doctor_Menu_Panel(hospital_frame));
					break;

			}
		}
		

	} // end update panel class



} // end main menu class