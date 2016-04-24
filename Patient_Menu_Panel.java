import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A patient menu to display to the user 2 panels, 1 for looking up a patient on the left side of the 
* window, and a 2nd on the right side which is selected from 3 options from buttons for updating 
* patient info, patient record lookup, and modify treatment plan.
*****************************************************************************************************/
public class Patient_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame mainFrame;

	/* Button to return the screen to the main menu */
	private JButton mainMenuButton;	

	/* Main labels for the options on this screen - largest text blocks - put above each inner panel */
	private JLabel patientLookupLabel, recordLookupLabel;

	/* Left side interface displayed to the user to lookup a patient */
	private JPanel patientLookup;

	/* Right side interface displayed to the user, displaying either button options or
	* an interface based on button pressed */
	private JPanel currentInterface;



	/*********************************************************************************
	* Main constructor used for setting up the Patient_Menu_Panel.
	*********************************************************************************/
	public Patient_Menu_Panel(Hospital_Frame main) 
	{
		this.mainFrame = main;

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		initializeLabels();
		addActionListeners();

		//JPanel pan = new JPanel();
		//pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		//add(patientLookupLabel);
		add(patientLookup = new Patient_Lookup_Panel());
		//setLayout(new FlowLayout());
		//addButtonOptions();
		//add(pan);


		//add(recordLookupLabel);
		add(currentInterface = new Interface_Option_Buttons(this)); 
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(mainMenuButton);


	}



	/*********************************************************************************
	* Initializes the buttons for Patient_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		mainMenuButton = new JButton("Main Menu");
	}



	/*********************************************************************************
	* Initializes the buttons for Patient_Menu_Panel.
	*********************************************************************************/
	private void initializeLabels()
	{
		patientLookupLabel = new JLabel("Patient Lookup");
		recordLookupLabel = new JLabel("Record Lookup");
	}



	/*********************************************************************************
	* Adds the action listeners for Patient_Menu_Panel.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Return user to main menu */
		mainMenuButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	mainFrame.getMainMenu();
		  }
		});

	} // end addActionListeners()



	/*********************************************************************************
	* Removes any panel displayed on the right side of the patient menu window and
	* adds 3 buttons options:
	*
	* ['UPDATE PATIENT INFO', 'PATIENT RECORD LOOKUP','MODIFY TREATMENT PLAN']
	*
	* Switches currentInterface to an instance of Interface_Option_Buttons.
	*********************************************************************************/
	public void addPatientButtonOptions()
	{
		if(currentInterface != null)
		{
			remove(currentInterface);
		}

		add(currentInterface = new Interface_Option_Buttons(this));
		revalidate();
		repaint();
	}



	/*********************************************************************************
	* Replaces the button interface with a patient lookup interface when the 
	* 'PATIENT RECORD LOOKUP' button is pressed in the button interface. 
	*
	* Switches currentInterface from Interface_Option_Buttons to Patient_Lookup_Panel.
	*********************************************************************************/
	public void addPatientRecordLookup()
	{
		remove(currentInterface);
		add(currentInterface = new Patient_Record_Lookup(this));
		revalidate();
		repaint();
	}








} // end patient menu class