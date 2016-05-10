import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A Patient menu to display to the user 3 options, modify, lookup, record lookup. Each button takes you
* to a different panel, the modify panel is an inner class in this file, the other 2 are seperate files
* named Patient_Lookup_Panel and Patient_Record_Lookup_Panel.
*****************************************************************************************************/
public class Patient_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	protected Hospital_Frame main_frame;

	/* Button to return the screen to the main menu */
	protected JPanel main_menu_button;	

	/* Current interface displayed to the user, displaying either button options or an interface based 
	* on button pressed */
	protected JPanel current_panel;



	/*********************************************************************************
	* Main constructor used for setting up the Patient_Menu_Panel.
	*********************************************************************************/
	public Patient_Menu_Panel(Hospital_Frame main) 
	{
		this.main_frame = main;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
                
                
		add(current_panel = new Patient_Button_Options());
                add(main_menu_button = new Main_Menu_Button(main_frame));

		// skip a row in the grid layout
		//add(new JLabel(""));

		
	}

	/*********************************************************************************
	* Switches the current main panel to the passed in one.
	*********************************************************************************/
	protected void changeCurrentPanel(JPanel panel)
	{
		removeAll();

		add(current_panel = panel);

		// re-add the main menu button so it appears after the panel again
		add(main_menu_button = new Main_Menu_Button(main_frame));

		revalidate();
		repaint();

	} // end changeCurrentPanel()







	/*********************************************************************************
	* Different button options for the user for interacting with the patient tuples
	* in the database.
	*********************************************************************************/
	protected class Patient_Button_Options extends JPanel
	{
		/*********************************************************************************
		* Main constructor for the Patient_Button_Options class.
		*********************************************************************************/	
		public Patient_Button_Options()
		{
			setLayout(new GridBagLayout());

			add(new Modify_Patient_Info_Button());
			add(new Search_Patients_Button());
			add(new Search_Records_Patients_Button());
		}


		/*********************************************************************************
		* Button to take user to modify patient info panel by switching the current panel
		* to an instance of Modify_Patient_Info_Panel (to be created).
		*********************************************************************************/
		private class Modify_Patient_Info_Button extends JButton
		{
			public Modify_Patient_Info_Button()
			{
				super("Modify Patient Record Info");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Modify_Record_Menu_Panel());
					}
				});
			}

		}
			

		/*********************************************************************************
		* Button to take user to search patients panel by switching the current panel
		* to an instance of Search_Patients_Panel.
		*********************************************************************************/
		private class Search_Patients_Button extends JButton
		{
			public Search_Patients_Button()
			{
				super("Search Patients");

				addActionListener(new ActionListener()
				{
								public void actionPerformed(ActionEvent e)
		{
						changeCurrentPanel(new Patient_Lookup_Panel());
					}
				});
			}

		}

		/*********************************************************************************
		* Button to take user to search patients panel by switching the current panel
		* to an instance of Search_Records_Patients_Panel.
		*********************************************************************************/
		private class Search_Records_Patients_Button extends JButton
		{
			public Search_Records_Patients_Button()
			{
				super("Search Records for a Patient");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Patient_Record_Lookup_Panel());
					}
				});
			}

		}

	} // end Patient_Button_Options class







	/*********************************************************************************
	* Returns the user to the Patient menu.
	*********************************************************************************/
	private class Back_Button extends JButton
	{
		/******************************************************************
		* Main constructor for Back_Button
		******************************************************************/
		public Back_Button()
		{
			super("<- Back");

			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					changeCurrentPanel(new Patient_Button_Options());
					//main_frame.changeScreen(new Patient_Menu_Panel(main_frame));
				}
			});
		}

	} // end Back_Button class




} // end patient menu class
