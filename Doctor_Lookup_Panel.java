import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A display for the user to lookup Doctors in the database.
*****************************************************************************************************/
public class Doctor_Lookup_Panel extends JPanel 
{
	/* Panel for displaying output data - deleted and re-added afer every click of 'submit' */
	private JPanel doctor_output_panel;

	/* Fields for getting input from the user */
	private JTextField ssn_field;	
	private String ssn;



	/*********************************************************************************
	* Main constructor for setting up the Doctor lookup menu. 
	*********************************************************************************/
	public Doctor_Lookup_Panel() 
	{
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                JPanel top = new JPanel();
		// add the components to the panel
		top.add(new Centered_Text_Panel("Doctor Lookup"));
                //add(new JLabel(""));
		top.add(new Centered_Text_Panel("by: SSN"));
                add(top);
                
                JPanel bottom = new JPanel();
		bottom.add(ssn_field = new JTextField(9));
                bottom.add(new Submit_Button());
                add(bottom);

		add(doctor_output_panel = new Doctor_Info_Output());
	}


	/*********************************************************************************
	* Display new output information for a doctor, if any output is currently being
	* displayed, remove it first.
	*********************************************************************************/
	protected void displayNewDoctorOutput(JPanel output)
	{	
		if(doctor_output_panel != null)
			remove(doctor_output_panel);

		add(doctor_output_panel = output);

		revalidate();
		repaint();
	}


	/******************************************************************************
	* Submit button for Doctor_Lookup_Panel class.
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
					// get input from ssn field into ssn string variable
					loadText();

					// pass input into Doctor instance to modify tuple
					Doctor doc = new Doctor(ssn);

					String result = doc.search("DOCTOR");
                                        
                                        String[] values = result.split("\n");

					// extract fields from string and pass to doctor:
					displayNewDoctorOutput(new Doctor_Info_Output(values)); 
				}
			});
		}

		/******************************************************************
		* Load input from ssn field into corresponding string variable.
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

			// if this point is reached age and ssn were successfully retrieved
			return true;

		}

	} // end Submit_Button class



	/*********************************************************************************
	* Panel for displaying Doctor info output data based on input data from the user.
	*********************************************************************************/
	protected class Doctor_Info_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Doctor_Info_Output, initializing empty results.
		***********************************************************************/
		public Doctor_Info_Output()
		{
			add(new Centered_Text_Panel("Doctor Info:"));
		}
                
                /***********************************************************************
		* Primary constructor for Doctor_Info_Output.
		***********************************************************************/
		public Doctor_Info_Output(String[] result)
		{
			setLayout(new GridLayout(result.length + 1, 1));

			add(new Centered_Text_Panel("Doctor Info:"));
                        for(int i = 0; i < result.length; i++)
                        {
                            add(new JLabel(result[i]));
                        }
			
		}

		/***********************************************************************
		* Primary constructor for Doctor_Info_Output.
		***********************************************************************/
		public Doctor_Info_Output(String result)
		{
			setLayout(new GridLayout(2, 1));

			add(new Centered_Text_Panel("Doctor Info:"));
			//add(new Centered_Text_Panel(""));
			//add(new Centered_Text_Panel(result);
			add(new JTextField(result));
		}


	} // end Doctor_Info_Output class




} // end Doctor lookup class