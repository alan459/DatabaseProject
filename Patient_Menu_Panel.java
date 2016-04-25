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

		//setLayout(new GridLayout(2, 1));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		add(current_panel = new Patient_Button_Options());

		// skip a row in the grid layout
		//add(new JLabel(""));

		add(main_menu_button = new Main_Menu_Button(main_frame));


	}

	/*********************************************************************************
	* Constructor used for setting up the Patient_Menu_Panel.
	*********************************************************************************
	public Patient_Menu_Panel() 
	{
		setLayout(new GridLayout(2, 2));

		// skip a row in the grid layout
		//add(new JLabel(""));

		//main_menu_button = new Main_Menu_Button(main_frame);

	}*/

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
				super("Modify Patient Info");

				addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changeCurrentPanel(new Modify_Patient_Info_Panel());
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
						//changeCurrentPanel(new Search_Records_Patients_Panel());
					}
				});
			}

		}

	} // end Patient_Button_Options class













	/********************************************************************************************************
	* Displayed when the user selects 'modify' in the Patient_Menu_Panel.
	********************************************************************************************************/
	private class Modify_Patient_Info_Panel extends JPanel
	{

		/*******************************************************************************************
		* Main constructor for the Patient_Button_Options class.
		*******************************************************************************************/	
		public Modify_Patient_Info_Panel()
		{
			setLayout(new GridBagLayout());

			add(new Back_Button());

			add(new Select_Attribute_Panel());
			
		}



		/*******************************************************************************************
		* Displayed after modify clicked on the Modify_Patient_Info_Panel in the Patient_Menu_Panel. 
		*******************************************************************************************/
		private class Select_Attribute_Panel extends JPanel
		{

			/******************************************************************************
			* Main constructor for Select_Attribute_Panel.
			******************************************************************************/
			public Select_Attribute_Panel()
			{
				add(new JLabel("Modify:"));

				add(new Age_Button());
				add(new Room_Building_Button());
			}




			/******************************************************************************
			* Button in the Modify_Patient_Info_Panel to take the user to the 
			* Age_Modificaton_Panel when pressed.
			******************************************************************************/
			private class Age_Button extends JButton
			{
				/******************************************************************
				* Main constructor for Age_Button.
				******************************************************************/
				public Age_Button()
				{
					super("Age");

					addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							changeCurrentPanel(new Age_Modificaton_Panel());
						}

					});

				}

			} // end Age_Button Class





			/******************************************************************************
			* Button in the Modify_Patient_Info_Panel to take the user to the 
			* Room_Building_Modification_Panel when pressed.
			******************************************************************************/
			private class Room_Building_Button extends JButton
			{
				/******************************************************************
				* Main constructor for Room_Building_Button.
				******************************************************************/	
				public Room_Building_Button()
				{
					super("Room/Building");

					addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							changeCurrentPanel(new Room_Building_Modification_Panel());
						}
					});
				}

			} // end Room_Building_Button Class




		} // end Select_Attribute_Panel Class










		/*******************************************************************************************
		* Panel displayed when user selects to modify a patient's age in the Select_Attribute_Panel.
		*******************************************************************************************/
		private class Age_Modificaton_Panel extends JPanel
		{
			private JTextField age_field, ssn_field;

			private int age;

			private String ssn;


			/******************************************************************************
			* Main constructor for Age_Modificaton_Panel.
			******************************************************************************/
			public Age_Modificaton_Panel()
			{
				setLayout(new GridBagLayout());

				add(new Back_Button());

				add(new JLabel("   Change Age To "));

				add(age_field = new JTextField(2));

				add(new JLabel(" for patient with SSN "));

				add(ssn_field = new JTextField(7));

				add(new Submit_Button());
			}



			/******************************************************************************
			* Submit button for Age_Modificaton_Panel class.
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

							// pass input into patient instance to modify tuple
						}
					});
				}



				/******************************************************************
				* Load input from age and ssn fields into corresponding int and 
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

					// get age from field
					try
					{
						age = Integer.parseInt(age_field.getText());
					} 
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(new JPanel(), "Age input invalid", "Error", JOptionPane.ERROR_MESSAGE);
						return false;	
					}

					// if this point is reached age and ssn were successfully retrieved
					return true;
				}


			} // end Submit_Button class


		} // end Age_Modificaton_Panel class













		/*******************************************************************************************
		* Panel displayed when user selects to modify a patient's room/building in the 
		* Select_Attribute_Panel.
		*******************************************************************************************/
		private class Room_Building_Modification_Panel extends JPanel
		{
			private JTextField room_field, ssn_field;

			private String room, ssn;

			public Room_Building_Modification_Panel()
			{
				setLayout(new GridBagLayout());

				add(new Back_Button());
				/*add(new JLabel(""));
				add(new JLabel(""));
				add(new JLabel(""));
*/
				add(new JLabel("     Change Room To "));

				add(room_field = new JTextField(4));

				add(new JLabel(" for patient with SSN "));

				add(ssn_field = new JTextField(7));

				add(new Submit_Button());
			}


			/******************************************************************************
			* Submit button for Room_Building_Modification_Panel class.
			******************************************************************************/
			private class Submit_Button extends JButton
			{
				/******************************************************************
				* Main constructor for Submit_Button
				******************************************************************/
				public Submit_Button()
				{
					super("Submit");

					addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							loadText();

							// pass input into patient instance to modify tuple
						}
					});
				}

				/******************************************************************
				* Load input from age and ssn fields into corresponding int and 
				* string variables.
				*
				* If load is successful, true is returned, otherwise false
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
						JOptionPane.showMessageDialog(new JPanel(), "SSN input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
						return false;	
					}

					// get age from field
					try
					{
						room = room_field.getText();
					} 
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(new JPanel(), "Room input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
						return false;	
					}

					// if this point is reached age and ssn were successfully retrieved
					return true;

				}

			} // end Submit_Button class


		} // end Room_Building_Modification_Panel class


	} // end Modify_Patient_Info_Panel class










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
