//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*********************************************************************************
* 1 of the 3 INNER JPanels that result from a button being clicked in the button
* interface to display the patient record lookup interface on the right side of 
* the window after the "Patient Record Lookup" button is pressed.
*********************************************************************************/
public class Patient_Record_Lookup extends JPanel
{
	private Patient_Menu_Panel outerPanel;

	/* Input submission buttons */
	private JButton submitInfoButton;

	/* Labels for describing input/output fields */
	private JLabel lookupLabel, ssnLabel, resultsLabel;

	/* Input from the user */
	private JTextField ssnField;

	/* Return to Interface_Option_Buttons button */
	private JButton returnButton;



	/*********************************************************************************
	* Main constructor used for setting up the Patient_Record_Lookup panel.
	*********************************************************************************/
	public Patient_Record_Lookup(Patient_Menu_Panel outer)
	{
		this.outerPanel = outer;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		initializeLabels();

		addActionListeners();


		// add the components to the panel
		add(lookupLabel);
		add(ssnLabel);
		add(submitInfoButton);
		add(resultsLabel);

		add(returnButton);
	}



	/*********************************************************************************
	* Initializes the buttons for the patient menu.
	*********************************************************************************/
	private void initializeButtons()
	{
		submitInfoButton = new JButton("submit");

		returnButton = new JButton("return to options");
	}




	/*********************************************************************************
	* Initializes the buttons for the patient menu.
	*********************************************************************************/
	private void initializeLabels()
	{
		lookupLabel = new JLabel("lookup patient ");

		ssnLabel = new JLabel("by ssn ");

		resultsLabel = new JLabel("Results");
	}



	/*********************************************************************************
	* Adds the action listeners for Interface_Option_Buttons.
	*********************************************************************************/
	private void addActionListeners()
	{

		/* Add functionality - Submit user input */
		submitInfoButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    	
		  }

		});


		/* Add functionality - Return to Button options interface */
		returnButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	outerPanel.addPatientButtonOptions();
		  }

		});


	} // end addActionListeners()


} // end Patient_Record_Lookup class