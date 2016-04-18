import java.sql.*;
import java.util.*;

public class Nurse extends DataRecord
{
    /**
     * Takes as a parameter a string that contains all the info of a Nurse and populates a Nurse instance appropriately
     */
    public Nurse(String s)
    {
        //Just call the super constructor to set info to be the supplied string
        super(s);
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
     * Deletes a Nurse from the database where the string parameter is the primary key of the nurse to be deleted
     */
    public void delete(String s)
    {
        String delete = "delete from NURSE where Nssn = " + s;
        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);  
        }
        catch(Exception e)
        {   
            e.printStackTrace();
        }
    }

    /**
     * Searches the database to get information about a particular Nurse, info will contain the primary key of NURSE
     * in this case. It will return a string containing the information requested in the search.
     */
    public String search(String table)
    {
        String query = "";
        String result = "";
        try{
            Statement stmt = conn.createStatement();

            //Construct a select query using the appropriate key and table to search
            if(table.equals("NURSE"))   //If you're searching the Nurse table using the Nssn then you'll return all the info about the requested Nurse
            {
                query = "select * from NURSE where Nssn = " + info;

                //The results from the original search query will be in here
                ResultSet rs = stmt.executeQuery(query);

                //We likely also want to get the actual name of the supervising doctor instead of just the ssn
                rs.next();
                String superSsn = rs.getString("supervisor");

                String superQuery = "select Fname, Minit, Lname from DOCTOR where Dssn = " + superSsn;

                ResultSet drName = stmt.executeQuery(superQuery);

                //We then use the result set to generate the string that will be returned to the user depending on the type of query
                rs.next();
                drName.next();

                while(!rs.isAfterLast())
                {
                    //Build the string to return the Nurse Information
                    String nName = "Nurse Name: " + rs.getString("Fname") + " " + rs.getString("Minit") + " " + rs.getString("Lname");
                    String supervisor = "Supervisor Name: " + drName.getString("Fname") + " " + drName.getString("Minit") + " " + drName.getString("Lname");

                    result = nName + "\n" + supervisor;
                }
            }
            else if(table.equals("PROCEDURE"))  //If you're searching the Procedure table using the Nssn then you'll return info about 
            {                                   //the procedures that the nurse is assisting with
                query = "select * from PROCEDURE where Nssn = " + info;

                //The results from the search query will be in here
                ResultSet rs = stmt.executeQuery(query);

                rs.next();

                while(!rs.isAfterLast())
                {
                    //Get the name of the patient undergoing the procedure
                    String pQuery = "select Fname, Minit, Lname from PATIENT where Pssn = " + rs.getString("Pssn");
                    ResultSet p = stmt.executeQuery(pQuery);
                    p.next();
                    String patientName = p.getString("Fname") + " " + p.getString("Minit") + " " + p.getString("Lname");

                    //Get the name of the Dr involved in the procedure
                    String dQuery = "select Fname, Minit, Lname from DOCTOR where Dssn = " + rs.getString("Dssn");
                    ResultSet d = stmt.executeQuery(dQuery);
                    d.next();
                    String docName = d.getString("Fname") + " " + d.getString("Minit") + " " + d.getString("Lname");

                    String procedure = "Procedure type: " + rs.getString("procedureDescription") + ", Date/Time: " + rs.getDate("scheduled_Date") + " " + rs.getInt("scheduled_Time") + ":00, Supervising Doctor: " + docName + ", Patient: " + patientName + "\n";

                    result = result + procedure;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
