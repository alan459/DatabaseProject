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
	* Represents an instance of a patient menu to displaying to the user the options for interacting with 
	* the patient relation.
	*****************************************************************************************************/
	private class Patient_Menu_Panel extends JPanel 
	{
		/* Input submission buttons */
		private JButton updateInfoButton, recordLookupButton, modifyTreatmentButton, mainMenuButton;	


		/*********************************************************************************
		* Main constructor used for setting up the patient menu options.
		*********************************************************************************/
		public Patient_Menu_Panel() 
		{
			initializeButtons();
			addActionListeners();

			// add the components to the panel
			add(updateInfoButton);
			add(recordLookupButton);
			add(modifyTreatmentButton);

			add(mainMenuButton);
		}


		/*********************************************************************************
		* Initializes the buttons for the patient menu.
		*********************************************************************************/
		private void initializeButtons()
		{
			updateInfoButton = new JButton("UPDATE PATIENT INFO");
			recordLookupButton = new JButton("PATIENT RECORD LOOKUP");
			modifyTreatmentButton = new JButton("MODIFY TREATMENT PLAN");

			mainMenuButton = new JButton("Main Menu");
		}


		/*********************************************************************************
		* Adds the action listeners for the patient menu.
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

			/* Add functionality - Take user to patient record lookup interface */
			recordLookupButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	getPatientLookupMenu();
			  }
			});

			/* Add functionality - Take user to modofy treatment plan interface */
			modifyTreatmentButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  }
			});

			/* Add functionality - Return user to main menu */
			mainMenuButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	getMainMenu();
			  }
			});
		}

	} // end patient menu class



	/*****************************************************************************************************
	* A display for the user to lookup patients in the database.
	*****************************************************************************************************/
	private class Patient_Lookup_Panel extends JPanel 
	{
		/* Input submission buttons */
		private JButton ssnLookupButton, infoLookupButton, recordLookupButton, mainMenuButton;	

		/* Main labels for the options on this screen - largest text blocks */
		private JLabel patientLookupLabel, recordLookupLabel;	

		/* Display to the user what type of information is being displayed in the adjacent position */
		private JLabel enterSSNLabel, enterFirstNameLabel, enterLastNameLabel, enterDOBLabel, patientInfoLabel;	

		/* Labels for displaying output data */
		private JLabel patientNameOutputLabel, patientSSNOutputLabel, patientDOBOutputLabel;

		/* Fields for getting input from the user */
		private JTextField ssnLookupInput, firstNameInput, lastNameInput, dobInput;	


		/*********************************************************************************
		* Main constructor for setting up the patient lookup menu. 
		*********************************************************************************/
		public Patient_Lookup_Panel() 
		{
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
			add(mainMenuButton);
		}


		/*********************************************************************************
		* Initializes the labels for the Patient lookup menu.
		*********************************************************************************/
		private void initializeLabels()
		{
			patientLookupLabel = new JLabel("Patient Lookup");
			recordLookupLabel = new JLabel("Record Lookup");

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
			recordLookupButton = new JButton("Submit");
			mainMenuButton = new JButton("Main Menu");
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

			/* Add functionality - Return to main menu option */
			mainMenuButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			   		getMainMenu();
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
		* Fills the patient search fields with a patient's data.
		*********************************************************************************/
		private void displayPatientData(String data)
		{

		}

	} // end patient lookup class


}