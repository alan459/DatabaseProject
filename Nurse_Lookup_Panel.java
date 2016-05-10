import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************************************************
* A display for the user to lookup Nurses in the database.
*****************************************************************************************************/
public class Nurse_Lookup_Panel extends JPanel 
{
	/* Panel for displaying output data - deleted and re-added afer every click of 'submit' */
	private JPanel nurse_output_panel;

	/* Fields for getting input from the user */
	private JTextField ssn_field;	
	private String ssn;



	/*********************************************************************************
	* Main constructor for setting up the Nurse lookup menu. 
	*********************************************************************************/
	public Nurse_Lookup_Panel() 
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel top = new JPanel();
		// add the components to the panel
		top.add(new Centered_Text_Panel("Nurse Lookup"));
                //add(new JLabel(""));
		top.add(new Centered_Text_Panel("by: SSN"));
                add(top);
                
                JPanel bottom = new JPanel();
		bottom.add(ssn_field = new JTextField(9));
                bottom.add(new Submit_Button());
                add(bottom);

		add(nurse_output_panel = new Nurse_Info_Output());
               

	}


	/*********************************************************************************
	* Display new output information for a Nurse, if any output is currently being
	* displayed, remove it first.
	*********************************************************************************/
	protected void displayNewNurseOutput(JPanel output)
	{	
		if(nurse_output_panel != null)
			remove(nurse_output_panel);

		add(nurse_output_panel = output);

		revalidate();
		repaint();
	}


	/******************************************************************************
	* Submit button for Nurse_Lookup_Panel class.
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

					// pass input into Nurse instance to modify tuple
					Nurse doc = new Nurse(ssn);

					String result = doc.search("NURSE");
                                        
                                        String[] values = result.split("\n");

					// extract fields from string and pass to Nurse:
					displayNewNurseOutput(new Nurse_Info_Output(values)); 
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
	* Panel for displaying Nurse info output data based on input data from the user.
	*********************************************************************************/
	protected class Nurse_Info_Output extends JPanel
	{
		/***********************************************************************
		* Default constructor for Nurse_Info_Output, initializing empty results.
		***********************************************************************/
		public Nurse_Info_Output()
		{
			add(new Centered_Text_Panel("Nurse Info:"));
			
		}


		/***********************************************************************
		* Primary constructor for Nurse_Info_Output.
		***********************************************************************/
		public Nurse_Info_Output(String result)
		{
			setLayout(new GridLayout(2, 1));

			add(new Centered_Text_Panel("Nurse Info:"));
			//add(new Centered_Text_Panel(""));
			//add(new Centered_Text_Panel(result);
			add(new JTextField(result));
		}
                
                /***********************************************************************
		* Primary constructor for Nurse_Info_Output.
		***********************************************************************/
		public Nurse_Info_Output(String[] result)
		{
			setLayout(new GridLayout(result.length + 1, 1));
                        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

			add(new Centered_Text_Panel("Nurse Info:"));
                        for(int i = 0; i < result.length; i++)
                        {
                            add(new JLabel(result[i]));
                        }
			
		}



	} // end Nurse_Info_Output class




	/*********************************************************************************
	* Initializes the textfields for the Nurse lookup menu.
	*********************************************************************************/
	private void initializeTextFields()
	{
		ssn_field = new JTextField(10);
	}


} // end Nurse lookup class