import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hospital_Frame extends JFrame 
{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;

	private JPanel currentScreen;

	public Hospital_Frame() 
	{
		setTitle("Hospital");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	// center the window
		
		createMainWindow();

		setVisible(true);
	}


	/**
	* Creates a jpanel with the frames displaying the main window options/menu and sets it as the main screen.
	**/
	public void createMainWindow()
	{
		add(currentScreen = new Main_Menu_Panel());
	}


	/**
	* Fetches the data in the data fields and returns them in a tab-delimited string.
	* (and checks for correct formatting?)
	**/
	public String getDataFields() 
	{
		return "";
	}


	/**
	* Gets and returns the selected relation in the drop down menu
	**/
	public String getDataType() 
	{
		return "";
	}


	/**
	* Removes the current screen and sets the current screen to the main menu.
	**/
	public void getMainMenu()
	{
		remove(currentScreen);

		add(currentScreen = new Main_Menu_Panel()); 

		revalidate();

		repaint();
	}


	/**
	* Removes the current screen and sets the current screen to the patient menu.
	**/
	public void getPatientMenu()
	{
		remove(currentScreen);

		add(currentScreen = new Patient_Menu_Panel()); 

		revalidate();
		repaint();
	}

	/**
	* Removes the current screen and sets the current screen to the doctor menu.
	**/
	public void getDoctorMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();

		repaint();
	}


	/**
	* Removes the current screen and sets the current screen to the nurse menu.
	**/
	public void getNurseMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();

		repaint();
	}


	/**
	* Represents an instance of a main menu to display on the JFrame.
	**/
	private class Main_Menu_Panel extends JPanel 
	{

		private JButton patientButton, doctorButton, nurseButton;
		private JLabel recordSearchLabel;

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


		private void intializeLabels()
		{
			recordSearchLabel = new JLabel("Record Search");
		}

		private void initializeButtons()
		{
			patientButton = new JButton("Patient");
			doctorButton = new JButton("Doctor");
			nurseButton = new JButton("Nurse");
		}

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


	private class Patient_Menu_Panel extends JPanel 
	{
		private JButton ssnLookupButton, infoLookupButton, recordLookupButton, mainMenuButton;
		private JLabel patientLookupLabel, recordLookupLabel;
		private JLabel enterSSNLabel;
		private JTextField ssnLookupInput;


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


		private void intializeLabels()
		{
			patientLookupLabel = new JLabel("Patient Lookup");
			recordLookupLabel = new JLabel("Record Lookup");

			enterSSNLabel = new JLabel("Enter patient ssn: ");
		}


		private void initializeButtons()
		{
			ssnLookupButton = new JButton("Submit");
			infoLookupButton = new JButton("Submit");
			recordLookupButton = new JButton("Submit");
			mainMenuButton = new JButton("Main Menu");
		}


		private void initializeTextFields()
		{
			ssnLookupInput = new JTextField(10);
		}


		private void addActionListeners()
		{
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


			mainMenuButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			   		getMainMenu();
			  }
			});
		}


		private String getSSNData()
		{
			try {
				return ssnLookupInput.getText();
			} catch (Exception e) {
				return null;
			}
		}

	}


	public static void main(String[] args)
	{
		Hospital_Frame frame = new Hospital_Frame();
	}


}