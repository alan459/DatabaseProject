//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*********************************************************************************
* INNER JPanel to be used as a display of the button options for the user 
* on the right side of the window to select an interface.
*********************************************************************************/
public class Nurse_Option_Buttons extends JPanel
{
	private Nurse_Menu_Panel outerPanel;

	/* Input submission buttons */
	private JButton updateInfoButton, recordLookupButton, modifyTreatmentButton;



	/*********************************************************************************
	* Main constructor for the Nurse_Option_Buttons class used for setting up 
	* the interface menu options.
	*********************************************************************************/
	public Nurse_Option_Buttons(Nurse_Menu_Panel outer)
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
	* Initializes the buttons for Nurse_Option_Buttons.
	*********************************************************************************/
	private void initializeButtons()
	{
		updateInfoButton = new JButton("UPDATE PATIENT INFO");
		recordLookupButton = new JButton("PATIENT RECORD LOOKUP");
		modifyTreatmentButton = new JButton("MODIFY TREATMENT PLAN");
	}



	/*********************************************************************************
	* Adds the action listeners for Nurse_Option_Buttons.
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
		  	outerPanel.addNurseRecordLookup();
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


} // end Nurse_Option_Buttons class