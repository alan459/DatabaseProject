import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/****************************************************************************************************************
* An interactive interface to interact with a hospital database.
****************************************************************************************************************/
public class Hospital_Frame extends JFrame 
{
	public static final int WIDTH = 850;
	public static final int HEIGHT = 600;

	private JPanel currentScreen;


	/*****************************************************************************************************
	* Main constructor to initialize the frame.
	*****************************************************************************************************/
	public Hospital_Frame() 
	{
		setTitle("Hospital");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	// center the window
		
		createMainWindow();

		setVisible(true);
	}



	/*****************************************************************************************************
	* Creates a jpanel with the frame displaying the main menu options and sets it as the main screen.
	*****************************************************************************************************/
	public void createMainWindow()
	{
		add(currentScreen = new Main_Menu_Panel());
	}



	/*****************************************************************************************************
	* Fetches the data in the data fields and returns them in a tab-delimited string.
	* (and checks for correct formatting?)
	*****************************************************************************************************/
	public String getDataFields() 
	{
		return "";
	}



	/*****************************************************************************************************
	* Gets and returns the selected relation in the drop down menu
	*****************************************************************************************************/
	public String getDataType() 
	{
		return "";
	}



	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the main menu.
	*****************************************************************************************************/
	public void getMainMenu()
	{
		remove(currentScreen);

		add(currentScreen = new Main_Menu_Panel()); 

		revalidate();

		repaint();
	}



	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the patient menu.
	*****************************************************************************************************/
	public void getPatientMenu()
	{	
		//setSize(WIDTH + 150, HEIGHT + 150);
		//setLocationRelativeTo(null);	// center the window
		remove(currentScreen);
		add(currentScreen = new Patient_Menu_Panel()); 

		revalidate();
		repaint();
	}



	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the patient menu.
	*
	* [This method should probably moved to the Patient_Menu_Panel and modified since it is expected to be
	* used as an inner panel].
	*****************************************************************************************************/
	public void getPatientLookupMenu()
	{
		remove(currentScreen);
		add(currentScreen = new Patient_Lookup_Panel()); 

		revalidate();
		repaint();
	}



	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the doctor menu.
	*****************************************************************************************************/
	public void getDoctorMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();

		repaint();
	}



	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the nurse menu.
	*****************************************************************************************************/
	public void getNurseMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();

		repaint();
	}



	/*****************************************************************************************************
	* Main method to start/run the program.
	*****************************************************************************************************/
	public static void main(String[] args)
	{
		Hospital_Frame frame = new Hospital_Frame();
	}










	/*****************************************************************************************************
	* Represents an instance of a main menu to display on the JFrame.
	*****************************************************************************************************/
	private class Main_Menu_Panel extends JPanel 
	{
		/* Buttons to select which type of entity the user is interested in */
		private JButton patientButton, doctorButton, nurseButton;

		/* Displays to the user some information as to where clicking the buttons will take them */
		private JLabel recordSearchLabel;



		/*********************************************************************************
		* Main constructor used when creating a main menu.
		*********************************************************************************/
		public Main_Menu_Panel() 
		{
			intializeLabels();

			initializeButtons();

			addActionListeners();

			add(recordSearchLabel);
			add(patientButton);
			add(doctorButton);
			add(nurseButton);

		}



		/*********************************************************************************
		* Initialize the labels for the main menu.
		*********************************************************************************/
		private void intializeLabels()
		{
			recordSearchLabel = new JLabel("Record Search");
		}



		/*********************************************************************************
		* Initialize the buttons for the main menu.
		*********************************************************************************/
		private void initializeButtons()
		{
			patientButton = new JButton("Patient");
			doctorButton = new JButton("Doctor");
			nurseButton = new JButton("Nurse");
		}


		
		/*********************************************************************************
		* Adds the action listeners for the main menu.
		*********************************************************************************/
		private void addActionListeners()
		{
			patientButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    getPatientMenu();			    
			  }
			});

			doctorButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    //getPatientMenu();			    
			  }
			});

			nurseButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    //getPatientMenu();			    
			  }
			});
		}



	} // end main menu class











	/*****************************************************************************************************
	* A patient menu to display to the user 2 panels, 1 for looking up a patient on the left side of the 
	* window, and a 2nd on the right side which is selected from 3 options from buttons for updating 
	* patient info, patient record lookup, and modify treatment plan.
	*****************************************************************************************************/
	private class Patient_Menu_Panel extends JPanel 
	{
		/* Button to return the screen to the main menu */
		private JButton mainMenuButton;	

		/* Main labels for the options on this screen - largest text blocks - put above each inner panel */
		private JLabel patientLookupLabel, recordLookupLabel;

		/* Left side interface displayed to the user to lookup a patient */
		private JPanel patientLookup;

		/* Right side interface displayed to the user, displaying either button options or
		* an interface based on button pressed */
		private JPanel currentInterface;



		/*********************************************************************************
		* Main constructor used for setting up the Patient_Menu_Panel.
		*********************************************************************************/
		public Patient_Menu_Panel() 
		{
			//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			initializeButtons();
			initializeLabels();
			addActionListeners();

			//JPanel pan = new JPanel();
			//pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
			//add(patientLookupLabel);
			add(new Patient_Lookup_Panel());
			//setLayout(new FlowLayout());
			//addButtonOptions();
			//add(pan);


			//add(recordLookupLabel);
			add(currentInterface = new Interface_Option_Buttons()); 
			//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			add(mainMenuButton);


		}



		/*********************************************************************************
		* Initializes the buttons for Patient_Menu_Panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			mainMenuButton = new JButton("Main Menu");
		}



		/*********************************************************************************
		* Initializes the buttons for Patient_Menu_Panel.
		*********************************************************************************/
		private void initializeLabels()
		{
			patientLookupLabel = new JLabel("Patient Lookup");
			recordLookupLabel = new JLabel("Record Lookup");
		}



		/*********************************************************************************
		* Adds the action listeners for Patient_Menu_Panel.
		*********************************************************************************/
		private void addActionListeners()
		{
			/* Add functionality - Return user to main menu */
			mainMenuButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	getMainMenu();
			  }
			});

		} // end addActionListeners()



		/*********************************************************************************
		* Removes any panel displayed on the right side of the patient menu window and
		* adds 3 buttons options:
		*
		* ['UPDATE PATIENT INFO', 'PATIENT RECORD LOOKUP','MODIFY TREATMENT PLAN']
		*
		* Switches currentInterface to an instance of Interface_Option_Buttons.
		*********************************************************************************/
		private void addButtonOptions()
		{
			if(currentInterface != null)
			{
				remove(currentInterface);
			}

			add(currentInterface = new Interface_Option_Buttons());
			revalidate();
			repaint();
		}



		/*********************************************************************************
		* Replaces the button interface with a patient lookup interface when the 
		* 'PATIENT RECORD LOOKUP' button is pressed in the button interface. 
		*
		* Switches currentInterface from Interface_Option_Buttons to Patient_Lookup_Panel.
		*********************************************************************************/
		private void addPatientRecordLookup()
		{
			remove(currentInterface);
			add(currentInterface = new Patient_Record_Lookup());
			revalidate();
			repaint();
		}




		/*********************************************************************************
		* INNER JPanel to be used as a display of the button options for the user 
		* on the right side of the window to select an interface.
		*********************************************************************************/
		private class Interface_Option_Buttons extends JPanel
		{
			/* Input submission buttons */
			private JButton updateInfoButton, recordLookupButton, modifyTreatmentButton;



			/*********************************************************************************
			* Main constructor for the Interface_Option_Buttons class used for setting up 
			* the interface menu options.
			*********************************************************************************/
			public Interface_Option_Buttons()
			{
				setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
				initializeButtons();
				addActionListeners();

				// add the components to the panel
				add(updateInfoButton);
				add(recordLookupButton);
				add(modifyTreatmentButton);
			}


			/*********************************************************************************
			* Initializes the buttons for Interface_Option_Buttons.
			*********************************************************************************/
			private void initializeButtons()
			{
				updateInfoButton = new JButton("UPDATE PATIENT INFO");
				recordLookupButton = new JButton("PATIENT RECORD LOOKUP");
				modifyTreatmentButton = new JButton("MODIFY TREATMENT PLAN");
			}



			/*********************************************************************************
			* Adds the action listeners for Interface_Option_Buttons.
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
				  	addPatientRecordLookup();
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


		} // end Interface_Option_Buttons class





		/*********************************************************************************
		* 1 of the 3 INNER JPanels that result from a button being clicked in the button
		* interface to display the patient record lookup interface on the right side of 
		* the window after the "Patient Record Lookup" button is pressed.
		*********************************************************************************/
		private class Patient_Record_Lookup extends JPanel
		{
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
			public Patient_Record_Lookup()
			{
				setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
				initializeButtons();
				initializeLabels();

				addActionListeners();


				// add the components to the panel
				add(lookupLabel);
				add(ssnLabel);
				add(resultsLabel);

				add(submitInfoButton);
				add(returnButton);
			}


			/*********************************************************************************
			* Initializes the buttons for the patient menu.
			*********************************************************************************/
			private void initializeLabels()
			{
				submitInfoButton = new JButton("submit");

				returnButton = new JButton("return to options");
			}



			/*********************************************************************************
			* Initializes the buttons for the patient menu.
			*********************************************************************************/
			private void initializeButtons()
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
				  	addButtonOptions();
				  }
				});


			} // end addActionListeners()


		} // end Patient_Record_Lookup class


	} // end patient menu class











	/*****************************************************************************************************
	* To be used as an INNER panel part of a larger panel containing all the options for the user:
	* A display for the user to lookup patients in the database.
	*****************************************************************************************************/
	private class Patient_Lookup_Panel extends JPanel 
	{
		/* Input submission buttons */
		private JButton ssnLookupButton, infoLookupButton; //, recordLookupButton;		

		/* Display to the user what type of information is being displayed in the adjacent position */
		private JLabel enterSSNLabel, enterFirstNameLabel, enterLastNameLabel, enterDOBLabel, patientLookupLabel;	

		/* Labels for displaying output data */
		private JLabel patientInfoLabel, patientNameOutputLabel, patientSSNOutputLabel, patientDOBOutputLabel;

		/* Fields for getting input from the user */
		private JTextField ssnLookupInput, firstNameInput, lastNameInput, dobInput;	


		/*********************************************************************************
		* Main constructor for setting up the patient lookup menu. 
		*********************************************************************************/
		public Patient_Lookup_Panel() 
		{
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			initializeLabels();
			initializeButtons();
			initializeTextFields();
			addActionListeners();

			// add the components to the panel
			add(patientLookupLabel);
			//add(recordLookupLabel);
			add(enterSSNLabel);
			add(ssnLookupInput);
			add(ssnLookupButton);

			add(enterFirstNameLabel);
			add(firstNameInput);

			add(enterLastNameLabel);
			add(lastNameInput);

			add(enterDOBLabel);
			add(dobInput);

			add(infoLookupButton);
			//add(recordLookupButton);
			//add(mainMenuButton);
		}


		/*********************************************************************************
		* Initializes the labels for the Patient lookup menu.
		*********************************************************************************/
		private void initializeLabels()
		{
			patientLookupLabel = new JLabel("Patient Lookup");
			//recordLookupLabel = new JLabel("Record Lookup");

			enterSSNLabel = new JLabel("by ssn:");

			enterFirstNameLabel = new JLabel("by first:");
			enterLastNameLabel = new JLabel("by last:");

			enterDOBLabel = new JLabel("dob:");
		}


		/*********************************************************************************
		* Initializes the buttons for the patient lookup menu.
		*********************************************************************************/
		private void initializeButtons()
		{
			ssnLookupButton = new JButton("Submit");
			infoLookupButton = new JButton("Submit");
			//recordLookupButton = new JButton("Submit");
			//mainMenuButton = new JButton("Main Menu");
		}


		/*********************************************************************************
		* Initializes the textfields for the patient lookup menu.
		*********************************************************************************/
		private void initializeTextFields()
		{
			ssnLookupInput = new JTextField(10);
			firstNameInput = new JTextField(10);
			lastNameInput = new JTextField(10);
			dobInput = new JTextField(10);
		}


		/*********************************************************************************
		* Adds the action listeners for the patient lookup menu.
		*********************************************************************************/
		private void addActionListeners()
		{
			/* Add functionality - Lookup a patient based on ssn */
			ssnLookupButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    	String ssn = getSSNData();
			    	if (ssn != null)
			    	{
			    		// pass the ssn data to a method that lookups patient data and returns it as a string
			    		// String patientData = getPatientData(ssn);
			    		//displayPatientData(patientData); 
			    	}
			    	else
			    	{
			    		// display error message somewhere
			    	}
			  }
			});

			/* Add functionality - Submit info button */
			infoLookupButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			   		
			  }
			});
		}


		/*********************************************************************************
		* Returns the input in the "lookup patient by ssn" field.
		*********************************************************************************/
		private String getSSNData()
		{
			try 
			{
				return ssnLookupInput.getText();
			} 
			catch (Exception e) 
			{
				return null;
			}
		}


		/*********************************************************************************
		* Fills the patient display fields with a patient's data.
		*********************************************************************************/
		private void displayPatientData(String data)
		{

		}

	} // end patient lookup class


}