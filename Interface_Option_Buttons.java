//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*********************************************************************************
* INNER JPanel to be used as a display of the button options for the user 
* on the right side of the window to select an interface.
*********************************************************************************/
public class Patient_Button_Options extends JPanel
{
	/* Input submission buttons */
	private JButton modify_treatment_button, modify_patient_info_button, lookup_patients_button, lookup_records_button;



	/*********************************************************************************
	* Main constructor for the Patient_Button_Options class used for setting up 
	* the interface menu options.
	*********************************************************************************/
	public Patient_Button_Options()
	{
		this.outerPanel = outer;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		addActionListeners();

		// add the components to the panel
		add(updateInfoButton);
		add(recordLookupButton);
		add(modifyTreatmentButton);
	}


	/*********************************************************************************
	* Initializes the buttons for Patient_Button_Options.
	*********************************************************************************/
	private void initializeButtons()
	{
		updateInfoButton = new JButton("UPDATE PATIENT INFO");
		recordLookupButton = new JButton("PATIENT RECORD LOOKUP");
		modifyTreatmentButton = new JButton("MODIFY TREATMENT PLAN");
	}



	/*********************************************************************************
	* Adds the action listeners for Patient_Button_Options.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Take user to update patient interface */
		updateInfoButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    	
		  }
		});

		/* Add functionality to button'PATIENT RECORD LOOKUP' - Display to user the patient record lookup interface */
		recordLookupButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	outerPanel.addPatientRecordLookup();
		  }
		});

		/* Add functionality - Take user to modofy treatment plan interface */
		modifyTreatmentButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  }
		});

	} // end addActionListeners()


} // end Patient_Button_Options class