//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A Doctor menu to display to the user 2 panels, 1 for looking up a Doctor on the left side of the 
* window, and a 2nd on the right side which is selected from x options from buttons.
*****************************************************************************************************/
public class Doctor_Menu_Panel extends JPanel 
{

	/* Pointer to the main java window to access its get() methods for other panels */
	private Hospital_Frame hospital_frame;

	/* BUTTON to return the screen to the MAIN MENU */
	private JButton main_menu_button;	

	/* Main LABELS for displaying the options on this panel - largest text blocks, above
	*  each inner panel */
	private JLabel doctor_lookup_label, record_lookup_label;

	/* LEFT SIDE interface displayed to the user to lookup a Doctor */
	private JPanel left_side_panel;

	/* RIGHT SIDE interface displayed to the user, displaying either button options or
	*  an interface based on button pressed */
	private JPanel right_side_panel;




	/*********************************************************************************
	* Main constructor used for setting up the Doctor_Menu_Panel.
	*********************************************************************************/
	public Doctor_Menu_Panel ( Hospital_Frame  frame ) 
	{
		this.hospital_frame = frame;

		setLayout(new GridBagLayout());
		initializeButtons();
		initializeLabels();
		addActionListeners();

		add(main_menu_button);

		//add(doctor_lookup_label);
		add(left_side_panel = new Doctor_Lookup_Panel());
		//setLayout(new FlowLayout());

		//add(record_lookup_label);
		add(right_side_panel = new Doctor_Button_Options(this)); 
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		


	}



	/*********************************************************************************
	* Initializes the buttons for Doctor_Menu_Panel.
	*********************************************************************************/
	private void initializeButtons()
	{
		main_menu_button = new JButton("Main Menu");
	}



	/*********************************************************************************
	* Initializes the buttons for Doctor_Menu_Panel.
	*********************************************************************************/
	private void initializeLabels()
	{
		doctor_lookup_label = new JLabel("Doctor Lookup");
		record_lookup_label = new JLabel("Record Lookup");
	}



	/*********************************************************************************
	* Adds the action listeners for Doctor_Menu_Panel.
	*********************************************************************************/
	private void addActionListeners()
	{
		/* Add functionality - Return user to main menu */
		main_menu_button.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	hospital_frame.getMainMenu();
		  }
		});

	} // end addActionListeners()



	/*********************************************************************************
	* Removes any panel displayed on the right side of the Doctor menu window and
	* adds 2 buttons options:
	*
	* ['DOCTOR RECORD LOOKUP','MODIFY DOCTOR INFO']
	*
	* Switches right_side_panel to an instance of Interface_Option_Buttons.
	*********************************************************************************/
	public void addDoctorButtonOptions()
	{
		//if(right_side_panel != null)
		{
			remove(right_side_panel);
		}

		add(right_side_panel = new Doctor_Button_Options(this));
		revalidate();
		repaint();
	}



	/*********************************************************************************
	* Replaces the button interface with a Doctor lookup interface when the 
	* 'DOCTOR RECORD LOOKUP' button is pressed in the button interface. 
	*
	* Switches right_side_panel from Interface_Option_Buttons to Doctor_Lookup_Panel.
	*********************************************************************************/
	public void addDoctorRecordLookup()
	{
		remove(right_side_panel);
		add(right_side_panel = new Doctor_Record_Lookup(this));
		revalidate();
		repaint();
	}



	/*********************************************************************************
	* Replaces the button interface with a Doctor lookup interface when the 
	* 'MODIFY DOCTOR INFO' button is pressed in the button interface. 
	*
	* Switches right_side_panel from Doctor_Button_Options to Modify_Doctor_Info_Panel.
	*********************************************************************************/
	public void addModifyDoctorInfo()
	{
		remove(right_side_panel);
		add(right_side_panel = new Modify_Doctor_Info_Panel(this));
		revalidate();
		repaint();
	}

	//public static void main(String[] args)
	{}


} // end Doctor menu class