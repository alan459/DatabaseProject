import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A Nurse menu to display to the user 3 options, modify, lookup, record lookup. Each button takes you
* to a different panel, the modify panel is an inner class in this file, the other 2 are seperate files
* named Nurse_Lookup_Panel and Nurse_Record_Lookup_Panel.
*****************************************************************************************************/
public class Nurse_Menu_Panel extends JPanel 
{
	/* Pointer to the main java window to access its get() methods for other panels */
	protected Hospital_Frame main_frame;

	/* Button to return the screen to the main menu */
	protected JPanel main_menu_button;	

	/* Current interface displayed to the user, displaying either button options or an interface based 
	* on button pressed */
	protected JPanel current_panel;



	/*********************************************************************************
	* Main constructor used for setting up the Nurse_Menu_Panel.
	*********************************************************************************/
	public Nurse_Menu_Panel(Hospital_Frame main) 
	{
		this.main_frame = main;

		//setLayout(new GridLayout(2, 1));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		add(current_panel = new Nurse_Button_Options());

		// skip a row in the grid layout
		//add(new JLabel(""));

		add(main_menu_button = new Main_Menu_Button(main_frame));


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
	* Different button options for the user for interacting with the Nurse tuples
	* in the database.
	*********************************************************************************/
	protected class Nurse_Button_Options extends JPanel
	{
		/*********************************************************************************
		* Main constructor for the Nurse_Button_Options class.
		*********************************************************************************/	
		public Nurse_Button_Options()
		{
			setLayout(new GridBagLayout());

			add(new Modify_Nurse_Info_Button());
			add(new Search_Nurses_Button());
			add(new Search_Records_Nurses_Button());
		}


		/*********************************************************************************
		* Button to take user to modify Nurse info panel by switching the current panel
		* to an instance of Modify_Nurse_Info_Panel (to be created).
		*********************************************************************************/
		private class Modify_Nurse_Info_Button extends JButton
		{
			public Modify_Nurse_Info_Button()
			{
				super("Modify Nurse Info");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Modify_Nurse_Info_Panel());
					}
				});
			}

		}
			

		/*********************************************************************************
		* Button to take user to search Nurses panel by switching the current panel
		* to an instance of Search_Nurses_Panel.
		*********************************************************************************/
		private class Search_Nurses_Button extends JButton
		{
			public Search_Nurses_Button()
			{
				super("Search Nurses");

				addActionListener(new ActionListener()
				{
								public void actionPerformed(ActionEvent e)
		{
						changeCurrentPanel(new Nurse_Lookup_Panel());
					}
				});
			}

		}

		/*********************************************************************************
		* Button to take user to search Nurses panel by switching the current panel
		* to an instance of Search_Records_Nurses_Panel.
		*********************************************************************************/
		private class Search_Records_Nurses_Button extends JButton
		{
			public Search_Records_Nurses_Button()
			{
				super("Search Records for a Nurse");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Nurse_Record_Lookup_Panel());
					}
				});
			}

		}

	} // end Nurse_Button_Options class













	/********************************************************************************************************
	* Displayed when the user selects 'modify' in the Nurse_Menu_Panel.
	********************************************************************************************************/
	private class Modify_Nurse_Info_Panel extends JPanel
	{

		/*******************************************************************************************
		* Main constructor for the Nurse_Button_Options class.
		*******************************************************************************************/	
		public Modify_Nurse_Info_Panel()
		{
			setLayout(new GridBagLayout());

			add(new Back_Button());

			add(new Select_Attribute_Panel());
			
		}



		/*******************************************************************************************
		* Displayed after modify clicked on the Modify_Nurse_Info_Panel in the Nurse_Menu_Panel. 
		*******************************************************************************************/
		private class Select_Attribute_Panel extends JPanel
		{

			/******************************************************************************
			* Main constructor for Select_Attribute_Panel.
			******************************************************************************/
			public Select_Attribute_Panel()
			{
				add(new JLabel("Modify : "));

				add(new Supervisor_Button());
			}




			/******************************************************************************
			* Button in the Modify_Nurse_Info_Panel to take the user to the 
			* Supervisor_Modificaton_Panel when pressed.
			******************************************************************************/
			private class Supervisor_Button extends JButton
			{
				/******************************************************************
				* Main constructor for Supervisor_Button.
				******************************************************************/
				public Supervisor_Button()
				{
					super("Supervisor");

					addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							changeCurrentPanel(new Supervisor_Modificaton_Panel());
						}

					});

				}

			} // end Supervisor_Button Class



		} // end Select_Attribute_Panel Class










		/*******************************************************************************************
		* Panel displayed when user selects to modify a Nurse's age in the Select_Attribute_Panel.
		*******************************************************************************************/
		private class Supervisor_Modificaton_Panel extends JPanel
		{
			private JTextField supervisor_field, ssn_field;

			private String ssn, supervisor;


			/******************************************************************************
			* Main constructor for Supervisor_Modificaton_Panel.
			******************************************************************************/
			public Supervisor_Modificaton_Panel()
			{
				setLayout(new GridBagLayout());

				add(new Back_Button());

				add(new JLabel("   Change Supervisor To "));

				add(supervisor_field = new JTextField(10));

				add(new JLabel(" for Nurse with SSN "));

				add(ssn_field = new JTextField(7));

				add(new Submit_Button());
			}



			/******************************************************************************
			* Submit button for Supervisor_Modificaton_Panel class.
			******************************************************************************/
			private class Submit_Button extends JButton
			{

				/******************************************************************
				* Main construcot for Submit_Button.
				******************************************************************/
				public Submit_Button()
				{
					super("Submit");

					addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							loadText();

							String input = ssn + supervisor;
							// pass input into Nurse instance to modify tuple
						}
					});
				}



				/******************************************************************
				* Load input from supervisor and ssn fields into corresponding int and 
				* string variables.
				*
				* If load is successful, true is returned, otherwise, false
				* is returned.
				******************************************************************/
				private boolean loadText()
				{
					// get ssn from field
					try
					{
						ssn = ssn_field.getText();
					} 
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(new JPanel(), "SSN input invalid", "Error", JOptionPane.ERROR_MESSAGE);
						return false;	
					}

					// get supervisor from field
					try
					{
						supervisor = supervisor_field.getText();
					} 
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(new JPanel(), "Supervisor input invalid", "Error", JOptionPane.ERROR_MESSAGE);
						return false;	
					}

					// if this point is reached supervisor and ssn were successfully retrieved
					return true;
				}


			} // end Submit_Button class


		} // end Supervisor_Modificaton_Panel class


	} // end Modify_Nurse_Info_Panel class










	/*********************************************************************************
	* Returns the user to the Nurse menu.
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
					changeCurrentPanel(new Nurse_Button_Options());
					//main_frame.changeScreen(new Nurse_Menu_Panel(main_frame));
				}
			});
		}

	} // end Back_Button class




} // end Nurse menu class
