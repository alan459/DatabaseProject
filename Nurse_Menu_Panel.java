//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A nurse menu to display to the user 2 panels, 1 for looking up a nurse on the left side of the 
* window, and a 2nd on the right side which is selected from x options from buttons.
*****************************************************************************************************/
public class Nurse_Menu_Panel extends JPanel 
{

	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame HOSPITAL_FRAME;

	/* BUTTON to return the screen to the MAIN MENU */
	private JButton MAIN_MENU_BUTTON;	

	/* Main LABELS for displaying the options on this panel - largest text blocks, above
	*  each inner panel */
	private JLabel NURSE_LOOKUP_LABEL, RECORD_LOOKUP_LABEL;

	/* LEFT SIDE interface displayed to the user to lookup a nurse */
	private JPanel left_side_panel;

	/* RIGHT SIDE interface displayed to the user, displaying either button options or
	*  an interface based on button pressed */
	private JPanel right_side_panel;




	/*********************************************************************************
	* Main constructor used for setting up the Nurse_Menu_Panel.
	*********************************************************************************/
	public Nurse_Menu_Panel ( Hospital_Frame  frame ) 
	{
		this.HOSPITAL_FRAME = frame;

		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initializeButtons();
		initializeLabels();
		addActionListeners();

		//JPanel pan = new JPanel();
		//pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		//add(NURSE_LOOKUP_LABEL);
		add(left_side_panel = new Nurse_Lookup_Panel());
		//setLayout(new FlowLayout());
		//addButtonOptions();
		//add(pan);


		//add(RECORD_LOOKUP_LABEL);
		add(right_side_panel = new Nurse_Option_Buttons(this)); 
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(MAIN_MENU_BUTTON);


	}



	/*********************************************************************************
	* Initializes the buttons for Nurse_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		MAIN_MENU_BUTTON = new JButton("Main Menu");
	}



	/*********************************************************************************
	* Initializes the buttons for Nurse_Menu_Panel.
	*********************************************************************************/
	private void initializeLabels()
	{
		NURSE_LOOKUP_LABEL = new JLabel("Nurse Lookup");
		RECORD_LOOKUP_LABEL = new JLabel("Record Lookup");
	}



	/*********************************************************************************
	* Adds the action listeners for Nurse_Menu_Panel.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Return user to main menu */
		MAIN_MENU_BUTTON.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	HOSPITAL_FRAME.getMainMenu();
		  }
		});

	} // end addActionListeners()



	/*********************************************************************************
	* Removes any panel displayed on the right side of the nurse menu window and
	* adds 3 buttons options:
	*
	* ['UPDATE nurse INFO', 'nurse RECORD LOOKUP','MODIFY TREATMENT PLAN']
	*
	* Switches right_side_panel to an instance of Interface_Option_Buttons.
	*********************************************************************************/
	public void addNurseButtonOptions()
	{
		//if(right_side_panel != null)
		{
			remove(right_side_panel);
		}

		add(right_side_panel = new Nurse_Option_Buttons(this));
		revalidate();
		repaint();
	}



	/*********************************************************************************
	* Replaces the button interface with a nurse lookup interface when the 
	* 'nurse RECORD LOOKUP' button is pressed in the button interface. 
	*
	* Switches right_side_panel from Interface_Option_Buttons to nurse_Lookup_Panel.
	*********************************************************************************/
	public void addNurseRecordLookup()
	{
		remove(right_side_panel);
		add(right_side_panel = new Nurse_Record_Lookup(this));
		revalidate();
		repaint();
	}







} // end nurse menu class