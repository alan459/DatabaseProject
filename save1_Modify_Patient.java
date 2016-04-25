import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/********************************************************************************************************
* Displayed when the user selects 'modify' in the Patient_Menu_Panel.
********************************************************************************************************/
private class save1_Modify_Patient extends Patient_Menu_Panel
{
	/*******************************************************************************************
	* Main constructor for the Patient_Button_Options class.
	*******************************************************************************************/	
	public Modify_Patient()
	{
		add(new Back_Button());

		add(current_panel = new Select_Attribute_Panel());
		
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
			add(new JLabel("Change Age To "));

			add(age_field = new JTextField(2));

			add(new JLabel("for patient with SSN "));

			add(ssn_field = new JTextField(6));

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
					JOptionPane.showMessageDialog(new JPanel(), "SSN input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
					return false;	
				}

				// get age from field
				try
				{
					age = Integer.parseInt(age_field.getText());
				} 
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(new JPanel(), "Age input could not be read", "Error", JOptionPane.ERROR_MESSAGE);
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
			add(new JLabel("Change Age To "));

			add(room_field = new JTextField(2));

			add(new JLabel("for patient with SSN "));

			add(ssn_field = new JTextField(6));

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




	/*********************************************************************************
	* Returns the user to the main Procedure menu
	*********************************************************************************/
	private class Back_Button extends JButton
	{
		public Back_Button()
		{
			super("<- Back");

			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(current_panel == null)
						System.out.println("NULLLLLL");
					else
						System.out.println("NOT     NULLLLLL");
					changeCurrentPanel(new Patient_Button_Options());
					//main_frame.changeScreen(new Patient_Menu_Panel(main_frame));
				}
			});
		}
	}


} // end Modify_Patient_Info_Panel class
