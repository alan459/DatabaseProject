import java.sql.*;
import java.util.*;

public class Nurse extends Data_Record
{
	/**
	* Takes as a parameter a string that contains all the info of a Nurse and populates a Nurse instance appropriately
	*/
	public Nurse(String s, Connection conn)
	{
		//Just call the super constructor to set info to be the supplied string
		super(s, conn);
	}

	/**
	* Performs an update in the Nurse table using the information provided in an info string	
	*/
	public void update(String s)
	{

	}

	/**
	* Inserts a new Nurse into the database using the info contained in the string	
	*/
	public void insert(String s)
	{

	}

	/**
	* Deletes a Nurse from the database
	*/
	public void delete(String s)
	{

	}

	/**
	* Searches the database to get information about a particular Nurse, info will contain the primary key of NURSE
	* in this case. It will return a string containing the information requested in the search.
	*/
	public String search(String table)
	{
		Statement stmt = conn.createStatement();
		String query = "";

		//Construct a select query using the appropriate key and table to search
		if(table.equals("NURSE"))	//If you're searching the Nurse table using the Nssn then you'll return all the info about the requested Nurse
		{
			query = "select * from NURSE where Nssn = " + info;

			//The results from the original search query will be in here
			ResultSet rs = conn.executeQuery(query);

			//We likely also want to get the actual name of the supervising doctor instead of just the ssn
			rs.next();
			String superSsn = rs.getString("supervisor");

			String superQuery = "select Fname, Minit, Lname from DOCTOR where Dssn = " + superSsn;

			ResultSet drName = conn.executeQuery(superQuery);

			//We then use the result set to generate the string that will be returned to the user depending on the type of query
			rs.next();
			drName.next();

			while(!rs.isAfterLast())
			{
				//Build the string to return the Nurse Information
				String nName = rs.getString("Fname") + " " + rs.getString("Minit") + " " + rs.getString("Lname");
				String supervisor = drName.getString("Fname") + " " + drName.getString("Minit") + " " + drName.getString("Lname");
			}

			
		}
		else if(table.equals("PROCEDURE"))	//If you're searching the Procedure table using the Nssn then you'll return info about 
		{									//the procedures that the nurse is assisting with
			query = "select * from PROCEDURE where Nssn = " + info;

			//The results from the search query will be in here
			ResultSet rs = conn.executeQuery(query);
		}
		
		

		
	}
