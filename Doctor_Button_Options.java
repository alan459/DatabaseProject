//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*********************************************************************************
* INNER JPanel to be used as a display of the button options for the user 
* on the right side of the window to select an interface.
*********************************************************************************/
public class Doctor_Button_Options extends JPanel
{
	private Doctor_Menu_Panel outerPanel;

	/* Input submission buttons */
	private JButton record_lookup_button, modify_doctor_info_button;



	/*********************************************************************************
	* Main constructor for the Doctor_Button_Options class used for setting up 
	* the interface menu options.
	*********************************************************************************/
	public Doctor_Button_Options(Doctor_Menu_Panel outer)
	{
		this.outerPanel = outer;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		initializeButtons();
		addActionListeners();

		// add the components to the panel
		add(record_lookup_button);
		add(modify_doctor_info_button);
	}



	/*********************************************************************************
	* Initializes the buttons for Doctor_Button_Options.
	*********************************************************************************/
	private void initializeButtons()
	{
		record_lookup_button = new JButton("DOCTOR RECORD LOOKUP");
		modify_doctor_info_button = new JButton("MODIFY DOCTOR INFO");
	}



	/*********************************************************************************
	* Adds the action listeners for Doctor_Button_Options.
	*********************************************************************************/
	private void addActionListeners()
	{

		/* Add functionality to button'PATIENT RECORD LOOKUP' - Display to user the patient record lookup interface */
		record_lookup_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				outerPanel.addDoctorRecordLookup();
			}
		});

		/* Add functionality - Take user to modofy treatment plan interface */
		modify_doctor_info_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				outerPanel.addModifyDoctorInfo();
			}
		});

	} // end addActionListeners()


} // end Doctor_Button_Options class