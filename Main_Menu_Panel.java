//package hos;

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

	/* Displays to the user some information as to where clicking the buttons will take them */
	// private JLabel record_search_label;


	/*********************************************************************************
	* Main constructor used when creating a main menu.
	*********************************************************************************/
	public Main_Menu_Panel(Hospital_Frame frame) 
	{
		setLayout(new GridLayout(2, 2));

		this.hospital_frame = frame;

		add(new Centered_Text_Panel("Access Records for: "));

		add(panel1 = new Records_Panel());

		add(new Centered_Text_Panel("Insert Records for: "));

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
		/* Buttons to select which type of entity the user is interested in */
		private JButton patient_button, doctor_button, nurse_button;



		/*********************************************************************************
		* Main constructor used when creating a Update_Panel.
		*********************************************************************************/
		public Update_Panel() 
		{
			setLayout(new GridBagLayout());

			initializeButtons();
			addActionListeners();

			add(patient_button);
			add(doctor_button);
			add(nurse_button);
		}


		/*********************************************************************************
		* Initialize the buttons for the insert patient button in the main menu.
		*********************************************************************************/
		private void initializeButtons()
		{
			patient_button = new JButton("Patient");
			doctor_button = new JButton("Doctor");
			nurse_button = new JButton("Nurse");
		}


		
		/*********************************************************************************
		* Adds the action listeners for the nsert patient button in the main menu.
		*********************************************************************************/
		private void addActionListeners()
		{
			patient_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					hospital_frame.changeScreen( new Insert_Patient_Menu_Panel(hospital_frame) );					    
				}

			});


			doctor_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					//hospital_frame.changeScreen();			    
				}

			});


			nurse_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					//hospital_frame.changeScreen();			    
				}

			});
		}
		

	}





} // end main menu class