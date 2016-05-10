//package hos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/****************************************************************************************************************
* An interactive interface to interact with a hospital database.
****************************************************************************************************************/
public class Hospital_Frame extends JFrame 
{
	public static final int WIDTH = 850;
	public static final int HEIGHT = 750;

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
                DataRecord.setUpConnection();
	}



	/*****************************************************************************************************
	* Creates a jpanel with the frame displaying the main menu options and sets it as the main screen.
	*****************************************************************************************************/
	public void createMainWindow()
	{
		add(currentScreen = new Main_Menu_Panel(this));
	}


	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the passed in menu.
	*****************************************************************************************************/
	public void changeScreen(JPanel menu)
	{	
		remove(currentScreen);

		add(currentScreen = menu); 

		revalidate();
		repaint();
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

		add(currentScreen = new Main_Menu_Panel(this)); 
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
		//if(currentScreen != null)
		remove(currentScreen);

		add(currentScreen = new Patient_Menu_Panel(this)); 

		revalidate();
		repaint();
	}




	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the doctor menu.
	*****************************************************************************************************/
	public void getDoctorMenu()
	{
		remove(currentScreen);

		add(currentScreen = new Doctor_Menu_Panel(this)); 

		revalidate();

		repaint();
	}



	/*****************************************************************************************************
	* Removes the current screen and sets the current screen to the nurse menu.
	*****************************************************************************************************/
	public void getNurseMenu()
	{
		remove(currentScreen);

		add(currentScreen = new Nurse_Menu_Panel(this)); 

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
	


}