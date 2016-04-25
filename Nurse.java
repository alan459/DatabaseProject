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
        try 
        {
            String[] values = s.split("\t");
            if(values.length == 3)
            {
            String query = "UPDATE Nurse SET Fname=?,Minit=?,Lname=? WHERE Nssn = (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,values[0]);
            pstmt.setString(2,values[1]);
            pstmt.setString(3,values[2]);
            pstmt.setString(4,info);

            int affectedRows = pstmt.executeUpdate();
                if(affectedRows == 0)
                { System.err.println("Failed to update to Nurse info.");} 
                else 
                { System.out.println("\tSuccessfully updated Nurse info. \n");}
                
            pstmt.close();
            }
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new Nurse into the database using the info contained in the string  
     */
    public static void insert(String s)
    {
        try 
        {
            String Template = "INSERT INTO Nurse (Nssn,Fname,Minit,Lname,supervisor) VALUES (?,?,?,?,?)";
            String[] values = s.split("\t");
                if(values.length == 5)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setString(4,values[3]);
                    pstmt.setString(5,values[4]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Nurses table.");} 
                    else 
                    { System.out.println("\n Successfully inserted new Nurse. \n");}
                pstmt.close();
                }
        }
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
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
     * Searches the database to get information about a particular Nurse, including name and supervisor.
     */
    private String searchNurse()
    {
        String result = "";
        try 
        {
            String query = "SELECT * FROM Nurse WHERE Nssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String nurseInfo = "Nurse: " + rs.getString("Fname") + " " + rs.getString("Minit") + " " + rs.getString("Lname")+ "\n";


            String supervisorSsn = rs.getString("supervisor");
            String supervisorQuery = "SELECT * FROM Doctor WHERE Dssn = ?";
            PreparedStatement ps2 = conn.prepareStatement(supervisorQuery);
            ps2.setString(1,supervisorSsn);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next(); 
            String supervisorInfo = "Supervisor: " + rs2.getString("Fname") + " " + rs2.getString("Minit") + " " + rs2.getString("Lname") + "\n";
            
            
            result = nurseInfo + supervisorInfo;
            
            
            rs.close();
            rs2.close();
            ps.close(); 
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Searches the database to get information about a particular Nurse's scheduled procedures.
     */
    private String searchProcedure()
    {
        String result = "";
        try 
        {
            String query = "SELECT * FROM Procedure WHERE Nssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            String queryP = "SELECT Fname,Minit,Lname FROM Patient WHERE Pssn = ?";
            PreparedStatement psP = conn.prepareStatement(queryP);
            
            String queryD = "SELECT Fname, Minit, Lname FROM Doctor WHERE Dssn = ?";
            PreparedStatement psD = conn.prepareStatement(queryD);
            
            while(!rs.isAfterLast())
                {   
                    // Get the name of the patient undergoing the current procedure
                    psP.setString(1, rs.getString("Pssn"));
                    ResultSet p = psP.executeQuery();
                    p.next();
                    String patientName = p.getString("Fname") + " " + p.getString("Minit") + " " + p.getString("Lname");

                    //Get the name of the Dr involved in the procedure
                    psD.setString(1, rs.getString("Dssn"));
                    ResultSet d = psD.executeQuery();
                    d.next();
                    String docName = d.getString("Fname") + " " + d.getString("Minit") + " " + d.getString("Lname");

                    String procedure = "Procedure Type: " + rs.getString("procedureDescription") + "\n"
                            + "Date/Time: " + rs.getDate("scheduled_Date") + " "+ rs.getInt("scheduled_Time") + ":00"+ "\n"
                            + "Supervising Doctor: " + docName + "\n"
                            + "Patient: " + patientName + "\n\n";
                    result = result + procedure;
                    
                    rs.next();
                    p.close();
                    d.close();
                }
            
            rs.close();
            ps.close(); 
            psP.close();
            psD.close();
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Searches the database to get information about a particular Nurse, info will contain the primary key of NURSE
     * in this case. It will return a string containing the information requested in the search.
     */
    public String search(String table)
    {
        String result = "";
            //Construct a select query using the appropriate key and table to search
            if(table.equals("NURSE"))   //If you're searching the Nurse table using the Nssn then you'll return all the info about the requested Nurse
            {
                result = searchNurse();
            }
            else if(table.equals("PROCEDURE"))  //If you're searching the Procedure table using the Nssn then you'll return info about 
            {                                   //the procedures that the nurse is assisting with
                result = searchProcedure();
            }
        return result;
    }
}
