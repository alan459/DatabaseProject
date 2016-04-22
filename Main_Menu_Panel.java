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
	private Hospital_Frame HOSPITAL_FRAME;

	/* Buttons to select which type of entity the user is interested in */
	private JButton PATIENT_BUTTON, DOCTOR_BUTTON, NURSE_BUTTON;

	/* Displays to the user some information as to where clicking the buttons will take them */
	private JLabel RECORD_SEARCH_LABEL;
	private int a = 2;


	/*********************************************************************************
	* Main constructor used when creating a main menu.
	*********************************************************************************/
	public Main_Menu_Panel(Hospital_Frame frame) 
	{
		this.HOSPITAL_FRAME = frame;

		intializeLabels();

		initializeButtons();

		addActionListeners();

		add(RECORD_SEARCH_LABEL);

		add(PATIENT_BUTTON);
		add(DOCTOR_BUTTON);
		add(NURSE_BUTTON);

	}



	/*********************************************************************************
	* Initialize the labels for the main menu.
	*********************************************************************************/
	private void intializeLabels()
	{
		RECORD_SEARCH_LABEL = new JLabel("Record Search");
	}



	/*********************************************************************************
	* Initialize the buttons for the main menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		PATIENT_BUTTON = new JButton("Patient");
		DOCTOR_BUTTON = new JButton("Doctor");
		NURSE_BUTTON = new JButton("Nurse");
	}


	
	/*********************************************************************************
	* Adds the action listeners for the main menu.
	*********************************************************************************/
	private void addActionListeners()
	{
		PATIENT_BUTTON.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HOSPITAL_FRAME.getPatientMenu();			    
			}

		});


		DOCTOR_BUTTON.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//HOSPITAL_FRAME.getDoctorMenu();			    
			}

		});


		NURSE_BUTTON.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HOSPITAL_FRAME.getNurseMenu();			    
			}

		});
	}



} // end main menu class