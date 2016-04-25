import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/*****************************************************************************************************
* A Doctor menu to display to the user 2 panels, 1 for looking up a Doctor on the left side of the 
* window, and a 2nd on the right side which is selected from 3 options from buttons for updating 
* Doctor info, Doctor record lookup, and modify treatment plan.
*****************************************************************************************************/
public class Doctor_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	protected Hospital_Frame main_frame;

	/* Button to return the screen to the main menu */
	protected JPanel main_menu_button;	

	/* Current interface displayed to the user, displaying either button options or an interface based 
	* on button pressed */
	protected JPanel current_panel;



	/*********************************************************************************
	* Main constructor used for setting up the Doctor_Menu_Panel.
	*********************************************************************************/
	public Doctor_Menu_Panel(Hospital_Frame main) 
	{
		this.main_frame = main;

		//setLayout(new GridLayout(2, 1));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		add(current_panel = new Doctor_Button_Options());

		// skip a row in the grid layout
		//add(new JLabel(""));

		add(main_menu_button = new Main_Menu_Button(main_frame));


	}




	/*********************************************************************************
	* Switches the current main panel to the passed in one.
	*********************************************************************************/
	protected void changeCurrentPanel(JPanel panel)
	{
		// get rid of all components currently on the main_screen
		removeAll();

		add(current_panel = panel);

		// re-add the main menu button so it appears after the panel again
		add(main_menu_button = new Main_Menu_Button(main_frame));

		revalidate();
		repaint();

	} // end changeCurrentPanel()







	/*********************************************************************************
	* Different button options for the user for interacting with the Doctor tuples
	* in the database.
	*********************************************************************************/
	protected class Doctor_Button_Options extends JPanel
	{
		/*********************************************************************************
		* Main constructor for the Doctor_Button_Options class.
		*********************************************************************************/	
		public Doctor_Button_Options()
		{
			setLayout(new GridBagLayout());

			add(new Search_Doctors_Button());
			add(new Search_Records_Doctors_Button());
		}



		/*********************************************************************************
		* Button to take user to search Doctors panel by switching the current panel
		* to an instance of Search_Doctors_Panel.
		*********************************************************************************/
		private class Search_Doctors_Button extends JButton
		{
			public Search_Doctors_Button()
			{
				super("Search Doctors");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Doctor_Lookup_Panel());
					}
				});
			}

		}



		/*********************************************************************************
		* Button to take user to search Doctors panel by switching the current panel
		* to an instance of Search_Records_Doctors_Panel.
		*********************************************************************************/
		private class Search_Records_Doctors_Button extends JButton
		{
			/******************************************************************
			* Main constructor for Search_Records_Doctors_Button.
			******************************************************************/
			public Search_Records_Doctors_Button()
			{
				super("Search Records for a Doctor");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Doctor_Record_Lookup_Panel());
					}
				});
			}

		}

	} // end Doctor_Button_Options class










	/*********************************************************************************
	* Returns the user to the Doctor menu.
	*********************************************************************************/
	private class Back_Button extends JButton
	{
		/******************************************************************
		* Main constructor for Back_Button.
		******************************************************************/
		public Back_Button()
		{
			super("<- Back");

			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Doctor_Button_Options());
					//main_frame.changeScreen(new Doctor_Menu_Panel(main_frame));
				}
			});

		}

	} // end Back_Button class




} // end Doctor menu class
