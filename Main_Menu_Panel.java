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
	private Hospital_Frame hospital_frame;

	/* Buttons to select which type of entity the user is interested in */
	private JButton patient_button, doctor_button, nurse_button;

	/* Displays to the user some information as to where clicking the buttons will take them */
	private JLabel record_search_label;


	/*********************************************************************************
	* Main constructor used when creating a main menu.
	*********************************************************************************/
	public Main_Menu_Panel(Hospital_Frame frame) 
	{
		this.hospital_frame = frame;

		intializeLabels();

		initializeButtons();

		addActionListeners();

		add(record_search_label);

		add(patient_button);
		add(doctor_button);
		add(nurse_button);

	}



	/*********************************************************************************
	* Initialize the labels for the main menu.
	*********************************************************************************/
	private void intializeLabels()
	{
		record_search_label = new JLabel("Record Search");
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
				hospital_frame.getPatientMenu();			    
			}

		});


		doctor_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				hospital_frame.getDoctorMenu();			    
			}

		});


		nurse_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				hospital_frame.getNurseMenu();			    
			}

		});
	}



} // end main menu class