import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/***************************************************************************************************************
* An interactive interface to interact with a hospital database.
***************************************************************************************************************/
public class Hospital_Frame extends JFrame 
{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;

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
		remove(currentScreen);

		add(currentScreen = new Patient_Menu_Panel()); 

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

	}

	/*****************************************************************************************************
	* Represents an instance of a patient menu to display on the JFrame.
	*****************************************************************************************************/
	private class Patient_Menu_Panel extends JPanel 
	{
		/* Input submission buttons */
		private JButton ssnLookupButton, infoLookupButton, recordLookupButton, mainMenuButton;	

		/* Main labels for the options on this screen - largest text blocks */
		private JLabel patientLookupLabel, recordLookupLabel;	

		/* Display to the user what type of information is being displayed in the adjacent position */
		private JLabel enterSSNLabel, patientInfoLabel;	

		/* Labels for displaying output data */
		private JLabel patientNameOutputLabel, patientSSNOutputLabel, patientDOBOutputLabel;

		/* Fields for getting input from the user */
		private JTextField ssnLookupInput;	


		/*********************************************************************************
		* Represents an instance of a main menu to display on the JFrame.
		*********************************************************************************/
		public Patient_Menu_Panel() 
		{
			initializeLabels();

			initializeButtons();

			initializeTextFields();

			addActionListeners();

			// add the components to the panel
			add(patientLookupLabel);
			add(recordLookupLabel);

			add(enterSSNLabel);
			add(ssnLookupButton);
			add(infoLookupButton);
			add(recordLookupButton);
			add(mainMenuButton);
		}


		/*********************************************************************************
		* Initializes the labels for this panel.
		*********************************************************************************/
		private void intializeLabels()
		{
			patientLookupLabel = new JLabel("Patient Lookup");
			recordLookupLabel = new JLabel("Record Lookup");

			enterSSNLabel = new JLabel("Enter patient ssn: ");
		}


		/*********************************************************************************
		* Initializes the buttons for this panel.
		*********************************************************************************/
		private void initializeButtons()
		{
			ssnLookupButton = new JButton("Submit");
			infoLookupButton = new JButton("Submit");
			recordLookupButton = new JButton("Submit");
			mainMenuButton = new JButton("Main Menu");
		}


		/*********************************************************************************
		* Initializes the textfields for this panel.
		*********************************************************************************/
		private void initializeTextFields()
		{
			ssnLookupInput = new JTextField(10);
		}


		/*********************************************************************************
		* Adds the action listeners for the patient menu.
		*********************************************************************************/
		private void addActionListeners()
		{
			// lookup a patient based on ssn
			ssnLookupButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    	String ssn = getSSNData();
			    	if (ssn != null)
			    	{
			    		// pass the ssn data to a method that lookups patient data and returns it as a string
			    		String patientData = getPatientData(ssn);
			    		displayPatientData(patientData); 
			    	}
			    	else
			    	{
			    		// display error message somewhere
			    	}
			  }
			});

			// return to main menu option
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
			try {
				return ssnLookupInput.getText();
			} catch (Exception e) {
				return null;
			}
		}

		/*********************************************************************************
		* Fills the patient search fields with a patient's data.
		*********************************************************************************/
		private void displayPatientData(String data)
		{

		}

	}

	/*****************************************************************************************************
	* Main method to start/run the program.
	*****************************************************************************************************/
	public static void main(String[] args)
	{
		Hospital_Frame frame = new Hospital_Frame();
	}


}