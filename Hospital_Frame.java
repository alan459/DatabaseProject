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
	* Creates a jpanel with the frames displaying the main window options/menu.
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

	public void getPatientMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();
		repaint();
	}


	public void getDoctorMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();
		repaint();
	}


	public void getNurseMenu()
	{
		remove(currentScreen);

		add(new Patient_Menu_Panel()); 

		revalidate();
		repaint();
	}

	private class Main_Menu_Panel extends JPanel 
	{

		private JButton patientButton, doctorButton, nurseButton;
		private JLabel recordSearchLabel;

		public Main_Menu_Panel() 
		{
			recordSearchLabel = new JLabel("Record Search");

			patientButton = new JButton("Patient");
			doctorButton = new JButton("Doctor");
			nurseButton = new JButton("Nurse");

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


			add(recordSearchLabel);
			add(patientButton);
			add(doctorButton);
			add(nurseButton);

		}
	}


	private class Patient_Menu_Panel extends JPanel 
	{

		private JButton ssnLookupButton, infoLookupButton, recordLookupButton;
		private JLabel patientLookupLabel, recordLookupLabel;

		public Patient_Menu_Panel() 
		{
			patientLookupLabel = new JLabel("Patient Lookup");
			recordLookupLabel = new JLabel("Record Lookup");

			ssnLookupButton = new JButton("Submit");
			infoLookupButton = new JButton("Submit");
			recordLookupButton = new JButton("Submit");

			ssnLookupButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    		    
			  }
			});


			add(patientLookupLabel);
			add(recordLookupLabel);
			add(ssnLookupButton);
			add(infoLookupButton);
			add(recordLookupButton);

		}
	}


	public static void main(String[] args)
	{
		Hospital_Frame frame = new Hospital_Frame();
	}


}