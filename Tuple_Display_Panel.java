import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/*****************************************************************************************************
* Displays to the user the passed in tuples and their attribute names in a table, row by row.
*****************************************************************************************************/
public class Tuple_Display_Panel extends JPanel
{
	protected int num_attributes;


	/***************************************************************************************
	* Main constructor, passed in tuples are seperated by tabs and each attribute value of
	* a tuple is seperated by whitespace. 
	*
	* Null values should be indicated by special values such as 'NULL' so they can be 
	* identified.
	***************************************************************************************/
	public Tuple_Display_Panel(String[] attributes, String tuples)
	{
		num_attributes = attributes.length;

		setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));

		add(new Attributes_Panel(attributes));

		Scanner scanner = new Scanner(tuples).useDelimiter("\t"); // assume each tuple is seperated by tab

		// create a new panel for each tuple
		while(scanner.hasNext()) 
		{
			add(new Attributes_Panel(scanner.next()));
		}


	}

	/***************************************************************************************
	* Displays to the user the passed in tuple as a set of labels in a jpanel.
	***************************************************************************************/
	private class Attributes_Panel extends JPanel
	{

		/***************************************************************************
		* Default constructor for the Attributes_Panel class.
		***************************************************************************/
		public Attributes_Panel(String[] attributes)
		{
			for(int i = 0; i < attributes.length; i++)
			{
				add(new Centered_Text_Panel(attributes[i]));
			}	
		}


		/***************************************************************************
		* Displays to the user the passed in results for Treatments, row by row.
		***************************************************************************/
		public Attributes_Panel(String row)
		{
			Scanner scanner = new Scanner(row);

			for(int i = 0; i < num_attributes && scanner.hasNext(); i++)
			{
				add(new Centered_Text_Panel(scanner.next()));
			}	
		}
	}
}